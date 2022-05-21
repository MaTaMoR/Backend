package me.matamor.backend.controllers.api.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.models.page.PageResponse;
import me.matamor.backend.models.review.ReviewRequest;
import me.matamor.backend.models.review.ReviewResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/reviews")
public interface ReviewController {

    @GetMapping("/search/{id}")
    @Operation(summary = "Get a Review using it's id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review found"),
            @ApiResponse(responseCode = "404", description = "Review not found")})
    ResponseEntity<ReviewResponse> find(@RequestParam("id") Long id);

    @PostMapping("/search/filter")
    @Operation(summary = "Get reviews using a filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Filter result"),
            @ApiResponse(responseCode = "400", description = "Invalid request")})
    ResponseEntity<PageResponse<ReviewResponse>> find(@RequestBody @Valid FilterRequest<ReviewRequest> request);

}
