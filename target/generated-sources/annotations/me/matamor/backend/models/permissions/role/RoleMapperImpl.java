package me.matamor.backend.models.permissions.role;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.models.permissions.privilege.Privilege;
import me.matamor.backend.models.permissions.privilege.PrivilegeMapper;
import me.matamor.backend.models.permissions.privilege.PrivilegeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T12:36:50+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    private final PrivilegeMapper privilegeMapper;

    @Autowired
    public RoleMapperImpl(PrivilegeMapper privilegeMapper) {

        this.privilegeMapper = privilegeMapper;
    }

    @Override
    public RoleResponse toResponse(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        if ( entity.getId() != null ) {
            roleResponse.setId( String.valueOf( entity.getId() ) );
        }
        roleResponse.setName( entity.getName() );
        roleResponse.setPrivileges( privilegeListToPrivilegeResponseList( entity.getPrivileges() ) );

        return roleResponse;
    }

    protected List<PrivilegeResponse> privilegeListToPrivilegeResponseList(List<Privilege> list) {
        if ( list == null ) {
            return null;
        }

        List<PrivilegeResponse> list1 = new ArrayList<PrivilegeResponse>( list.size() );
        for ( Privilege privilege : list ) {
            list1.add( privilegeMapper.toResponse( privilege ) );
        }

        return list1;
    }
}
