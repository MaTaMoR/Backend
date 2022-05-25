package me.matamor.backend.models.book;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.filter.book.BookFilter;
import me.matamor.backend.filter.category.CategoryFilter;
import me.matamor.backend.models.autor.AutorMapper;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.category.CategoryMapper;
import me.matamor.backend.models.category.CategoryRequest;
import me.matamor.backend.models.category.CategoryResponse;
import me.matamor.backend.models.editorial.EditorialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T22:19:53+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    private final AutorMapper autorMapper;
    private final EditorialMapper editorialMapper;
    private final CategoryMapper categoryMapper;

    @Autowired
    public BookMapperImpl(AutorMapper autorMapper, EditorialMapper editorialMapper, CategoryMapper categoryMapper) {

        this.autorMapper = autorMapper;
        this.editorialMapper = editorialMapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Book toEntity(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        Book book = new Book();

        if ( request.getId() != null ) {
            book.setId( Long.parseLong( request.getId() ) );
        }
        book.setTitle( request.getTitle() );
        book.setDescription( request.getDescription() );
        book.setBookType( request.getBookType() );
        book.setPublishedDate( request.getPublishedDate() );
        if ( request.getTotalPages() != null ) {
            book.setTotalPages( request.getTotalPages() );
        }
        book.setAutor( autorMapper.toEntity( request.getAutor() ) );
        book.setEditorial( editorialMapper.toEntity( request.getEditorial() ) );
        book.setCategories( categoryRequestListToCategoryList( request.getCategories() ) );

        return book;
    }

    @Override
    public BookFilter toFilter(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        BookFilter.BookFilterBuilder bookFilter = BookFilter.builder();

        if ( request.getId() != null ) {
            bookFilter.id( Long.parseLong( request.getId() ) );
        }
        bookFilter.title( request.getTitle() );
        bookFilter.description( request.getDescription() );
        bookFilter.bookType( request.getBookType() );
        bookFilter.publishedDate( request.getPublishedDate() );
        bookFilter.totalPages( request.getTotalPages() );
        bookFilter.autor( autorMapper.toFilter( request.getAutor() ) );
        bookFilter.editorial( editorialMapper.toFilter( request.getEditorial() ) );
        bookFilter.categories( categoryRequestListToCategoryFilterList( request.getCategories() ) );
        bookFilter.titleCriteria( request.getTitleCriteria() );
        bookFilter.descriptionCriteria( request.getDescriptionCriteria() );
        bookFilter.publishedDateCriteria( request.getPublishedDateCriteria() );
        bookFilter.totalPagesCriteria( request.getTotalPagesCriteria() );
        bookFilter.categoriesCriteria( request.getCategoriesCriteria() );

        return bookFilter.build();
    }

    @Override
    public BookResponse toResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setId( String.valueOf( book.getId() ) );
        bookResponse.setTitle( book.getTitle() );
        bookResponse.setDescription( book.getDescription() );
        bookResponse.setBookType( book.getBookType() );
        bookResponse.setPublishedDate( book.getPublishedDate() );
        bookResponse.setTotalPages( book.getTotalPages() );
        bookResponse.setImage( book.getImage() );
        bookResponse.setAutor( autorMapper.toResponse( book.getAutor() ) );
        bookResponse.setEditorial( editorialMapper.toResponse( book.getEditorial() ) );
        bookResponse.setCategories( categoryListToCategoryResponseList( book.getCategories() ) );

        return bookResponse;
    }

    protected List<Category> categoryRequestListToCategoryList(List<CategoryRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryRequest categoryRequest : list ) {
            list1.add( categoryMapper.toEntity( categoryRequest ) );
        }

        return list1;
    }

    protected List<CategoryFilter> categoryRequestListToCategoryFilterList(List<CategoryRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryFilter> list1 = new ArrayList<CategoryFilter>( list.size() );
        for ( CategoryRequest categoryRequest : list ) {
            list1.add( categoryMapper.toFilter( categoryRequest ) );
        }

        return list1;
    }

    protected List<CategoryResponse> categoryListToCategoryResponseList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryResponse> list1 = new ArrayList<CategoryResponse>( list.size() );
        for ( Category category : list ) {
            list1.add( categoryMapper.toResponse( category ) );
        }

        return list1;
    }
}
