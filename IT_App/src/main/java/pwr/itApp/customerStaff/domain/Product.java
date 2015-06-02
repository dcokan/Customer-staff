package pwr.itApp.customerStaff.domain;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pwr.itApp.customerStaff.domain.converters.ProductTypeConverter;
import pwr.itApp.customerStaff.domain.converters.YNBooleanConverter;
import pwr.itApp.customerStaff.domain.enums.ProductType;

@Entity

@SequenceGenerator(name = "ProductSequence", sequenceName = "SEQ_PRODUCTS", allocationSize = 1)
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@GeneratedValue(generator = "ProductSequence")
	private Integer id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	@Convert(converter = ProductTypeConverter.class)
	@Column(name = "TYPE")
	private ProductType productType;
	
	@Convert(converter = YNBooleanConverter.class)
	private boolean deleted;
	
	@Convert(converter = YNBooleanConverter.class)
	@Column(name = "ADULT_ONLY")
	private boolean adultOnly;

//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name = "PRODUCT_RESOURCES_MAP", 
//	  		joinColumns = @JoinColumn(name = "PRODUCT_ID"),
//	  		inverseJoinColumns = @JoinColumn(name = "ID"))
//	private List<ResourceAmountMap> composition;
	@ElementCollection
	@JoinTable(name="PRODUCT_RESOURCES_MAP", 
		joinColumns=@JoinColumn(name="PRODUCT_ID"))
	@MapKeyColumn (name="RESOURCE_ID")
	@Column(name="AMOUNT")
	private Map<Integer, Double> composition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
//
//	public List<ResourceAmountMap> getComposition() {
//		return composition;
//	}
//
//	public void setComposition(List<ResourceAmountMap> composition) {
//		this.composition = composition;
//	}

	public Map<Integer, Double> getComposition() {
		return composition;
	}

	public void setComposition(Map<Integer, Double> composition) {
		this.composition = composition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "("+id+") " + name;
	}
	
	
}
