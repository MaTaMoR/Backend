package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.permissions.privilege.Privilege;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrivilegeRepository extends BasicJpaRepository<Privilege, Long> {

    @Query("SELECT p FROM Privilege p WHERE LOWER(p.name) = LOWER(:name)")
    Privilege findByName(@Param("name") String name);

}
