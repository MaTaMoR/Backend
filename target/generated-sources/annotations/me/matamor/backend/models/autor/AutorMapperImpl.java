package me.matamor.backend.models.autor;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-21T19:17:43+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class AutorMapperImpl implements AutorMapper {

    @Override
    public Autor toEntity(AutorRequest request) {
        if ( request == null ) {
            return null;
        }

        Autor autor = new Autor();

        if ( request.getId() != null ) {
            autor.setId( Long.parseLong( request.getId() ) );
        }
        autor.setName( request.getName() );
        autor.setSurnames( request.getSurnames() );

        return autor;
    }

    @Override
    public AutorResponse toResponse(Autor autor) {
        if ( autor == null ) {
            return null;
        }

        AutorResponse autorResponse = new AutorResponse();

        autorResponse.setId( String.valueOf( autor.getId() ) );
        autorResponse.setName( autor.getName() );
        autorResponse.setSurnames( autor.getSurnames() );

        return autorResponse;
    }
}
