package me.matamor.backend.models.permissions.role;

import me.matamor.backend.models.permissions.privilege.PrivilegeMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {PrivilegeMapper.class})
public interface RoleMapper {

    RoleResponse toResponse(Role entity);

}
