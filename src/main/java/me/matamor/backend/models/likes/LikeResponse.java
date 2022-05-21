package me.matamor.backend.models.likes;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponse {

    private String id;
    private String contentId;
    private String userId;
    private Date date;

}
