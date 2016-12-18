package com.blinfosoft.feedback.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Admin.class)
public abstract class Admin_ {

	public static volatile CollectionAttribute<Admin, App> app;
	public static volatile SingularAttribute<Admin, String> password;
	public static volatile SingularAttribute<Admin, String> name;
	public static volatile SingularAttribute<Admin, Long> id;
	public static volatile SingularAttribute<Admin, String> userName;
	public static volatile SingularAttribute<Admin, String> email;
	public static volatile SingularAttribute<Admin, String> userSecretKey;

}

