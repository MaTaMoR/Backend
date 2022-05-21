package me.matamor.backend.services.permissions.role;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.repositories.RoleRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class RoleService implements BasicService<Role, RoleRepository> {

    private final RoleRepository repository;

}
