package me.matamor.backend.models.review;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.models.book.BookRequest;
import me.matamor.backend.models.user.UserRequest;
import me.matamor.backend.util.validation.ValidId;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    @ValidId
    private String id;

    private UserRequest user;

    private BookRequest book;

    @Size(max = 10000)
    private String review;

    @Range(min = 1, max = 5)
    private Integer score;

    private Date fechaReview;

    private FilterCriteria reviewCriteria = FilterCriteria.EQUAL;
    private FilterCriteria scoreCriteria = FilterCriteria.EQUAL;
    private FilterCriteria reviewDateCriteria = FilterCriteria.EQUAL;

}