package pwr.itApp.customerStaff.persistance;

import org.springframework.stereotype.Repository;

import pwr.itApp.customerStaff.domain.Resource;

@Repository
public class ResourceDAO extends GenericDAO<Resource>{

	public Resource getResource(int id) {
		return em.find(Resource.class, id);
	}
}
