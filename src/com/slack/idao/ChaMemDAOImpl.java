package com.slack.idao;

import java.sql.Timestamp;
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

import com.slack.pojo.ChaMem;
import com.slack.dao.ChaMemDAO;
import com.slack.idao.BaseDAOImpl;

/**
 	* A data access object (DAO) providing persistence and search support for ChaMem entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.slack.dao.ChaMem
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class ChaMemDAOImpl extends BaseDAOImpl implements ChaMemDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ChaMemDAO.class);
		//property constants
	public static final String STATE = "state";



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
    
    public void save(ChaMem transientInstance) {
        log.debug("saving ChaMem instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ChaMem persistentInstance) {
        log.debug("deleting ChaMem instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ChaMem findById( com.slack.pojo.ChaMemId id) {
        log.debug("getting ChaMem instance with id: " + id);
        try {
            ChaMem instance = (ChaMem) getCurrentSession()
                    .get("com.slack.dao.ChaMem", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ChaMem instance) {
        log.debug("finding ChaMem instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.slack.dao.ChaMem") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ChaMem instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ChaMem as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByState(Object state
	) {
		return findByProperty(STATE, state
		);
	}
	

	public List findAll() {
		log.debug("finding all ChaMem instances");
		try {
			String queryString = "from ChaMem";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ChaMem merge(ChaMem detachedInstance) {
        log.debug("merging ChaMem instance");
        try {
            ChaMem result = (ChaMem) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ChaMem instance) {
        log.debug("attaching dirty ChaMem instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ChaMem instance) {
        log.debug("attaching clean ChaMem instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ChaMemDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ChaMemDAO) ctx.getBean("ChaMemDAO");
	}
}