package pwr.itApp.customerStaff.webapp.login;

import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;
import pwr.itApp.customerStaff.service.factory.RestaurantFactory;

@Component
@SessionScoped
public class Actor {
	
	@Autowired
	private RestaurantFactory restaurantFactory;
	
	private User user;
	private RestaurantDTO restaurant;
	
	public void afterAuthentication(User loggedUser) {
		this.user = loggedUser;
		this.restaurant = restaurantFactory.getDTO(user.getRestaurant());
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
	
	public RestaurantDTO getChosenRestaurant() {
//		return user == null ? null : user.getRestaurant();
		return restaurant;
	}

	public Integer getChosenRestaurantId() {
		RestaurantDTO rest = getChosenRestaurant();
		return rest == null ? null : rest.getId();
	}
	
	
}
