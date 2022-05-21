package me.matamor.backend.models.book;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.models.autor.AutorRequest;
import me.matamor.backend.models.book.type.BookType;
import me.matamor.backend.models.category.CategoryRequest;
import me.matamor.backend.models.editorial.EditorialRequest;
import me.matamor.backend.util.validation.ValidId;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @ValidId
    private String id;

    @Size(min = 1, max = 64)
    private String title;

    @Size(max = 5000)
    private String description;

    private BookType bookType;

    private Date publishedDate;

    @Range(min = 1, max = 999)
    private Integer totalPages;

    private AutorRequest autor;
    private EditorialRequest editorial;
    private List<CategoryRequest> categories;

    private FilterCriteria titleCriteria = FilterCriteria.EQUAL;
    private FilterCriteria descriptionCriteria = FilterCriteria.EQUAL;
    private FilterCriteria publishedDateCriteria = FilterCriteria.EQUAL;
    private FilterCriteria totalPagesCriteria = FilterCriteria.EQUAL;
    private FilterCriteria categoriesCriteria = FilterCriteria.AND;

}
