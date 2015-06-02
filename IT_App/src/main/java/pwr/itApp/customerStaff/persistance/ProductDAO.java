package pwr.itApp.customerStaff.persistance;

import org.springframework.stereotype.Repository;

import pwr.itApp.customerStaff.domain.Product;

@Repository
public class ProductDAO extends GenericDAO<Product>{

	public Product find(Integer id) {
		return em.find(Product.class, id);
	}
	
//	public List<ResourceAmountMap> getProductComposition(int id) {
//		Product product = em.find(Product.class, id);
//		return product.getComposition();
//				
//	}
	
}
