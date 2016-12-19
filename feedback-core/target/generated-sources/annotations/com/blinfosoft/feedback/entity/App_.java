package com.blinfosoft.feedback.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(App.class)
public abstract class App_ {

	public static volatile SetAttribute<App, Issue> issue;
	public static volatile SingularAttribute<App, String> name;
	public static volatile SingularAttribute<App, Account> admin;
	public static volatile SingularAttribute<App, Long> id;

}

