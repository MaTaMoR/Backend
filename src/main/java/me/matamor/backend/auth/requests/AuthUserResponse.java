package me.matamor.backend.auth.requests;

import lombok.*;
import me.matamor.backend.models.permissions.role.RoleResponse;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserResponse {

    private String username;
    private String name;
    private String surnames;
    private String email;

    private List<RoleResponse> roles;

}
