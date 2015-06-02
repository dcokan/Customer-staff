package pwr.itApp.customerStaff.service.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.domain.Product;
import pwr.itApp.customerStaff.persistance.ResourceDAO;
import pwr.itApp.customerStaff.presentation.dto.ProductDTO;

@Service
public class ProductFactory extends AbstractFactoryDTO<Product, ProductDTO> {

	@Autowired
	private ResourceDAO resourceRepo;
	
	@Override
	public ProductDTO getDTO(Product entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setAdultOnly(entity.isAdultOnly());
		dto.setResourcesInProduct(entity.getComposition());
		dto.setDeleted(entity.isDeleted());
		dto.setProductDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setProductType(entity.getProductType());
		
		return dto;
	}
//
//	private Map<Integer, Double> getCompositionMap(List<ResourceAmountMap> composition ) {
//		Map<Integer, Double> resourcesMap = new HashMap<Integer, Double>();
//		for (ResourceAmountMap item: composition) {
//			resourcesMap.put(item.getResource().getId(), item.getAmount());
//		}
//		return resourcesMap;
//	}

	@Override
	public Product getEntity(ProductDTO dto) {
		Product entity = new Product();
		entity.setId(dto.getId());
		entity.setAdultOnly(dto.isAdultOnly());
		entity.setComposition(dto.getResourcesInProduct());
		entity.setDeleted(dto.isDeleted());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setProductType(dto.getProductType());
		return entity;
	}

//	private List<ResourceAmountMap> createComposition(Map<Integer, Double> resourcesInProduct, Product product) {
//		List<ResourceAmountMap> composition = new ArrayList<ResourceAmountMap>();
//		if (resourcesInProduct == null) {
//			return composition;
//		}
//		for (Integer resourceId: resourcesInProduct.keySet()) {
//			ResourceAmountMap item = new ResourceAmountMap();
//			item.setAmount(resourcesInProduct.get(resourceId));
//			item.setResource(resourceRepo.getResource(resourceId));
////			item.setProduct(product);
//			
//			composition.add(item);
//		}
//		return composition;
//	}

}
