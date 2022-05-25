package me.matamor.backend.controllers.api.book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.models.book.BookRequest;
import me.matamor.backend.models.book.BookResponse;
import me.matamor.backend.models.page.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/books")
public interface BookController {

    @GetMapping("/search/{id}")
    @Operation(summary = "Get a Book using it's id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book found"),
            @ApiResponse(responseCode = "404", description = "Book not found")})
    ResponseEntity<BookResponse> find(@PathVariable("id") Long id);

    @PostMapping("/search/filter")
    @Operation(summary = "Get books using a filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filter result"),
            @ApiResponse(responseCode = "400", description = "Invalid request")})
    ResponseEntity<PageResponse<BookResponse>> find(@RequestBody @Valid FilterRequest<BookRequest> request);

}
