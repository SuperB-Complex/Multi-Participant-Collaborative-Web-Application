package com.slack.idao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.slack.pojo.SpaceMemTime;
import com.slack.dao.SpaceMemTimeDAO;
import com.slack.idao.BaseDAOImpl;

/**
 	* A data access object (DAO) providing persistence and search support for SpaceMemTime entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.slack.dao.SpaceMemTime
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class SpaceMemTimeDAOImpl extends BaseDAOImpl implements SpaceMemTimeDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SpaceMemTimeDAO.class);
		//property constants



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
    
    public void save(SpaceMemTime transientInstance) {
        log.debug("saving SpaceMemTime instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SpaceMemTime persistentInstance) {
        log.debug("deleting SpaceMemTime instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SpaceMemTime findById( java.lang.Integer id) {
        log.debug("getting SpaceMemTime instance with id: " + id);
        try {
            SpaceMemTime instance = (SpaceMemTime) getCurrentSession()
                    .get("com.slack.dao.SpaceMemTime", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SpaceMemTime instance) {
        log.debug("finding SpaceMemTime instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.slack.dao.SpaceMemTime") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding SpaceMemTime instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SpaceMemTime as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all SpaceMemTime instances");
		try {
			String queryString = "from SpaceMemTime";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SpaceMemTime merge(SpaceMemTime detachedInstance) {
        log.debug("merging SpaceMemTime instance");
        try {
            SpaceMemTime result = (SpaceMemTime) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SpaceMemTime instance) {
        log.debug("attaching dirty SpaceMemTime instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SpaceMemTime instance) {
        log.debug("attaching clean SpaceMemTime instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SpaceMemTimeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SpaceMemTimeDAO) ctx.getBean("SpaceMemTimeDAO");
	}
}