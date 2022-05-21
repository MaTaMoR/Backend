package me.matamor.backend.controllers.impl.review;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.controllers.api.review.ReviewController;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.filter.review.ReviewFilter;
import me.matamor.backend.models.page.PageResponse;
import me.matamor.backend.models.page.PageableMapper;
import me.matamor.backend.models.page.response.PageableResponse;
import me.matamor.backend.models.review.Review;
import me.matamor.backend.models.review.ReviewMapper;
import me.matamor.backend.models.review.ReviewRequest;
import me.matamor.backend.models.review.ReviewResponse;
import me.matamor.backend.services.review.ReviewService;
import me.matamor.backend.util.validation.SimpleValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReviewControllerImpl implements ReviewController {

    private final ReviewService reviewService;
    private final SimpleValidator validator;
    private final ReviewMapper reviewMapper;
    private final PageableMapper pageableMapper;

    @Override
    public ResponseEntity<ReviewResponse> find(Long id) {
        Review review = this.reviewService.findById(id);
        if (review == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            ReviewResponse response = this.reviewMapper.toResponse(review);
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<PageResponse<ReviewResponse>> find(@Valid FilterRequest<ReviewRequest> request) {
        if (this.validator.isValid(request.getFilter(), request.getPage())) {
            //Create the filter using the request
            ReviewFilter filter = this.reviewMapper.toFilter(request.getFilter());
            PageRequest pageRequest = this.pageableMapper.toRequest(request.getPage());

            //Filter repository
            Page<Review> result = this.reviewService.findByFilterPaged(filter, pageRequest);

            //Map result to response
            List<ReviewResponse> resultContent = result.getContent().stream()
                    .map(this.reviewMapper::toResponse)
                    .collect(Collectors.toList());

            PageableResponse resultPageable = this.pageableMapper.toResponse(result);

            //Create page result
            PageResponse<ReviewResponse> response = new PageResponse<>(resultContent, resultPageable);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
