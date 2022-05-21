package me.matamor.backend.models.editorial;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Editorial.class)
public abstract class Editorial_ {

	public static volatile SingularAttribute<Editorial, String> image;
	public static volatile SingularAttribute<Editorial, String> name;
	public static volatile SingularAttribute<Editorial, Long> id;

	public static final String IMAGE = "image";
	public static final String NAME = "name";
	public static final String ID = "id";

}

