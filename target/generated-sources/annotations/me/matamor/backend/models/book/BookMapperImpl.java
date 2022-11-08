package me.matamor.backend.models.book;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.filter.book.BookFilter;
import me.matamor.backend.filter.category.CategoryFilter;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.autor.AutorMapper;
import me.matamor.backend.models.autor.AutorResponse;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.category.CategoryMapper;
import me.matamor.backend.models.category.CategoryRequest;
import me.matamor.backend.models.category.CategoryResponse;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.editorial.EditorialMapper;
import me.matamor.backend.models.editorial.EditorialResponse;
import me.matamor.backend.models.likes.Like;
import me.matamor.backend.models.likes.LikeMapper;
import me.matamor.backend.models.likes.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T12:36:50+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    private final AutorMapper autorMapper;
    private final EditorialMapper editorialMapper;
    private final CategoryMapper categoryMapper;
    private final LikeMapper likeMapper;

    @Autowired
    public BookMapperImpl(AutorMapper autorMapper, EditorialMapper editorialMapper, CategoryMapper categoryMapper, LikeMapper likeMapper) {

        this.autorMapper = autorMapper;
        this.editorialMapper = editorialMapper;
        this.categoryMapper = categoryMapper;
        this.likeMapper = likeMapper;
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
    public Book toEntity(BookResponse response) {
        if ( response == null ) {
            return null;
        }

        Book book = new Book();

        if ( response.getId() != null ) {
            book.setId( Long.parseLong( response.getId() ) );
        }
        book.setTitle( response.getTitle() );
        book.setDescription( response.getDescription() );
        book.setBookType( response.getBookType() );
        book.setPublishedDate( response.getPublishedDate() );
        if ( response.getTotalPages() != null ) {
            book.setTotalPages( response.getTotalPages() );
        }
        book.setImage( response.getImage() );
        book.setAutor( autorResponseToAutor( response.getAutor() ) );
        book.setEditorial( editorialResponseToEditorial( response.getEditorial() ) );
        book.setCategories( categoryResponseListToCategoryList( response.getCategories() ) );
        book.setLikes( likeResponseListToLikeList( response.getLikes() ) );

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

        if ( book.getId() != null ) {
            bookResponse.setId( String.valueOf( book.getId() ) );
        }
        bookResponse.setTitle( book.getTitle() );
        bookResponse.setDescription( book.getDescription() );
        bookResponse.setBookType( book.getBookType() );
        bookResponse.setPublishedDate( book.getPublishedDate() );
        bookResponse.setTotalPages( book.getTotalPages() );
        bookResponse.setImage( book.getImage() );
        bookResponse.setAutor( autorMapper.toResponse( book.getAutor() ) );
        bookResponse.setEditorial( editorialMapper.toResponse( book.getEditorial() ) );
        bookResponse.setCategories( categoryListToCategoryResponseList( book.getCategories() ) );
        bookResponse.setLikes( likeListToLikeResponseList( book.getLikes() ) );

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

    protected Autor autorResponseToAutor(AutorResponse autorResponse) {
        if ( autorResponse == null ) {
            return null;
        }

        Autor autor = new Autor();

        if ( autorResponse.getId() != null ) {
            autor.setId( Long.parseLong( autorResponse.getId() ) );
        }
        autor.setName( autorResponse.getName() );
        autor.setSurnames( autorResponse.getSurnames() );

        return autor;
    }

    protected Editorial editorialResponseToEditorial(EditorialResponse editorialResponse) {
        if ( editorialResponse == null ) {
            return null;
        }

        Editorial editorial = new Editorial();

        if ( editorialResponse.getId() != null ) {
            editorial.setId( Long.parseLong( editorialResponse.getId() ) );
        }
        editorial.setName( editorialResponse.getName() );
        editorial.setImage( editorialResponse.getImage() );

        return editorial;
    }

    protected Category categoryResponseToCategory(CategoryResponse categoryResponse) {
        if ( categoryResponse == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryResponse.getId() != null ) {
            category.setId( Long.parseLong( categoryResponse.getId() ) );
        }
        category.setName( categoryResponse.getName() );

        return category;
    }

    protected List<Category> categoryResponseListToCategoryList(List<CategoryResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryResponse categoryResponse : list ) {
            list1.add( categoryResponseToCategory( categoryResponse ) );
        }

        return list1;
    }

    protected List<Like> likeResponseListToLikeList(List<LikeResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<Like> list1 = new ArrayList<Like>( list.size() );
        for ( LikeResponse likeResponse : list ) {
            list1.add( likeMapper.toEntity( likeResponse ) );
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

    protected List<LikeResponse> likeListToLikeResponseList(List<Like> list) {
        if ( list == null ) {
            return null;
        }

        List<LikeResponse> list1 = new ArrayList<LikeResponse>( list.size() );
        for ( Like like : list ) {
            list1.add( likeMapper.toResponse( like ) );
        }

        return list1;
    }
}
