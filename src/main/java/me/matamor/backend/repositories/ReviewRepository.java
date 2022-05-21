package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.review.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends BasicJpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.book = :book")
    Review findByBook(@Param("book") Book book);
}
