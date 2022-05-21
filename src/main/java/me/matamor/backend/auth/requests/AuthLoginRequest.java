package me.matamor.backend.auth.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AuthLoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
