package me.matamor.backend.filter.review;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.filter.book.BookFilter;
import me.matamor.backend.filter.user.UserFilter;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.review.Review;
import me.matamor.backend.models.review.Review_;
import me.matamor.backend.models.user.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewFilter implements RepositoryFilter<Review> {

    private Long id;
    private UserFilter user;
    private BookFilter book;
    private String review;
    private Integer score;
    private Date reviewDate;

    @Builder.Default
    private FilterCriteria reviewCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria scoreCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria reviewDateCriteria = FilterCriteria.EQUAL;

    @Override
    public Specification<Review> getSpecifications() {
        return new SpecificationBuilder<Review>()
                .add(getIdSpecification())
                .add(getUserSpecification())
                .add(getBookSpecification())
                .add(getReviewSpecification())
                .add(getScoreSpecification())
                .add(getReviewDateSpecification())
                .build();
    }

    private Specification<Review> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Review_.id), this.id));
    }

    private Specification<Review> getUserSpecification() {
        if (this.user == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            Subquery<User> subQuery = query.subquery(User.class);
            Root<User> autorRoot = subQuery.from(User.class);

            Predicate wherePredicate = criteriaBuilder.equal(root.get(Review_.autor), autorRoot);

            Specification<User> autorSpecification = this.user.getSpecifications();
            subQuery.select(autorRoot).where(wherePredicate, autorSpecification.toPredicate(autorRoot, query, criteriaBuilder));

            return criteriaBuilder.exists(subQuery);
        });
    }

    private Specification<Review> getBookSpecification() {
        if (this.book == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            Subquery<Book> subQuery = query.subquery(Book.class);
            Root<Book> bookRoot = subQuery.from(Book.class);

            Predicate wherePredicate = criteriaBuilder.equal(root.get(Review_.book), bookRoot);

            Specification<Book> autorSpecification = this.book.getSpecifications();
            subQuery.select(bookRoot).where(wherePredicate, autorSpecification.toPredicate(bookRoot, query, criteriaBuilder));

            return criteriaBuilder.exists(subQuery);
        });
    }

    private Specification<Review> getReviewSpecification() {
        if (this.review == null || this.review.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.reviewCriteria)) {
                return criteriaBuilder.equal(root.get(Review_.review), this.review);
            } else if (FilterCriteria.LIKE.equals(this.reviewCriteria)) {
                return criteriaBuilder.like(root.get(Review_.review), like(this.review));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'review' is not valid: " + this.reviewCriteria);
            }
        });
    }

    private Specification<Review> getScoreSpecification() {
        if (this.score == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.scoreCriteria)) {
                return criteriaBuilder.equal(root.get(Review_.score), this.score);
            } else if (FilterCriteria.GREATER.equals(this.scoreCriteria)) {
                return criteriaBuilder.greaterThan(root.get(Review_.score), this.score);
            } else if (FilterCriteria.GREATER_EQUAL.equals(this.scoreCriteria)) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(Review_.score), this.score);
            } else if (FilterCriteria.LESS.equals(this.scoreCriteria)) {
                return criteriaBuilder.lessThan(root.get(Review_.score), this.score);
            } else if (FilterCriteria.LESS_EQUAL.equals(this.scoreCriteria)) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(Review_.score), this.score);
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'score' is not valid: " + this.scoreCriteria);
            }
        });
    }

    private Specification<Review> getReviewDateSpecification() {
        if (this.reviewDate == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.reviewDateCriteria)) {
                return criteriaBuilder.equal(root.get(Review_.reviewDate), this.reviewDate);
            } else if (FilterCriteria.GREATER.equals(this.reviewDateCriteria)) {
                return criteriaBuilder.greaterThan(root.get(Review_.reviewDate), this.reviewDate);
            } else if (FilterCriteria.GREATER_EQUAL.equals(this.reviewDateCriteria)) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(Review_.reviewDate), this.reviewDate);
            } else if (FilterCriteria.LESS.equals(this.reviewDateCriteria)) {
                return criteriaBuilder.lessThan(root.get(Review_.reviewDate), this.reviewDate);
            } else if (FilterCriteria.LESS_EQUAL.equals(this.reviewDateCriteria)) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(Review_.reviewDate), this.reviewDate);
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'reviewDate' is not valid: " + this.reviewDateCriteria);
            }
        });
    }
}
