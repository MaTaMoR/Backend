package me.matamor.backend.controllers.impl.auth;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.auth.AuthMapper;
import me.matamor.backend.auth.AuthenticationManagerProvider;
import me.matamor.backend.auth.JwtTokenUtil;
import me.matamor.backend.auth.requests.AuthLoginRequest;
import me.matamor.backend.auth.requests.AuthRegisterUserRequest;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.auth.requests.AuthUserUpdate;
import me.matamor.backend.auth.response.AuthResponse;
import me.matamor.backend.controllers.api.auth.AuthController;
import me.matamor.backend.models.user.User;
import me.matamor.backend.services.permissions.role.RoleService;
import me.matamor.backend.services.user.UserService;
import me.matamor.backend.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final JwtTokenUtil tokenUtil;
    private final UserService userService;
    private final AuthMapper authMapper;
    private final AuthenticationManagerProvider authenticationManagerProvider;
    private final RoleService roleService;

    @Override
    public ResponseEntity<AuthResponse> login(HttpServletRequest httpServlet, @RequestBody @Valid AuthLoginRequest request) {
        try {
            Authentication authentication = authenticate(httpServlet, request.getUsername(), request.getPassword());
            String token = this.tokenUtil.generateToken(authentication);

            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public ResponseEntity<AuthResponse> register(HttpServletRequest httpServlet, @RequestBody @Valid AuthRegisterUserRequest request) {
        User user = this.userService.findByUsernameOrEmail(request.getUsername(), request.getEmail());
        if (user == null) {
            user = this.authMapper.toEntity(request);
            user.setRoles(List.of(this.roleService.getOrCreate(Constants.USER)));

            this.userService.register(user);

            try {
                Authentication authentication = authenticate(httpServlet, request.getUsername(), request.getPassword());
                String token = this.tokenUtil.generateToken(authentication);

                return ResponseEntity.ok(new AuthResponse(token));
            } catch (AuthenticationException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public ResponseEntity<AuthUserResponse> validate(@RequestBody String token) {
        try {
            String username = this.tokenUtil.getUsernameFromToken(token);
            User user = this.userService.findByUsername(username);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            AuthUserResponse response = this.authMapper.toResponse(user);
            return ResponseEntity.ok(response);
        } catch (JwtException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<AuthUserResponse> update(@RequestHeader("Authorization") String token, @RequestBody @Valid AuthUserUpdate user) {
        if (user.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //Comprobamos que el usuario exista, este endpoint no es para registrarse
        User oldUser = this.userService.findById(user.getId());
        if (oldUser == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //Check the token is not expired
        if (this.tokenUtil.isTokenExpired(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else if (!oldUser.getUsername().equals(this.tokenUtil.getUsernameFromToken(token))) { //Check is the same username
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        //No se puede cambiar el username o email
        if (!oldUser.getUsername().equals(user.getUsername()) || !oldUser.getEmail().equals(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //Ponemos la información en el usuario
        this.authMapper.setData(user, oldUser);

        AuthUserResponse response = this.authMapper.toResponse(this.userService.save(oldUser));
        return ResponseEntity.ok(response);
    }

    private Authentication authenticate(HttpServletRequest httpServlet, String username, String password) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authenticationManagerProvider.authenticationManager().authenticate(authRequest);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        HttpSession httpSession = httpServlet.getSession(true);
        httpSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

        return authentication;
    }
}
