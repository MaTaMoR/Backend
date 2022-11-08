package me.matamor.backend.auth.requests;

import lombok.*;
import me.matamor.backend.models.image.Image;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserUpdate {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 16)
    private String username;

    @NotBlank
    @Size(min = 3, max = 16)
    private String name;

    @NotBlank
    @Size(min = 3, max = 32)
    private String surnames;

    @NotBlank
    @Email
    private String email;

    @Nullable
    private String password;

    @Nullable
    private Image image;

}
