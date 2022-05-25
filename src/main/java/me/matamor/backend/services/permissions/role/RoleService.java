package me.matamor.backend.services.permissions.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.repositories.RoleRepository;
import me.matamor.backend.services.BasicService;
import me.matamor.backend.services.permissions.privileges.PrivilegeService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class RoleService implements BasicService<Role, RoleRepository> {

    private final RoleRepository repository;
    private final PrivilegeService privilegeService;

    public Role getOrCreate(String name) {
        Role role = this.repository.findByName(name);
        if (role == null) {
            role = save(new Role(name, this.privilegeService.getDefaultPrivileges()));
        }

        return role;
    }
}
