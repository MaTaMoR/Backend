package me.matamor.backend.models.review;

import lombok.*;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.models.book.BookResponse;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private String id;
    private AuthUserResponse autor;
    private BookResponse book;
    private String review;
    private String image;
    private int score;
    private Date reviewDate;

}
