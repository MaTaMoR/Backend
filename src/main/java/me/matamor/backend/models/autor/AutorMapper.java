package me.matamor.backend.models.autor;

import me.matamor.backend.filter.autor.AutorFilter;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AutorMapper {

    Autor toEntity(AutorRequest request);

    AutorFilter toFilter(AutorRequest request);

    AutorResponse toResponse(Autor autor);

}
