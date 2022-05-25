package me.matamor.backend.controllers.api.autor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.models.autor.AutorRequest;
import me.matamor.backend.models.autor.AutorResponse;
import me.matamor.backend.models.page.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/autors")
public interface AutorController {

    @GetMapping("/search/{id}")
    @Operation(summary = "Get a Autor using it's id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autor found"),
            @ApiResponse(responseCode = "404", description = "Autor not found")})
    ResponseEntity<AutorResponse> find(@PathVariable("id") Long id);

    @PostMapping("/search/filter")
    @Operation(summary = "Get autors using a filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filter result"),
            @ApiResponse(responseCode = "400", description = "Invalid request")})
    ResponseEntity<PageResponse<AutorResponse>> find(@RequestBody @Valid FilterRequest<AutorRequest> request);

}
