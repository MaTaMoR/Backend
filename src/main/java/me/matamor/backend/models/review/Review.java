package me.matamor.backend.models.review;

import lombok.*;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.image.Image;
import me.matamor.backend.models.likes.Like;
import me.matamor.backend.models.user.User;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reviews")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private long id;

    @NotNull
    @ManyToOne
    private User autor;

    @NotNull
    @ManyToOne
    private Book book;

    @NotBlank
    @Column(name = "review", length = 10000)
    private String review;

    @NotNull
    @ManyToOne
    private Image image;

    @Range(min = 1, max = 5)
    @Column(name = "score")
    private int score;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "review_date")
    private Date reviewDate;

    @OneToMany
    private List<Like> likes;

    public Review(User autor, Book book, String review, Image image, int score) {
        this.autor = autor;
        this.book = book;
        this.review = review;
        this.image = image;
        this.score = score;
        this.likes = new ArrayList<>();
    }
}
