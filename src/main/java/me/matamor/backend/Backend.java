package me.matamor.backend;

import me.matamor.backend.filter.autor.AutorFilter;
import me.matamor.backend.filter.book.BookFilter;
import me.matamor.backend.filter.category.CategoryFilter;
import me.matamor.backend.filter.editorial.EditorialFilter;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.book.type.BookType;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.permissions.privilege.Privilege;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.models.review.Review;
import me.matamor.backend.models.user.User;
import me.matamor.backend.services.autor.AutorService;
import me.matamor.backend.services.book.BookService;
import me.matamor.backend.services.category.CategoryService;
import me.matamor.backend.services.editorial.EditorialService;
import me.matamor.backend.services.like.LikeService;
import me.matamor.backend.services.permissions.privileges.PrivilegeService;
import me.matamor.backend.services.permissions.role.RoleService;
import me.matamor.backend.services.review.ReviewService;
import me.matamor.backend.services.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONTokener;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
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
    public CommandLineRunner initData(CategoryService categoryService, EditorialService editorialService, AutorService autorService, BookService bookService,
                                      LikeService likeService, UserService userService, ReviewService reviewService, PrivilegeService privilegeService, RoleService roleService) {
        return args -> {
            Privilege editPrivilege = privilegeService.save(new Privilege("EDIT"));

            Role adminRole = roleService.save(new Role("ADMIN", List.of(editPrivilege)));
            Role userRole = roleService.save(new Role("USER", new ArrayList<>()));

            User user = userService.register(new User("matamor", "Santiago", "González Londoño", "", "matamor98@hotmail.com", "1234", List.of(adminRole)));

            JSONTokener parser = new JSONTokener(Files.readString(new ClassPathResource("data.json", getClass().getClassLoader()).getFile().toPath()));
            JSONObject rawData = (JSONObject) parser.nextValue();

            //Libros
            JSONArray booksData = (JSONArray) rawData.get("Books");
            for (int i = 0; booksData.length() > i; i++) {
                JSONObject bookData = booksData.getJSONObject(i);

                //Autor
                JSONObject autorData = bookData.getJSONObject("autor");
                String autorName = autorData.getString("name");
                String autorSurnames = autorData.getString("surnames");

                Autor autor = autorService.findOneByFilter(AutorFilter.builder()
                        .name(autorName)
                        .surnames(autorSurnames)
                        .build());

                if (autor == null) {
                    autor = autorService.save(new Autor(autorName, autorSurnames));
                }

                //Editorial
                JSONObject editorialData = bookData.getJSONObject("editorial");
                String editorialName = editorialData.getString("name");
                String editorialImage = editorialData.getString("image");

                Editorial editorial = editorialService.findOneByFilter(EditorialFilter.builder()
                        .name(editorialName)
                        .build());

                if (editorial == null) {
                    editorial = editorialService.save(new Editorial(editorialName, editorialImage));
                }

                //Categorias
                List<Category> categories = new ArrayList<>();
                JSONArray categoriesData = bookData.getJSONArray("categories");
                for (int j = 0; categoriesData.length() > j; j++) {
                    JSONObject categoryData = categoriesData.getJSONObject(j);
                    String categoryName = categoryData.getString("name");

                    Category category = categoryService.findOneByFilter(CategoryFilter.builder()
                            .name(categoryName)
                            .build());

                    if (category == null) {
                        category = categoryService.save(new Category(categoryName));
                    }

                    categories.add(category);
                }

                //Libro
                String title = bookData.getString("title");
                String description = bookData.getString("description");
                BookType bookType = BookType.valueOf(bookData.getString("bookType"));
                Date publishedDate = toDate(bookData.getString("publishedDate"));
                int totalPages = Integer.parseInt(bookData.getString("totalPages"));
                String image = bookData.getString("image");

                Book book = new Book(title, description, bookType, publishedDate, totalPages, image, autor, editorial, categories);
                bookService.save(book);
            }

            //Reviews
            JSONArray reviewsData = rawData.getJSONArray("Reviews");
            for (int i = 0; reviewsData.length() > i; i++) {
                JSONObject reviewData = reviewsData.getJSONObject(i);

                String bookTitle = reviewData.getString("book");
                Book book = bookService.findOneByFilter(BookFilter.builder()
                        .title(bookTitle)
                        .build());

                String review = reviewData.getString("review");
                String image = reviewData.getString("image");
                int score = Integer.parseInt(reviewData.getString("score"));

                reviewService.save(new Review(user, book, review, image, score));
            }
        };
    }
}
