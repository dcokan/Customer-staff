package pwr.itApp.customerStaff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.domain.Resource;
import pwr.itApp.customerStaff.persistance.ResourceDAO;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;
import pwr.itApp.customerStaff.service.factory.ResourceFactory;
import pwr.itApp.customerStaff.webapp.utils.LabelUtils;

@Service("resourceService")
public class ResourcesService {

	@Autowired
	private ResourceDAO resourcesDAO;

	@Autowired
	private ResourceFactory resourcesFactory;
	
	public List<ResourceDTO> getAllRestaurantResources(Integer chosenRestaurantId) {
		return resourcesFactory.getDTOList(resourcesDAO.findAllResourcesInRestaurantById(chosenRestaurantId));
	}
	
	public void createResource(ResourceDTO dto) {
		resourcesDAO.persistNewEntry(resourcesFactory.getEntity(dto));
	}

	public void updateResource(ResourceDTO resource) {
		resourcesDAO.updateResouerce(resourcesFactory.getEntity(resource));
	}

	public ResourceDTO getResourceById(int id) {
		return resourcesFactory.getDTO(resourcesDAO.getResource(id));
	}

	public Map<Integer, String> getResourceLabels(Map<Integer, Double> resources) {
		//TODO: here should be made query to DB "Select Name from resource where id in (...) group by name"
		Map<Integer, String> result = new HashMap<Integer, String>();
		for (Resource resource: resourcesDAO.findResourcesByIds(resources.keySet())) {
			result.put(resource.getId(), LabelUtils.prepareResourceLabel(
					resource.getName(), resources.get(resource.getId())));
		}
		
		return result;
	}

	
}
