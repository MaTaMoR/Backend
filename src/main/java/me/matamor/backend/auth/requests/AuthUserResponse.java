package me.matamor.backend.auth.requests;

import lombok.*;
import me.matamor.backend.models.image.ImageResponse;
import me.matamor.backend.models.permissions.role.RoleResponse;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserResponse {

    private String id;
    private String username;
    private String name;
    private String surnames;
    private String email;
    private ImageResponse image;

    private List<RoleResponse> roles;

}
