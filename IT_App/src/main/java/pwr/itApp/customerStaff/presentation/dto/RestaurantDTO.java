package pwr.itApp.customerStaff.presentation.dto;

import java.util.List;

import pwr.itApp.customerStaff.presentation.components.ElementComponent;

public class RestaurantDTO implements ElementComponent {

	private Integer id;
	
	private String restaurantName;
	
	private String street;
	
	private String city;
	
	private String tel1;
	
	private String tel2;
	
	private String mail;
//	private Integer ownerId;
	private boolean deleted;
	
	private String restaurantDescription;
	
	private List<TableDTO> tables;
	
	private List<ProductDTO> products;
	
    @Override
    public String getName() {
        return restaurantName;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        sb.append("Simple description\n");
        sb.append("address");
        return sb.toString();
    }

	@Override
	public String getImageURL() {
		// TODO Auto-generated method stub
		return "images/tmp2.jpg";
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getTel1() {
		return tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public String getMail() {
		return mail;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public List<TableDTO> getTables() {
		return tables;
	}

	public void setName(String name) {
		this.restaurantName = name;
	}

	
	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setDescription(String description) {
		this.restaurantDescription = description;
	}

	public void setTables(List<TableDTO> tables) {
		this.tables = tables;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public String getRestaurantDescription() {
		return restaurantDescription;
	}

	public void setRestaurantDescription(String restaurantDescription) {
		this.restaurantDescription = restaurantDescription;
	}

}
