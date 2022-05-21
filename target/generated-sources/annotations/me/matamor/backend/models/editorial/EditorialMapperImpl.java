package me.matamor.backend.models.editorial;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-21T19:17:43+0200",
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
    public EditorialResponse toResponse(Editorial entity) {
        if ( entity == null ) {
            return null;
        }

        EditorialResponse editorialResponse = new EditorialResponse();

        editorialResponse.setId( String.valueOf( entity.getId() ) );
        editorialResponse.setName( entity.getName() );

        return editorialResponse;
    }
}
