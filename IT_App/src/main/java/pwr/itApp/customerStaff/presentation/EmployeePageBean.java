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
	
	@Autowired
	private Actor actor;
	
	@Override
	public List<UserDTO> getValueList() {
		return userService.getUserEmployeers(actor.getUser());
	}

	@Override
	public String onNewItemButton() {
		return ApplicationURL.NEW_EMPLOYEE + ApplicationURL.RELOAD;
	}
	
	
}
