package pwr.itApp.customerStaff.persistance;

import java.util.List;

import org.springframework.stereotype.Repository;

import pwr.itApp.customerStaff.domain.Product;
import pwr.itApp.customerStaff.domain.ResourceAmountMap;

@Repository
public class ProductDAO extends GenericDAO<Product>{

	public List<ResourceAmountMap> getProductComposition(int id) {
		Product product = em.find(Product.class, id);
		return product.getComposition();
				
	}

	
}
