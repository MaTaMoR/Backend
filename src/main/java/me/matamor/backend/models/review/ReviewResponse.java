package me.matamor.backend.models.review;

import lombok.*;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.models.book.BookResponse;
import me.matamor.backend.models.image.ImageResponse;
import me.matamor.backend.models.likes.Like;
import me.matamor.backend.util.validation.ValidId;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    @ValidId
    private String id;
    private AuthUserResponse autor;
    private BookResponse book;
    private String review;
    private ImageResponse image;
    private int score;
    private Date reviewDate;

    private List<Like> likes;

}
