package pwr.itApp.customerStaff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.persistance.UserDAO;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void createUser(UserDTO userData) {
		User user = new User();
		user.setCreatorId(userData.getCreatorId());
		user.setEmplType(userData.getEmplType());
		user.setFirstname(userData.getFirstname());
		user.setLastname(userData.getLastname());
		user.setLogin(userData.getLogin());
		user.setMail(userData.getMail());
		user.setPassHash(DigestUtils.md5DigestAsHex(userData.getPass().getBytes()));
		user.setRestaurant(userData.getRestaurant());
		user.setTel(userData.getTel());
		
		userDAO.persistNewEntity(user);
	}

	public boolean isUniqueUserName(String login) {
		User user = userDAO.findUserByLogin(login, true);
		return user == null;
	}

}
