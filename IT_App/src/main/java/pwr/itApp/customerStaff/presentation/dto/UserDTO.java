package pwr.itApp.customerStaff.presentation.dto;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import pwr.itApp.customerStaff.domain.Restaurant;
import pwr.itApp.customerStaff.domain.enums.EmplType;

public class UserDTO {
	Logger log = LoggerFactory.logger(getClass());
	private String firstname;
	private String lastname;
	private String login;
	private String mail;
	private String tel;
	private String pass;
	private String retypedPass;
	private boolean deleted;
	private EmplType emplType;
	private Integer creatorId;
	private Restaurant restaurant;
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRetypedPass() {
		return retypedPass;
	}

	public void setRetypedPass(String retypedPass) {
		this.retypedPass = retypedPass;
	}

	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public EmplType getEmplType() {
		return emplType;
	}
	
	public void setEmplType(EmplType emplType) {
		this.emplType = emplType;
	}
	
	public Integer getCreatorId() {
		return creatorId;
	}
	
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
