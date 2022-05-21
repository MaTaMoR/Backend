package me.matamor.backend.services.review;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.review.Review;
import me.matamor.backend.repositories.ReviewRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class ReviewService implements BasicService<Review, ReviewRepository> {

    private final ReviewRepository repository;

}
