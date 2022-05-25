package me.matamor.backend.models.book.serie;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T22:19:53+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class BookSerieMapperImpl implements BookSerieMapper {

    @Override
    public BookSerie toEntity(BookSerieRequest request) {
        if ( request == null ) {
            return null;
        }

        BookSerie bookSerie = new BookSerie();

        if ( request.getId() != null ) {
            bookSerie.setId( Long.parseLong( request.getId() ) );
        }
        bookSerie.setNombre( request.getNombre() );

        return bookSerie;
    }

    @Override
    public BookSerieResponse toResponse(BookSerie entity) {
        if ( entity == null ) {
            return null;
        }

        BookSerieResponse bookSerieResponse = new BookSerieResponse();

        bookSerieResponse.setId( String.valueOf( entity.getId() ) );

        return bookSerieResponse;
    }
}
