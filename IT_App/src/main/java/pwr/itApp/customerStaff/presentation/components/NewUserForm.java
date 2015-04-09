package pwr.itApp.customerStaff.presentation.components;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.enums.EmplType;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;
import pwr.itApp.customerStaff.webapp.ResourceBundle;

@Component("newUser")
@RequestScoped
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

	/**
	 * CAUTION: Method excludes Owner and Customer
	 * @return
	 */
	public EmplType[] getEmplTypes() {
		EmplType allEnums[] = new EmplType[EmplType.values().length -2];
		int i=0;
		for (EmplType item: EmplType.values()) {
			if (!item.equals(EmplType.OWNER) && !item.equals(EmplType.CUSTOMER)) {
				allEnums[i++] = item;
			}
		}
		
		return allEnums;
	}
	
}
