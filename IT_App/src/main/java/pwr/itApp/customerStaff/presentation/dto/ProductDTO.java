package pwr.itApp.customerStaff.presentation.dto;

import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class ProductDTO implements ElementComponent{

	private String name;
	private Double price;
	private String productDescription;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
