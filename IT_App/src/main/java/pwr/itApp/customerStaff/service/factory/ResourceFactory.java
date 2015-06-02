package pwr.itApp.customerStaff.service.factory;

import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.domain.Resource;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;

@Service
public class ResourceFactory extends AbstractFactoryDTO<Resource, ResourceDTO> {

	@Override
	public ResourceDTO getDTO(Resource entity) {
		ResourceDTO dto = new ResourceDTO();
		dto.setId(entity.getId());
		dto.setAmount(entity.getAmount());
		dto.setMeasureUnit(entity.getMeasureUnit());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setRestaurantId(entity.getRestaurantId());
		dto.setMinimalAmount(entity.getMinimalAmountInProduct());
		dto.setCriticalAmount(entity.getCriticalAmountInStore());
		
		return dto;
	}

	@Override
	public Resource getEntity(ResourceDTO dto) {
		Resource entity = new Resource();
		
		entity.setId(dto.getId());
		entity.setAmount(dto.getAmount());;
		entity.setMeasureUnit(dto.getMeasureUnit());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setRestaurantId(dto.getRestaurantId());
		entity.setCriticalAmountInStore(dto.getCriticalAmount());
		entity.setMinimalAmountInProduct(dto.getMinimalAmount());
		
		return entity;
	}

}
