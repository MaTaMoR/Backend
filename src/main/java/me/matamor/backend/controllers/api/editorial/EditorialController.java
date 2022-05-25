package me.matamor.backend.controllers.api.editorial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.models.editorial.EditorialRequest;
import me.matamor.backend.models.editorial.EditorialResponse;
import me.matamor.backend.models.page.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/editorials")
public interface EditorialController {

    @GetMapping("/search/{id}")
    @Operation(summary = "Get a Editorial using it's id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Editorial found"),
            @ApiResponse(responseCode = "404", description = "Editorial not found")})
    ResponseEntity<EditorialResponse> find(@PathVariable("id") Long id);

    @PostMapping("/search/filter")
    @Operation(summary = "Get editoriales using a filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filter result"),
            @ApiResponse(responseCode = "400", description = "Invalid request")})
    ResponseEntity<PageResponse<EditorialResponse>> find(@RequestBody @Valid FilterRequest<EditorialRequest> request);

}
