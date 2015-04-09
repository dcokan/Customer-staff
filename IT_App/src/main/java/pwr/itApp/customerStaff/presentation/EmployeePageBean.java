package pwr.itApp.customerStaff.presentation;

import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;
import pwr.itApp.customerStaff.service.UserService;
import pwr.itApp.customerStaff.webapp.ApplicationURL;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("employeePage")
@ViewScoped
public class EmployeePageBean implements ElementsList<UserDTO> {

	@Autowired
	private UserService userService;
	
	private List<UserDTO> userList;
	
	@Autowired
	private Actor actor;
	
	@Override
	public List<UserDTO> getValueList() {
		if (userList == null) {
			userList = userService.getUserEmployeers(actor.getUser());
		}
		
		return userList;
	}

	@Override
	public String onNewItemButton() {
		return ApplicationURL.NEW_EMPLOYEE + ApplicationURL.RELOAD;
	}
	
	
}
