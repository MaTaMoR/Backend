package me.matamor.backend.models.image;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {

    private String id;
    private String name;
    private String type;

}
