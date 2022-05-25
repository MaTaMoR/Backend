package me.matamor.backend.models.book;

import me.matamor.backend.filter.book.BookFilter;
import me.matamor.backend.models.autor.AutorMapper;
import me.matamor.backend.models.book.serie.BookSerieMapper;
import me.matamor.backend.models.category.CategoryMapper;
import me.matamor.backend.models.editorial.EditorialMapper;
import me.matamor.backend.models.image.ImageMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {AutorMapper.class, EditorialMapper.class, CategoryMapper.class, BookSerieMapper.class, ImageMapper.class})
public interface BookMapper {

    Book toEntity(BookRequest request);

    BookFilter toFilter(BookRequest request);

    BookResponse toResponse(Book book);

}
