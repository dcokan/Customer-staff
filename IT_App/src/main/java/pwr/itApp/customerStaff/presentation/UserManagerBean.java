package pwr.itApp.customerStaff.presentation;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.enums.EmplType;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;

@Component("userManager")
@ViewScoped
public class UserManagerBean {

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
	
	public EmplType[] getEmplTypes() {
		return EmplType.values();
	}
	
	
}
