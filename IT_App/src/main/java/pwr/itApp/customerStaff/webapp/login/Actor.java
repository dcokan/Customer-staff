package pwr.itApp.customerStaff.webapp.login;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.Restaurant;
import pwr.itApp.customerStaff.domain.User;

@Component
@SessionScoped
public class Actor {
	
	private User user;
	private Restaurant restaurant;
	
	public void afterAuthentication(User loggedUser) {
		this.user = loggedUser;
		this.restaurant = user.getRestaurant();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public void logoutUser() {
		setUser(null);
	}
	
	public Restaurant getChosenRestaurant() {
//		return user == null ? null : user.getRestaurant();
		return restaurant;
	}

	public Integer getChosenRestaurantId() {
		Restaurant rest = getChosenRestaurant();
		return rest == null ? null : rest.getId();
	}
	
	
}
