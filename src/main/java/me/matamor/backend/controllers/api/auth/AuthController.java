package me.matamor.backend.controllers.api.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.matamor.backend.auth.requests.AuthLoginRequest;
import me.matamor.backend.auth.requests.AuthRegisterUserRequest;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.auth.requests.AuthUserUpdate;
import me.matamor.backend.auth.response.AuthResponse;
import me.matamor.backend.models.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("/auth")
public interface AuthController {

    @PostMapping("/login")
    @Operation(summary = "Login with an account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logged in successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid login")})
    ResponseEntity<AuthResponse> login(HttpServletRequest httpServlet, @RequestBody @Valid AuthLoginRequest request);

    @PostMapping("/register")
    @Operation(summary = "Login with your account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid account")})
    ResponseEntity<AuthResponse> register(HttpServletRequest httpServlet, @RequestBody @Valid AuthRegisterUserRequest request);

    @PostMapping("/validate")
    @Operation(summary = "Validates account token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Validation was successful"),
            @ApiResponse(responseCode = "400", description = "Invalid token")})
    ResponseEntity<AuthUserResponse> validate(@RequestBody String token);

    @PostMapping("/update")
    @Operation(summary = "Update an account info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated account successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "400", description = "Invalid update")})
    ResponseEntity<AuthUserResponse> update(@RequestHeader("Authorization") String token, @RequestBody @Valid AuthUserUpdate user);

}
