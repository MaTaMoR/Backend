package me.matamor.backend.auth;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.auth.requests.AuthRegisterUserRequest;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.models.permissions.role.RoleResponse;
import me.matamor.backend.models.user.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-21T19:17:43+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public User toEntity(AuthRegisterUserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.getUsername() );
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

        authUserResponse.setUsername( entity.getUsername() );
        authUserResponse.setName( entity.getName() );
        authUserResponse.setSurnames( entity.getSurnames() );
        authUserResponse.setEmail( entity.getEmail() );
        authUserResponse.setRoles( roleListToRoleResponseList( entity.getRoles() ) );

        return authUserResponse;
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setName( role.getName() );

        return roleResponse;
    }

    protected List<RoleResponse> roleListToRoleResponseList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleResponse> list1 = new ArrayList<RoleResponse>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleResponse( role ) );
        }

        return list1;
    }
}
