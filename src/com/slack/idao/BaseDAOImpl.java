package com.slack.idao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.slack.dao.BaseDAO;

public class BaseDAOImpl  implements BaseDAO  {
	private SessionFactory sessionFactory;

	public Session getSession(){
		Session session = sessionFactory.openSession();
		return session;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String regExtract(String data) {
		String regex = "\"(.*?)\"";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		matcher.matches();
		String res = data;
		try {
	    	res = matcher.group(1);
	    } catch(IllegalStateException e) {
	    	System.out.println("-----------------------Wrong in reg");
	    	//e.printStackTrace();
	    }
		return res;
	}
	
	
}

