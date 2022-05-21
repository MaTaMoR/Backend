package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends BasicJpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    User findFirstByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
    User findFirstByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE (LOWER(u.username) = LOWER(:username) OR LOWER(u.email) = LOWER(:email))")
    User findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

}
