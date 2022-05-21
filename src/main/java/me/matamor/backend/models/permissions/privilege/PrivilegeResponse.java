package me.matamor.backend.models.permissions.privilege;

import lombok.*;
import me.matamor.backend.models.permissions.role.RoleResponse;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeResponse {

    private String name;
    private List<RoleResponse> roles;

}
