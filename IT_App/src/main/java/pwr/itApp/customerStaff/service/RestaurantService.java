package pwr.itApp.customerStaff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.domain.Restaurant;
import pwr.itApp.customerStaff.domain.enums.ProductType;
import pwr.itApp.customerStaff.persistance.RestaurantDAO;
import pwr.itApp.customerStaff.presentation.dto.ProductDTO;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;
import pwr.itApp.customerStaff.service.factory.ProductFactory;
import pwr.itApp.customerStaff.service.factory.RestaurantFactory;
import pwr.itApp.customerStaff.webapp.utils.Lists;
import pwr.itApp.customerStaff.webapp.utils.lists.FilterCondition;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantFactory restaurantFactory;
	
	@Autowired
	private ProductFactory productFactory;
	
	@Autowired
	private RestaurantDAO restaurantRepo;
	
	
	public List<ProductDTO> getProductsByType(RestaurantDTO restaurant, final ProductType type) {
		List<ProductDTO> products = restaurant.getProducts();
		
		return Lists.filter(products, new FilterCondition<ProductDTO>() {

			@Override
			public boolean apply(ProductDTO product) {
				return type == product.getProductType();
			}
		});
	}

	public void updateRestaurant(RestaurantDTO dto) {
		Restaurant res = restaurantFactory.getEntity(dto);
		restaurantRepo.updateResouerce(res);
	}
}
