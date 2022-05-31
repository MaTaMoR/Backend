package me.matamor.backend;

import me.matamor.backend.services.autor.AutorService;
import me.matamor.backend.services.book.BookService;
import me.matamor.backend.services.category.CategoryService;
import me.matamor.backend.services.editorial.EditorialService;
import me.matamor.backend.services.like.LikeService;
import me.matamor.backend.services.permissions.privileges.PrivilegeService;
import me.matamor.backend.services.permissions.role.RoleService;
import me.matamor.backend.services.review.ReviewService;
import me.matamor.backend.services.user.UserService;
import me.matamor.backend.upload.ImageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
@ConfigurationPropertiesScan("me.matamor.backend.configs")
public class Backend {

    public static void main(String[] args) {
        SpringApplication.run(Backend.class, args);
    }

    private Date toDate(String fecha) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        } catch (ParseException e) {
            return null;
        }
    }

    @Bean
    public CommandLineRunner initData(CategoryService categoryService, EditorialService editorialService, AutorService autorService, BookService bookService, ImageService imageService,
                                      LikeService likeService, UserService userService, ReviewService reviewService, PrivilegeService privilegeService, RoleService roleService) {
        return args -> {

        };
    }
}
