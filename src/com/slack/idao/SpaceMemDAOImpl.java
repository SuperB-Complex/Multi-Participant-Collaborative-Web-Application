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

import com.slack.pojo.SpaceMem;
import com.slack.dao.SpaceMemDAO;
import com.slack.idao.BaseDAOImpl;

/**
 	* A data access object (DAO) providing persistence and search support for SpaceMem entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.slack.dao.SpaceMem
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class SpaceMemDAOImpl extends BaseDAOImpl implements SpaceMemDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SpaceMemDAO.class);
		//property constants
	public static final String USTATE = "ustate";



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
    
    public void save(SpaceMem transientInstance) {
        log.debug("saving SpaceMem instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SpaceMem persistentInstance) {
        log.debug("deleting SpaceMem instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SpaceMem findById(com.slack.pojo.SpaceMemId id) {
        log.debug("getting SpaceMem instance with id: " + id);
        try {
            SpaceMem instance = (SpaceMem) getCurrentSession()
                    .get("com.slack.dao.SpaceMem", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SpaceMem instance) {
        log.debug("finding SpaceMem instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.slack.dao.SpaceMem") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding SpaceMem instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SpaceMem as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUstate(Object ustate
	) {
		return findByProperty(USTATE, ustate
		);
	}
	

	public List findAll() {
		log.debug("finding all SpaceMem instances");
		try {
			String queryString = "from SpaceMem";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SpaceMem merge(SpaceMem detachedInstance) {
        log.debug("merging SpaceMem instance");
        try {
            SpaceMem result = (SpaceMem) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SpaceMem instance) {
        log.debug("attaching dirty SpaceMem instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SpaceMem instance) {
        log.debug("attaching clean SpaceMem instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SpaceMemDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SpaceMemDAO) ctx.getBean("SpaceMemDAO");
	}
}