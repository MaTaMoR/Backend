package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.editorial.Editorial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EditorialRepository extends BasicJpaRepository<Editorial, Long> {

    @Query("SELECT e FROM Editorial e WHERE LOWER(e.name) = LOWER(:name)")
    Editorial findByName(@Param("name") String name);

}
