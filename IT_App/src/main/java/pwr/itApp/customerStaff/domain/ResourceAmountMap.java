package pwr.itApp.customerStaff.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table(name = "PRODUCT_RESOURCES_MAP")
//@SequenceGenerator(name = "ProductResourceSequence", sequenceName = "SEQ_PRODUCT_RESOURCE", allocationSize = 1)
//public class ResourceAmountMap {
//	
//	@Id
//	@GeneratedValue(generator = "ProductResourceSequence")
//	private Integer id;
//
//	private double amount;
//
//    @OneToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="RESOURCE_ID", referencedColumnName="ID")
//	private Resource resource;
//	
////    @ManyToOne
////    @JoinColumn(name="PRODUCT_ID")
////    private Product product;
//    
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
//
//	public Resource getResource() {
//		return resource;
//	}
//
//	public void setResource(Resource resource) {
//		this.resource = resource;
//	}
////
////	public Product getProduct() {
////		return product;
////	}
////
////	public void setProduct(Product product) {
////		this.product = product;
////	}
//}
