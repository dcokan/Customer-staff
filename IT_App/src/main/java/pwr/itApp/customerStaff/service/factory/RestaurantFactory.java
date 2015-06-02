package pwr.itApp.customerStaff.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.domain.Restaurant;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;

@Service
public class RestaurantFactory extends AbstractFactoryDTO<Restaurant, RestaurantDTO>{

	@Autowired
	private ProductFactory productFactory;
	
	@Autowired
	private TableFactory tableFactory;
	
	@Override
	public RestaurantDTO getDTO(Restaurant entity) {
		RestaurantDTO dto = new RestaurantDTO();
		dto.setId(entity.getId());
		dto.setCity(entity.getCity());
		dto.setDeleted(entity.isDeleted());
		dto.setDescription(entity.getDescription());
		dto.setMail(entity.getMail());
		dto.setName(entity.getName());
		dto.setProducts(productFactory.getDTOList(entity.getProducts()));
		dto.setRestaurantDescription(entity.getDescription());
		dto.setStreet(entity.getStreet());
		dto.setTables(null);
//		dto.setTables(tableFactory.getDTOList(entity.getTables()));
		dto.setTel1(entity.getTel1());
		dto.setTel2(entity.getTel2());

		return dto;
	}

	@Override
	public Restaurant getEntity(RestaurantDTO dto) {
		Restaurant entity = new Restaurant();
		entity.setId(dto.getId());
		entity.setCity(dto.getCity());
		entity.setDeleted(dto.isDeleted());
		entity.setDescription(dto.getDescription());
		entity.setMail(dto.getMail());
		entity.setName(dto.getName());
		entity.setProducts(productFactory.getEntitiesList(dto.getProducts()));
		entity.setDescription(dto.getRestaurantDescription());
		entity.setStreet(dto.getStreet());
		entity.setTables(tableFactory.getEntitiesList(dto.getTables()));
		entity.setTel1(dto.getTel1());
		entity.setTel2(dto.getTel2());
		
		return entity;
	}

}
