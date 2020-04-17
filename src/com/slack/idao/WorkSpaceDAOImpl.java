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

import com.slack.pojo.WorkSpace;
import com.slack.dao.WorkSpaceDAO;
import com.slack.idao.BaseDAOImpl;

/**
 	* A data access object (DAO) providing persistence and search support for WorkSpace entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.slack.dao.WorkSpace
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class WorkSpaceDAOImpl extends BaseDAOImpl  implements WorkSpaceDAO {
	     private static final Logger log = LoggerFactory.getLogger(WorkSpaceDAO.class);
		//property constants
	public static final String WNAME = "wname";
	public static final String WDESCRIPTION = "wdescription";



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
    
    public void save(WorkSpace transientInstance) {
        log.debug("saving WorkSpace instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WorkSpace persistentInstance) {
        log.debug("deleting WorkSpace instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WorkSpace findById( java.lang.Integer id) {
        log.debug("getting WorkSpace instance with id: " + id);
        try {
            WorkSpace instance = (WorkSpace) getCurrentSession()
                    .get("com.slack.dao.WorkSpace", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WorkSpace instance) {
        log.debug("finding WorkSpace instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.slack.dao.WorkSpace") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding WorkSpace instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WorkSpace as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByWname(Object wname
	) {
		return findByProperty(WNAME, wname
		);
	}
	
	public List findByWdescription(Object wdescription
	) {
		return findByProperty(WDESCRIPTION, wdescription
		);
	}
	

	public List findAll() {
		log.debug("finding all WorkSpace instances");
		try {
			String queryString = "from WorkSpace";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WorkSpace merge(WorkSpace detachedInstance) {
        log.debug("merging WorkSpace instance");
        try {
            WorkSpace result = (WorkSpace) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WorkSpace instance) {
        log.debug("attaching dirty WorkSpace instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WorkSpace instance) {
        log.debug("attaching clean WorkSpace instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static WorkSpaceDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (WorkSpaceDAO) ctx.getBean("WorkSpaceDAO");
	}
}