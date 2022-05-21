package me.matamor.backend.models.book.serie;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookSerieMapper {

    BookSerie toEntity(BookSerieRequest request);

    BookSerieResponse toResponse(BookSerie entity);

}
