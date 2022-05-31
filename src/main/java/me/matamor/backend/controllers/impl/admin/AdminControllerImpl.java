package me.matamor.backend.controllers.impl.admin;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.controllers.api.admin.AdminController;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.autor.AutorMapper;
import me.matamor.backend.models.autor.AutorResponse;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.book.BookMapper;
import me.matamor.backend.models.book.BookResponse;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.category.CategoryMapper;
import me.matamor.backend.models.category.CategoryResponse;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.editorial.EditorialMapper;
import me.matamor.backend.models.editorial.EditorialResponse;
import me.matamor.backend.models.review.Review;
import me.matamor.backend.models.review.ReviewMapper;
import me.matamor.backend.models.review.ReviewResponse;
import me.matamor.backend.services.autor.AutorService;
import me.matamor.backend.services.book.BookService;
import me.matamor.backend.services.category.CategoryService;
import me.matamor.backend.services.editorial.EditorialService;
import me.matamor.backend.services.review.ReviewService;
import me.matamor.backend.util.validation.SimpleValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {

    private final SimpleValidator validator;

    private final BookMapper bookMapper;
    private final BookService bookService;

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;

    private final AutorMapper autorMapper;
    private final AutorService autorService;

    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    private final EditorialMapper editorialMapper;
    private final EditorialService editorialService;

    @Override
    public ResponseEntity<ReviewResponse> updateOrCreate(Review review) {
        if (this.validator.isValid(review)) {
            ReviewResponse response = this.reviewMapper.toResponse(this.reviewService.save(review));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public void deleteReview(Long id) {
        this.reviewService.delete(id);
    }

    @Override
    public ResponseEntity<BookResponse> updateOrCreate(Book book) {
        if (this.validator.isValid(book)) {
            BookResponse response = this.bookMapper.toResponse(this.bookService.save(book));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public void deleteBook(Long id) {
        this.bookService.delete(id);
    }

    @Override
    public ResponseEntity<AutorResponse> updateOrCreate(Autor autor) {
        if (this.validator.isValid(autor)) {
            AutorResponse response = this.autorMapper.toResponse(this.autorService.save(autor));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public void deleteAutor(Long id) {
        this.autorService.delete(id);
    }

    @Override
    public ResponseEntity<CategoryResponse> updateOrCreate(Category category) {
        if (this.validator.isValid(category)) {
            CategoryResponse response = this.categoryMapper.toResponse(this.categoryService.save(category));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public void deleteCategory(Long id) {
        this.categoryService.delete(id);
    }

    @Override
    public ResponseEntity<EditorialResponse> updateOrCreate(Editorial editorial) {
        if (this.validator.isValid(editorial)) {
            EditorialResponse response = this.editorialMapper.toResponse(this.editorialService.save(editorial));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public void deleteEditorial(Long id) {
        this.editorialService.delete(id);
    }
}
