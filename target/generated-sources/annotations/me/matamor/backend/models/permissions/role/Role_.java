package me.matamor.backend.models.permissions.role;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.matamor.backend.models.permissions.privilege.Privilege;
import me.matamor.backend.models.user.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile ListAttribute<Role, Privilege> privileges;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, Long> id;
	public static volatile ListAttribute<Role, User> users;

	public static final String PRIVILEGES = "privileges";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USERS = "users";

}

