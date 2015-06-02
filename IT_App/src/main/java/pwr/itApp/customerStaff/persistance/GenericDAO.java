package pwr.itApp.customerStaff.persistance;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class GenericDAO<T>{
	protected EntityManager em;
	
    public EntityManager getEntityManager() {
        return em;
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
    
	@Transactional
	public void persistNewEntry(T resource) {
		em.persist(resource);
	}

	@Transactional
	public void updateResouerce(T resource) {
		em.merge(resource);
	}
}

