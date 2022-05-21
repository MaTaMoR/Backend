package me.matamor.backend.models.autor;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Autor.class)
public abstract class Autor_ {

	public static volatile SingularAttribute<Autor, String> image;
	public static volatile SingularAttribute<Autor, String> name;
	public static volatile SingularAttribute<Autor, Long> id;
	public static volatile SingularAttribute<Autor, String> surnames;

	public static final String IMAGE = "image";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SURNAMES = "surnames";

}

