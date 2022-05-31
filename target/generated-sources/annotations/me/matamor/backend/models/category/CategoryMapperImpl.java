package me.matamor.backend.models.category;

import javax.annotation.processing.Generated;
import me.matamor.backend.filter.category.CategoryFilter;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-31T14:14:27+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        Category category = new Category();

        if ( request.getId() != null ) {
            category.setId( Long.parseLong( request.getId() ) );
        }
        category.setName( request.getName() );

        return category;
    }

    @Override
    public CategoryFilter toFilter(CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        CategoryFilter.CategoryFilterBuilder categoryFilter = CategoryFilter.builder();

        if ( request.getId() != null ) {
            categoryFilter.id( Long.parseLong( request.getId() ) );
        }
        categoryFilter.name( request.getName() );
        categoryFilter.nameCriteria( request.getNameCriteria() );

        return categoryFilter.build();
    }

    @Override
    public CategoryResponse toResponse(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        if ( entity.getId() != null ) {
            categoryResponse.setId( String.valueOf( entity.getId() ) );
        }
        categoryResponse.setName( entity.getName() );

        return categoryResponse;
    }
}
