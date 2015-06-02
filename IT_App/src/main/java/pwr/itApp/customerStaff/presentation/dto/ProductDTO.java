package pwr.itApp.customerStaff.presentation.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import pwr.itApp.customerStaff.domain.enums.ProductType;
import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class ProductDTO implements ElementComponent, Serializable	{

	private static final long serialVersionUID = -1706718406113479435L;
	private Integer id;
	private String name;
	private Double price;
	private String productDescription;
	private Map<Integer, Double> resourcesInProduct;
	
	public ProductDTO() {
		resourcesInProduct = new HashMap<Integer, Double>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getImageURL() {
		return "images/meal.png";
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Map<Integer, Double> getResourcesInProduct() {
		return resourcesInProduct;
	}

	public void setResourcesInProduct(Map<Integer, Double> resourcesInProduct) {
		this.resourcesInProduct = resourcesInProduct;
	}

	public double addResourceToReceipt(Integer resourceId, Double resourceAmount) {
		if (resourcesInProduct.containsKey(resourceId)) {
			resourceAmount = resourceAmount + resourcesInProduct.get(resourceId);
		}
		resourcesInProduct.put(resourceId, resourceAmount);
		
		return resourceAmount;
	}

	public boolean isAdultOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	public ProductType getProductType() {
		// TODO Auto-generated method stub
		return ProductType.ALCOHOL;
	}

	public void setAdultOnly(boolean adultOnly) {
		// TODO Auto-generated method stub
		
	}

	public void setDeleted(boolean deleted) {
		// TODO Auto-generated method stub
		
	}

	public void setProductType(ProductType productType) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isAvailable() {
		return true;
	}

}
