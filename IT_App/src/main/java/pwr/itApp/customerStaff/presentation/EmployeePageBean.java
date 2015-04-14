package pwr.itApp.customerStaff.presentation;

import java.util.List;

import javax.faces.bean.ViewScoped;

import oracle.net.aso.s;

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

	private List<UserDTO> userList;
	private UserDTO selectedUser;

	@Autowired
	private UserService userService;
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
	public void onNewItemButton() {
		ApplicationURL.redirect(ApplicationURL.NEW_EMPLOYEE + ApplicationURL.RELOAD);
	}

	@Override
	public void onDeailShowButton(UserDTO user) {
		selectedUser = user;
	}
	
	public boolean isUserSelected() {
		return selectedUser != null;
	}

	public UserDTO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserDTO selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	
}
