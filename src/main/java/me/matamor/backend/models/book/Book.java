package me.matamor.backend.models.book;

import lombok.*;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.book.type.BookType;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.image.Image;
import me.matamor.backend.models.likes.Like;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private long id;

    @NotBlank
    @ToString.Include
    @Size(min = 3, max = 64)
    @Column(name = "title")
    private String title;

    @NotBlank
    @ToString.Include
    @Size(max = 5000)
    @Column(name = "description")
    private String description;

    @NotNull
    @ToString.Include
    @Column(name = "book_type")
    private BookType bookType;

    @NotNull
    @ToString.Include
    @Column(name = "published_date")
    private Date publishedDate;

    @NotNull
    @Min(1)
    @ToString.Include
    @Column(name = "total_pages")
    private int totalPages;

    @NotNull
    @ToString.Include
    @ManyToOne
    private Image image;

    @NotNull
    @ManyToOne
    private Autor autor;

    @NotNull
    @ManyToOne
    private Editorial editorial;

    @NotNull
    @ManyToMany
    private List<Category> categories;

    @NotNull
    @OneToMany
    private List<Like> likes;

    public Book(String title, String description, BookType bookType, Date publishedDate, int totalPages, Image image, Autor autor, Editorial editorial, List<Category> categories) {
        this.title = title;
        this.description = description;
        this.bookType = bookType;
        this.publishedDate = publishedDate;
        this.totalPages = totalPages;
        this.image = image;
        this.autor = autor;
        this.editorial = editorial;
        this.categories = categories;
        this.likes = new ArrayList<>();
    }
}
