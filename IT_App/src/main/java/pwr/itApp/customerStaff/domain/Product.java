package pwr.itApp.customerStaff.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pwr.itApp.customerStaff.domain.converters.ProductTypeConverter;
import pwr.itApp.customerStaff.domain.converters.YNBooleanConverter;
import pwr.itApp.customerStaff.domain.enums.ProductType;

@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	private int id;
	
	private String name;
	
	private double price;
	
	@Convert(converter = ProductTypeConverter.class)
	@Column(name = "TYPE")
	private ProductType productType;
	
	@Convert(converter = YNBooleanConverter.class)
	private boolean deleted;
	
	@Convert(converter = YNBooleanConverter.class)
	@Column(name = "ADULT_ONLY")
	private boolean adultOnly;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "PRODUCT_RESOURCES_MAP", 
	  		joinColumns = @JoinColumn(name = "PRODUCT_ID"),
	  		inverseJoinColumns = @JoinColumn(name = "ID"))
	private List<ResourceAmountMap> composition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isAdultOnly() {
		return adultOnly;
	}

	public void setAdultOnly(boolean adultOnly) {
		this.adultOnly = adultOnly;
	}

	public List<ResourceAmountMap> getComposition() {
		return composition;
	}

	public void setComposition(List<ResourceAmountMap> composition) {
		this.composition = composition;
	}

	
	
}
