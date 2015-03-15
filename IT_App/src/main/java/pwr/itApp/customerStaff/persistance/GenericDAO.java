package pwr.itApp.customerStaff.persistance;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO<T>{
	protected EntityManager em;
	
    public EntityManager getEntityManager() {
        return em;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
}

