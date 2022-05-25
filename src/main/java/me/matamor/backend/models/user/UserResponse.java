package me.matamor.backend.models.user;

import lombok.*;
import me.matamor.backend.models.image.Image;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String name;
    private String surnames;
    private Image image;

}
