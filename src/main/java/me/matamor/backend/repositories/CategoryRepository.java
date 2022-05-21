package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.category.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends BasicJpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE LOWER(c.name) = LOWER(:name)")
    Category findByName(@Param("name") String name);

}
