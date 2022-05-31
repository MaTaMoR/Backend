package me.matamor.backend.models.permissions.role;

import lombok.*;
import me.matamor.backend.models.permissions.privilege.PrivilegeResponse;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {

    private String id;
    private String name;

    private List<PrivilegeResponse> privileges;

}
