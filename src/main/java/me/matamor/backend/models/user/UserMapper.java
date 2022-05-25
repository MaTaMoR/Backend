package me.matamor.backend.models.user;

import me.matamor.backend.models.image.ImageMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {ImageMapper.class})
public interface UserMapper {

    User toEntity(UserRequest request);

    UserResponse toResponse(User entity);

}
