package com.slack.idao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.slack.pojo.Chan;
import com.slack.dao.ChanDAO;
import com.slack.idao.BaseDAOImpl;

/**
 	* A data access object (DAO) providing persistence and search support for Chan entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.slack.dao.Chan
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class ChanDAOImpl extends BaseDAOImpl implements ChanDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ChanDAO.class);
		//property constants
	public static final String CHTYPE = "chtype";



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(Chan transientInstance) {
        log.debug("saving Chan instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Chan persistentInstance) {
        log.debug("deleting Chan instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Chan findById( com.slack.pojo.ChanId id) {
        log.debug("getting Chan instance with id: " + id);
        try {
            Chan instance = (Chan) getCurrentSession()
                    .get("com.slack.dao.Chan", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Chan instance) {
        log.debug("finding Chan instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.slack.dao.Chan") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Chan instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Chan as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByChtype(Object chtype
	) {
		return findByProperty(CHTYPE, chtype
		);
	}
	

	public List findAll() {
		log.debug("finding all Chan instances");
		try {
			String queryString = "from Chan";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Chan merge(Chan detachedInstance) {
        log.debug("merging Chan instance");
        try {
            Chan result = (Chan) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Chan instance) {
        log.debug("attaching dirty Chan instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Chan instance) {
        log.debug("attaching clean Chan instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ChanDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ChanDAO) ctx.getBean("ChanDAO");
	}
}