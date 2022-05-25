package me.matamor.backend.models.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T22:19:53+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        if ( request.getId() != null ) {
            user.setId( request.getId() );
        }
        user.setUsername( request.getUsername() );
        user.setName( request.getName() );
        user.setSurnames( request.getSurnames() );

        return user;
    }

    @Override
    public UserResponse toResponse(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( entity.getId() );
        userResponse.setUsername( entity.getUsername() );
        userResponse.setName( entity.getName() );
        userResponse.setSurnames( entity.getSurnames() );
        userResponse.setImage( entity.getImage() );

        return userResponse;
    }
}
