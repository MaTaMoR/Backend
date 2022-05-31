package me.matamor.backend.models.editorial;

import javax.annotation.processing.Generated;
import me.matamor.backend.filter.editorial.EditorialFilter;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-31T14:14:28+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class EditorialMapperImpl implements EditorialMapper {

    @Override
    public Editorial toEntity(EditorialRequest request) {
        if ( request == null ) {
            return null;
        }

        Editorial editorial = new Editorial();

        if ( request.getId() != null ) {
            editorial.setId( Long.parseLong( request.getId() ) );
        }
        editorial.setName( request.getName() );

        return editorial;
    }

    @Override
    public EditorialFilter toFilter(EditorialRequest request) {
        if ( request == null ) {
            return null;
        }

        EditorialFilter.EditorialFilterBuilder editorialFilter = EditorialFilter.builder();

        editorialFilter.nameCriteria( request.getNameCriteria() );
        if ( request.getId() != null ) {
            editorialFilter.id( Long.parseLong( request.getId() ) );
        }
        editorialFilter.name( request.getName() );

        return editorialFilter.build();
    }

    @Override
    public EditorialResponse toResponse(Editorial entity) {
        if ( entity == null ) {
            return null;
        }

        EditorialResponse editorialResponse = new EditorialResponse();

        if ( entity.getId() != null ) {
            editorialResponse.setId( String.valueOf( entity.getId() ) );
        }
        editorialResponse.setName( entity.getName() );
        editorialResponse.setImage( entity.getImage() );

        return editorialResponse;
    }
}
