package me.matamor.backend.models.image;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-31T14:14:27+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageResponse toResponse(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageResponse imageResponse = new ImageResponse();

        if ( image.getId() != null ) {
            imageResponse.setId( String.valueOf( image.getId() ) );
        }
        imageResponse.setName( image.getName() );
        imageResponse.setType( image.getType() );

        return imageResponse;
    }
}
