package me.matamor.backend.models.permissions.privilege;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T12:36:50+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class PrivilegeMapperImpl implements PrivilegeMapper {

    @Override
    public PrivilegeResponse toResponse(Privilege privilege) {
        if ( privilege == null ) {
            return null;
        }

        PrivilegeResponse privilegeResponse = new PrivilegeResponse();

        if ( privilege.getId() != null ) {
            privilegeResponse.setId( String.valueOf( privilege.getId() ) );
        }
        privilegeResponse.setName( privilege.getName() );

        return privilegeResponse;
    }
}
