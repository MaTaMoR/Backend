package me.matamor.backend.models.permissions.privilege;

import me.matamor.backend.models.permissions.role.RoleMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {RoleMapper.class})
public interface PrivilegeMapper {

    PrivilegeResponse toResponse(Privilege privilege);

}
