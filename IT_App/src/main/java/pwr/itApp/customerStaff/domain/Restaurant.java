package pwr.itApp.customerStaff.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import pwr.itApp.customerStaff.domain.converters.YNBooleanConverter;

@Entity
@javax.persistence.Table(name = "RESTAURANTS")
public class Restaurant {

	@Id
	private int id;
	
	private String name;
	
	private String street;
	
	private String city;
	
	private String tel1;
	
	private String tel2;
	
	private String mail;
	
//	@Column(name = "OWNER_ID")
//	private Integer ownerId;
	
	@Convert(converter = YNBooleanConverter.class)
	private boolean deleted;
	
	private String description;

//	@OneToMany
//	@JoinColumn(referencedColumnName = "RESTAURANT_ID")
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name="RESTAURANT_ID")
	private List<Table> tables;
	

//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinTable(name = "PRODUCT_RESTAURANT_MAP", 
//	  		joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName="ID"),
//	  		inverseJoinColumns = @JoinColumn(name = "RESTAUTANT_ID", referencedColumnName="ID" ))
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCT_RESTAURANT_MAP",
		joinColumns = { 
			@JoinColumn(name = "RESTAURANT_ID") }, 
			inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
	private List<Product> products;
	
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel) {
		this.tel1 = tel;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

//	public Integer getOwnerId() {
//		return ownerId;
//	}
//
//	public void setOwnerId(Integer ownerId) {
//		this.ownerId = ownerId;
//	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Table> getTables() {
		return tables;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
