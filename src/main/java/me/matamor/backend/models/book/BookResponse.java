package me.matamor.backend.models.book;

import lombok.*;
import me.matamor.backend.models.autor.AutorResponse;
import me.matamor.backend.models.book.type.BookType;
import me.matamor.backend.models.category.CategoryResponse;
import me.matamor.backend.models.editorial.EditorialResponse;
import me.matamor.backend.models.image.Image;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private String id;
    private String title;
    private String description;
    private BookType bookType;
    private Date publishedDate;
    private Integer totalPages;
    private Image image;

    private AutorResponse autor;
    private EditorialResponse editorial;
    private List<CategoryResponse> categories;

}
