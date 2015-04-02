package pwr.itApp.customerStaff.presentation.components;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.dto.UserDTO;
import pwr.itApp.customerStaff.webapp.ResourceBundle;

@Component("newUser")
@ViewScoped
public class NewUserForm {
	@Autowired
	private ResourceBundle rb;
	
	private UserDTO user;

	
	@PostConstruct
	public void init() {
		user = new UserDTO();
	}
	
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}
