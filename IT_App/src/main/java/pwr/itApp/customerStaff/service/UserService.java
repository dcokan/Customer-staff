package pwr.itApp.customerStaff.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.persistance.UserDAO;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;
import pwr.itApp.customerStaff.service.factory.UserFactory;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserFactory userFactory;
	
	public void createUser(UserDTO userData) {
		userDAO.persistNewEntity(userFactory.getEntity(userData));
	}

	public boolean isUniqueUserName(String login) {
		User user = userDAO.findUserByLogin(login, true);
		return user == null;
	}

	public List<UserDTO> getUserEmployeers(User user) {
		List<User> allUsers = new ArrayList<User>();
		List<User> createdByUser = userDAO.findAllCreatedByUser(user.getId());
		List<User> workingInUserRestaurant = null;
		if (user.getRestaurant() != null) {
			workingInUserRestaurant = userDAO.findAllWorkingInRestaurant(user.getRestaurant().getId());
			allUsers.addAll(workingInUserRestaurant);
		}
		
		allUsers.addAll(createdByUser);
		return userFactory.getDTOList(allUsers);
	}

}
