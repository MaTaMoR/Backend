package me.matamor.backend.auth;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.auth.requests.AuthLoginRequest;
import me.matamor.backend.auth.requests.AuthRegisterUserRequest;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.auth.response.AuthResponse;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class JwtAuthController {

    private final JwtTokenUtil tokenUtil;
    private final UserService userService;
    private final AuthMapper authMapper;
    private final AuthenticationManagerProvider authenticationManagerProvider;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(HttpServletRequest httpServlet, @RequestBody @Valid AuthLoginRequest request) {
        try {
            Authentication authentication = authenticate(httpServlet, request.getUsername(), request.getPassword());
            String token = this.tokenUtil.generateToken(authentication);

            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/register")
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
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/validate")
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
