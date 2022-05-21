package me.matamor.backend.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AuthResponse {

    @NotBlank
    private String token;

}
