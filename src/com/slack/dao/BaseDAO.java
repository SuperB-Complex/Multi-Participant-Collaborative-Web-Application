package com.slack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public interface BaseDAO {
	Session getSession();
	SessionFactory getSessionFactory();
	void setSessionFactory(SessionFactory sessionFactory);
	String regExtract(String data);
}

