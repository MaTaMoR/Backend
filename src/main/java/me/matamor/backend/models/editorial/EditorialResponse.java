package me.matamor.backend.models.editorial;

import lombok.*;
import me.matamor.backend.models.image.Image;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EditorialResponse {

    private String id;
    private String name;
    private Image image;

}
