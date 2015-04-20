package pwr.itApp.customerStaff.persistance;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pwr.itApp.customerStaff.domain.Resource;

@Repository
public class ResourceDAO extends GenericDAO<Resource>{

	public Resource getResource(int id) {
		return em.find(Resource.class, id);
	}

	public List<Resource> findAllResourcesInRestaurantById(Integer restId) {
		return em.createNamedQuery("Resource.findAllOfRest", Resource.class)
				.setParameter("restaurantId", restId)
				.getResultList();
	}

	@Transactional
	public void persistNewEntry(Resource resource) {
		em.persist(resource);
	}

	@Transactional
	public void updateResouerce(Resource resource) {
		em.merge(resource);
	}
}
