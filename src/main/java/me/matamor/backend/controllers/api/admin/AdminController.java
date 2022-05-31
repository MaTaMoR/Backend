package me.matamor.backend.controllers.api.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.autor.AutorResponse;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.book.BookResponse;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.category.CategoryResponse;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.editorial.EditorialResponse;
import me.matamor.backend.models.review.Review;
import me.matamor.backend.models.review.ReviewResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/admin")
public interface AdminController {

    @PostMapping("/books/update-or-create")
    @Operation(summary = "Update a Book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book updated"),
            @ApiResponse(responseCode = "404", description = "Book not updated")})
    ResponseEntity<BookResponse> updateOrCreate(@RequestBody @Valid Book book);

    @DeleteMapping("/books/delete/{id}")
    @Operation(summary = "Delete a Book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book deleted")
    })
    void deleteBook(@PathVariable("id") Long id);

    @PostMapping("/reviews/update-or-create")
    @Operation(summary = "Update a Review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review updated"),
            @ApiResponse(responseCode = "404", description = "Review not updated")})
    ResponseEntity<ReviewResponse> updateOrCreate(@RequestBody @Valid Review review);

    @DeleteMapping("/reviews/delete/{id}")
    @Operation(summary = "Delete a Review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review deleted")
    })
    void deleteReview(@PathVariable("id") Long id);

    @PostMapping("/autors/update-or-create")
    @Operation(summary = "Update a Autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autor updated"),
            @ApiResponse(responseCode = "404", description = "Autor not updated")})
    ResponseEntity<AutorResponse> updateOrCreate(@RequestBody @Valid Autor autor);

    @DeleteMapping("/autors/delete/{id}")
    @Operation(summary = "Delete a Autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autor deleted")
    })
    void deleteAutor(@PathVariable("id") Long id);

    @PostMapping("/categories/update-or-create")
    @Operation(summary = "Update a Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category updated"),
            @ApiResponse(responseCode = "404", description = "Category not updated")})
    ResponseEntity<CategoryResponse> updateOrCreate(@RequestBody @Valid Category category);

    @DeleteMapping("/categories/delete/{id}")
    @Operation(summary = "Delete a Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category deleted")
    })
    void deleteCategory(@PathVariable("id") Long id);

    @PostMapping("/editorials/update-or-create")
    @Operation(summary = "Update a Editorial")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Editorial updated"),
            @ApiResponse(responseCode = "404", description = "Editorial not updated")})
    ResponseEntity<EditorialResponse> updateOrCreate(@RequestBody @Valid Editorial editorial);

    @DeleteMapping("/editorials/delete/{id}")
    @Operation(summary = "Delete a Editorial")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Editorial deleted")
    })
    void deleteEditorial(@PathVariable("id") Long id);
}
