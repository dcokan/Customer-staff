package pwr.itApp.customerStaff.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.joda.time.DateTime;

import pwr.itApp.customerStaff.domain.converters.DateConverter;
import pwr.itApp.customerStaff.domain.converters.EmplTypeConverter;
import pwr.itApp.customerStaff.domain.converters.YNBooleanConverter;
import pwr.itApp.customerStaff.domain.enums.EmplType;

@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "UserSequence", sequenceName = "SEQ_USERS", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name="User.findUnDeletedByLogin",
			query = "SELECT u FROM User u WHERE "
				+ "u.login = :login AND "
				+ "u.deleted = 'N'"),
	@NamedQuery(name="User.findAllByLogin",
			query = "SELECT u FROM User u WHERE "
				+ "u.login = :login"),
	@NamedQuery(name="User.findAllCreatedByUser",
			query = "SELECT u FROM User u WHERE "
				+ "u.creatorId = :creatorId"),
	@NamedQuery(name="User.findAllWorkingInRestaurant",
			query = "SELECT u FROM User u WHERE "
				+ "u.restaurant.id = :restaurantId")
})
public class User {

	@Id
	@GeneratedValue(generator = "UserSequence")
	private int id;
	
	@Column
	private String login;
	
	private String firstname;
	
	private String lastname;
	
	private String mail;
	
	private String tel;

	@Column(name = "USER_PASS_HASH")
	private String passHash;
	
	@Convert(converter = DateConverter.class)
	@Column(name = "LAST_LOGIN")
	private DateTime lastLogin; 
	
	@Convert(converter = YNBooleanConverter.class)
	private boolean deleted;
	
	@Convert(converter = EmplTypeConverter.class)
	@Column(name = "EMPL_TYPE")
	private EmplType emplType;
	
	@Column(name = "CREATOR_ID")
	private Integer creatorId;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public DateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(DateTime lastLogin) {
		this.lastLogin = lastLogin;
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

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
}
