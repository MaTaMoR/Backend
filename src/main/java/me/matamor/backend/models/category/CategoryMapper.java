package me.matamor.backend.models.category;

import me.matamor.backend.filter.category.CategoryFilter;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    Category toEntity(CategoryRequest request);

    CategoryFilter toFilter(CategoryRequest request);

    CategoryResponse toResponse(Category entity);

}
