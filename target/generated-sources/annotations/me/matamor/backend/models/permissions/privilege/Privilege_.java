package me.matamor.backend.models.permissions.privilege;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.matamor.backend.models.permissions.role.Role;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Privilege.class)
public abstract class Privilege_ {

	public static volatile ListAttribute<Privilege, Role> roles;
	public static volatile SingularAttribute<Privilege, String> name;
	public static volatile SingularAttribute<Privilege, Long> id;

	public static final String ROLES = "roles";
	public static final String NAME = "name";
	public static final String ID = "id";

}

