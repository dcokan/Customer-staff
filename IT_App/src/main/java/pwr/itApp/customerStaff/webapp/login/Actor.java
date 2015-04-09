package pwr.itApp.customerStaff.webapp.login;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.User;

@Component
@SessionScoped
public class Actor {
	
	private User user;
	
	public void afterAuthentication(User loggedUser) {
		this.user = loggedUser;
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
	
	
}
