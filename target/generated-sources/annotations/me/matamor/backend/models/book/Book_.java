package me.matamor.backend.models.book;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.book.type.BookType;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.likes.Like;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Editorial> editorial;
	public static volatile SingularAttribute<Book, String> image;
	public static volatile SingularAttribute<Book, Integer> totalPages;
	public static volatile SingularAttribute<Book, String> description;
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, Date> publishedDate;
	public static volatile ListAttribute<Book, Category> categories;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Autor> autor;
	public static volatile SingularAttribute<Book, BookType> bookType;
	public static volatile ListAttribute<Book, Like> likes;

	public static final String EDITORIAL = "editorial";
	public static final String IMAGE = "image";
	public static final String TOTAL_PAGES = "totalPages";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String PUBLISHED_DATE = "publishedDate";
	public static final String CATEGORIES = "categories";
	public static final String TITLE = "title";
	public static final String AUTOR = "autor";
	public static final String BOOK_TYPE = "bookType";
	public static final String LIKES = "likes";

}

