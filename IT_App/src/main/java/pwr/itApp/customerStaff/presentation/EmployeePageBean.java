package pwr.itApp.customerStaff.presentation;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;
import pwr.itApp.customerStaff.service.UserService;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("employeePage")
@Scope("view")
public class EmployeePageBean implements ElementsList<UserDTO>, Serializable{
	private static final long serialVersionUID = -2525555346910993483L;
	private List<UserDTO> userList;
	private UserDTO selectedUser;
	private boolean newEmployeeMode;
	
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
		newEmployeeMode = true;
	}

	@Override
	public void onDeailShowButton(UserDTO user) {
		newEmployeeMode = false;
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

	public boolean isNewEmployeeMode() {
		return newEmployeeMode;
	}

	public void setNewEmployeeMode(boolean newEmployeeMode) {
		this.newEmployeeMode = newEmployeeMode;
	}
	
	
}
