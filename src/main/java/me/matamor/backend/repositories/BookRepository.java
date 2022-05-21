package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.book.type.BookType;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.editorial.Editorial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends BasicJpaRepository<Book, Long> {

    @Query("SELECT l FROM Book l WHERE LOWER(l.title) = LOWER(:title)")
    Book findByTitle(@Param("title") String title);

    @Query("SELECT l FROM Book l WHERE l.bookType = :bookType")
    List<Book> findByBookType(@Param("bookType") BookType bookType);

    @Query("SELECT l FROM Book l WHERE l.autor = :autor")
    List<Book> findByAutor(@Param("autor") Autor autor);

    @Query("SELECT l FROM Book l WHERE :category MEMBER l.categories")
    List<Book> findByCategory(@Param("category") Category category);

    @Query("SELECT l FROM Book l WHERE l.editorial = :editorial")
    List<Book> findByEditorial(@Param("editorial") Editorial editorial);

}
