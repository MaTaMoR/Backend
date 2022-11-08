package me.matamor.backend.models.likes;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T12:36:50+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class LikeMapperImpl implements LikeMapper {

    @Override
    public LikeResponse toResponse(Like entity) {
        if ( entity == null ) {
            return null;
        }

        LikeResponse likeResponse = new LikeResponse();

        return likeResponse;
    }

    @Override
    public Like toEntity(LikeResponse response) {
        if ( response == null ) {
            return null;
        }

        Like like = new Like();

        return like;
    }
}
