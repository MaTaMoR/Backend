package me.matamor.backend.models.likes;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Like.class)
public abstract class Like_ {

	public static volatile SingularAttribute<Like, Date> date;
	public static volatile SingularAttribute<Like, Long> contentId;
	public static volatile SingularAttribute<Like, Long> id;
	public static volatile SingularAttribute<Like, Long> userId;

	public static final String DATE = "date";
	public static final String CONTENT_ID = "contentId";
	public static final String ID = "id";
	public static final String USER_ID = "userId";

}

