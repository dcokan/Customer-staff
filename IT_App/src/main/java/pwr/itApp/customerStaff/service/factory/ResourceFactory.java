package pwr.itApp.customerStaff.service.factory;

import org.springframework.stereotype.Repository;

import pwr.itApp.customerStaff.domain.Resource;
import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;

@Repository
public class ResourceFactory extends AbstractFactoryDTO<Resource, ResourceDTO> {

	@Override
	public ResourceDTO getDTO(Resource entity) {
		ResourceDTO dto = new ResourceDTO();
		dto.setAmount(entity.getAmount());
		dto.setMeasureUnit(entity.getMeasureUnit());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		
		return dto;
	}

	@Override
	public Resource getEntity(ResourceDTO dto) {
		Resource entity = new Resource();
		entity.setAmount(dto.getAmount());;
		entity.setMeasureUnit(dto.getMeasureUnit());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());

		return entity;
	}

}
