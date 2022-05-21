package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.permissions.role.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends BasicJpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE LOWER(r.name) = LOWER(:name)")
    Role findByName(@Param("name") String name);

}
