package me.matamor.backend.models.review;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.likes.Like;
import me.matamor.backend.models.user.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Review.class)
public abstract class Review_ {

	public static volatile SingularAttribute<Review, String> image;
	public static volatile SingularAttribute<Review, Integer> score;
	public static volatile SingularAttribute<Review, Date> reviewDate;
	public static volatile SingularAttribute<Review, String> review;
	public static volatile SingularAttribute<Review, Book> book;
	public static volatile SingularAttribute<Review, Long> id;
	public static volatile SingularAttribute<Review, User> autor;
	public static volatile ListAttribute<Review, Like> likes;

	public static final String IMAGE = "image";
	public static final String SCORE = "score";
	public static final String REVIEW_DATE = "reviewDate";
	public static final String REVIEW = "review";
	public static final String BOOK = "book";
	public static final String ID = "id";
	public static final String AUTOR = "autor";
	public static final String LIKES = "likes";

}

