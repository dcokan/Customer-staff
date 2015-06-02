package pwr.itApp.customerStaff.persistance;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

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

	public List<Resource> findResourcesByIds(Collection<Integer> ids) {
		return em.createNamedQuery("Resource.findResourcesByIds", Resource.class)
				.setParameter("ids", ids)
				.getResultList();
	}
}
