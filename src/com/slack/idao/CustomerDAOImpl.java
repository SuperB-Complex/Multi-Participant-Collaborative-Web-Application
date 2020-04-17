package com.slack.idao;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.slack.pojo.Customer;
import com.slack.dao.CustomerDAO;
import com.slack.idao.BaseDAOImpl;

/**
 	* A data access object (DAO) providing persistence and search support for Customer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.slack.dao.Customer
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class CustomerDAOImpl extends BaseDAOImpl implements CustomerDAO  {	     
	//property constants
	public static final String USERNAME = "username";
	public static final String USEREMAIL = "useremail";
	public static final String NICKNAME = "nickname";
	public static final String USERPWD = "userpwd";

	@Override
	public boolean register(String userName, String nickName, String userEmail, String passWord) {
		return false;
	}
	
	@Override
	public List<Object[]> login(int isEmail, String nickNameOrUserEmail, String passWord) {
		
		nickNameOrUserEmail = regExtract(nickNameOrUserEmail.trim());
		passWord = regExtract(passWord.trim());
		
		System.out.println("after reg nickNameOrUserEmail : " + nickNameOrUserEmail);
		System.out.println("after reg passWord : " + passWord);
			
		System.out.println("before getession()");
		Session session = getSession();
		System.out.println("after getession()" + session.toString());
		String hql = "select uid, nickname from Customer where nickname=? and userpwd=?";
		if (isEmail == 2) {
			hql = "select uid, nickname from Customer where useremail=? and userpwd=?";
		}		
		List<Object[]> res = session.createQuery(hql).setParameter(0, nickNameOrUserEmail).setParameter(1, passWord).list();
		session.close();
		System.out.println(res.size());		
		/*if(size > 0){			
			return true;
		}
		return false;*/
		return res;
	}

	
	@Override
	public boolean inputExist(String isEmail, String nickNameOrUserEmail) {		
		nickNameOrUserEmail = regExtract(nickNameOrUserEmail.trim());
		
		System.out.println("after reg : " + nickNameOrUserEmail);
		
		int isEmail_int = Integer.parseInt(isEmail);
		System.out.println("username:" + nickNameOrUserEmail.length());
		System.out.println("before getession()");
		Session session = getSession();
		System.out.println("after getession()");
		System.out.println(isEmail_int);
		String hql = "select uid from Customer where nickname=?";
		if (isEmail_int == 2) {
			hql = "from Customer where useremail=?";
		}		
		Integer size  = session.createQuery(hql).setParameter(0, nickNameOrUserEmail).list().size();
		session.close();
		System.out.println(size);		
		if(size > 0){			
			return true;
		}
		return false;	
	}
	
	
}