package me.matamor.backend.models.editorial;

import me.matamor.backend.filter.editorial.EditorialFilter;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EditorialMapper {

    Editorial toEntity(EditorialRequest request);

    EditorialFilter toFilter(EditorialRequest request);

    EditorialResponse toResponse(Editorial entity);

}
