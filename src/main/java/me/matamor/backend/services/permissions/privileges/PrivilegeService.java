package me.matamor.backend.services.permissions.privileges;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.permissions.privilege.Privilege;
import me.matamor.backend.repositories.PrivilegeRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class PrivilegeService implements BasicService<Privilege, PrivilegeRepository> {

    private final PrivilegeRepository repository;

}
