package pwr.itApp.customerStaff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.persistance.ResourceDAO;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.factory.ResourceFactory;

@Service
public class ResourcesService {

	@Autowired
	private ResourceDAO resourcesDAO;

	@Autowired
	private ResourceFactory resourcesFactory;
	
	public List<ResourceDTO> getAllRestaurantResources(Integer chosenRestaurantId) {
		return resourcesFactory.getDTOList(resourcesDAO.findAllResourcesInRestaurantById(chosenRestaurantId));
	}

	
}
