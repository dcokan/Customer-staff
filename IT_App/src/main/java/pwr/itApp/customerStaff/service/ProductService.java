package pwr.itApp.customerStaff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.domain.Product;
import pwr.itApp.customerStaff.persistance.ProductDAO;
import pwr.itApp.customerStaff.persistance.ResourceDAO;
import pwr.itApp.customerStaff.presentation.dto.ProductDTO;
import pwr.itApp.customerStaff.service.factory.ProductFactory;

@Service
public class ProductService {

	@Autowired 
	private ProductDAO productRepo;
	
	@Autowired
	private ResourceDAO resourceRepo;

	@Autowired 
	ProductFactory productFactory;
	
	public void updateProduct(ProductDTO product) {
		productRepo.updateResouerce(productFactory.getEntity(product));
	}
	public void createProduct(ProductDTO newProduct) {
		Product product = productFactory.getEntity(newProduct);
		productRepo.persistNewEntry(product);
	}
	
}
