package com.blinfosoft.feedback.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Issue.class)
public abstract class Issue_ {

	public static volatile SingularAttribute<Issue, String> msg;
	public static volatile SingularAttribute<Issue, App> app;
	public static volatile SingularAttribute<Issue, Long> id;
	public static volatile SingularAttribute<Issue, String> title;
	public static volatile SingularAttribute<Issue, String> type;
	public static volatile SingularAttribute<Issue, Date> createdOn;
	public static volatile SingularAttribute<Issue, User> user;

}

