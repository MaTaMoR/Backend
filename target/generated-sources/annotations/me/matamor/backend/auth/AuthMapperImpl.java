package me.matamor.backend.auth;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.auth.requests.AuthRegisterUserRequest;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.auth.requests.AuthUserUpdate;
import me.matamor.backend.models.image.ImageMapper;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.models.permissions.role.RoleMapper;
import me.matamor.backend.models.permissions.role.RoleResponse;
import me.matamor.backend.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T12:36:50+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    private final ImageMapper imageMapper;
    private final RoleMapper roleMapper;

    @Autowired
    public AuthMapperImpl(ImageMapper imageMapper, RoleMapper roleMapper) {

        this.imageMapper = imageMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public User toEntity(AuthRegisterUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.getUsername() );
        user.setName( request.getName() );
        user.setSurnames( request.getSurnames() );
        user.setEmail( request.getEmail() );
        user.setPassword( request.getPassword() );

        return user;
    }

    @Override
    public AuthUserResponse toResponse(User entity) {
        if ( entity == null ) {
            return null;
        }

        AuthUserResponse authUserResponse = new AuthUserResponse();

        if ( entity.getId() != null ) {
            authUserResponse.setId( String.valueOf( entity.getId() ) );
        }
        authUserResponse.setUsername( entity.getUsername() );
        authUserResponse.setName( entity.getName() );
        authUserResponse.setSurnames( entity.getSurnames() );
        authUserResponse.setEmail( entity.getEmail() );
        authUserResponse.setImage( imageMapper.toResponse( entity.getImage() ) );
        authUserResponse.setRoles( roleListToRoleResponseList( entity.getRoles() ) );

        return authUserResponse;
    }

    @Override
    public void setData(AuthUserUpdate userUpdate, User user) {
        if ( userUpdate == null ) {
            return;
        }

        if ( userUpdate.getId() != null ) {
            user.setId( userUpdate.getId() );
        }
        if ( userUpdate.getUsername() != null ) {
            user.setUsername( userUpdate.getUsername() );
        }
        if ( userUpdate.getName() != null ) {
            user.setName( userUpdate.getName() );
        }
        if ( userUpdate.getSurnames() != null ) {
            user.setSurnames( userUpdate.getSurnames() );
        }
        if ( userUpdate.getEmail() != null ) {
            user.setEmail( userUpdate.getEmail() );
        }
        if ( userUpdate.getPassword() != null ) {
            user.setPassword( userUpdate.getPassword() );
        }
        if ( userUpdate.getImage() != null ) {
            user.setImage( userUpdate.getImage() );
        }
    }

    protected List<RoleResponse> roleListToRoleResponseList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleResponse> list1 = new ArrayList<RoleResponse>( list.size() );
        for ( Role role : list ) {
            list1.add( roleMapper.toResponse( role ) );
        }

        return list1;
    }
}
