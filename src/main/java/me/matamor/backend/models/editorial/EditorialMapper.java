package me.matamor.backend.models.editorial;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EditorialMapper {

    Editorial toEntity(EditorialRequest request);

    EditorialResponse toResponse(Editorial entity);
}
