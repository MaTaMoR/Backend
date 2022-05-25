package me.matamor.backend.auth;

import me.matamor.backend.auth.requests.AuthRegisterUserRequest;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.models.image.ImageMapper;
import me.matamor.backend.models.permissions.role.RoleMapper;
import me.matamor.backend.models.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {ImageMapper.class, RoleMapper.class})
public interface AuthMapper {

    User toEntity(AuthRegisterUserRequest request);

    AuthUserResponse toResponse(User entity);

}
