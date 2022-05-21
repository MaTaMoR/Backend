package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.autor.Autor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AutorRepository extends BasicJpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE LOWER(a.name) = LOWER(:name)")
    Autor findByName(@Param("name") String name);

    @Query("SELECT a FROM Autor a WHERE LOWER(a.name) = LOWER(:name) OR LOWER(a.surnames) = LOWER(:surnames)")
    Autor findByNameOrSurnames(@Param("name") String name, @Param("surnames") String surnames);

    @Query("SELECT a FROM Autor a WHERE LOWER(a.name) = LOWER(:name) AND LOWER(a.surnames) = LOWER(:surnames)")
    Autor findByNameAndSurnames(@Param("name") String name, @Param("surnames") String surnames);

    @Query("SELECT a FROM Autor a WHERE CONCAT(LOWER(a.name), ' ', LOWER(a.surnames)) = LOWER(:fullname)")
    Autor findByFullName(@Param("fullname") String fullname);

}
