package me.matamor.backend.models.permissions.privilege;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.models.permissions.role.RoleMapper;
import me.matamor.backend.models.permissions.role.RoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T22:19:53+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class PrivilegeMapperImpl implements PrivilegeMapper {

    private final RoleMapper roleMapper;

    @Autowired
    public PrivilegeMapperImpl(RoleMapper roleMapper) {

        this.roleMapper = roleMapper;
    }

    @Override
    public PrivilegeResponse toResponse(Privilege privilege) {
        if ( privilege == null ) {
            return null;
        }

        PrivilegeResponse privilegeResponse = new PrivilegeResponse();

        privilegeResponse.setName( privilege.getName() );
        privilegeResponse.setRoles( roleListToRoleResponseList( privilege.getRoles() ) );

        return privilegeResponse;
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
