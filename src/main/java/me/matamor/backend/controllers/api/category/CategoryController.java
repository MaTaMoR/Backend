package me.matamor.backend.controllers.api.category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.models.category.CategoryRequest;
import me.matamor.backend.models.category.CategoryResponse;
import me.matamor.backend.models.page.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/categories")
public interface CategoryController {

    @GetMapping("/search/{id}")
    @Operation(summary = "Get a Category using it's id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found"),
            @ApiResponse(responseCode = "404", description = "Category not found")})
    ResponseEntity<CategoryResponse> find(@PathVariable("id") Long id);

    @PostMapping("/search/filter")
    @Operation(summary = "Get categories using a filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filter result"),
            @ApiResponse(responseCode = "400", description = "Invalid request")})
    ResponseEntity<PageResponse<CategoryResponse>> find(@RequestBody @Valid FilterRequest<CategoryRequest> request);

}
