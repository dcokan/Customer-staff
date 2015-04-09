package pwr.itApp.customerStaff.service.factory;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;
import pwr.itApp.customerStaff.webapp.ResourceBundle;
import pwr.itApp.customerStaff.webapp.TextResourceKeys;

@Service
public class UserFactory extends AbstractFactoryDTO<User, UserDTO>{

	@Autowired
	private ResourceBundle rb;
	
	@Override
	public UserDTO getDTO(User entity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstname(entity.getFirstname());
		userDTO.setLastname(entity.getLastname());
		userDTO.setLogin(entity.getLogin());
		userDTO.setDeleted(entity.isDeleted());
		userDTO.setCreatorId(entity.getCreatorId());
		userDTO.setEmplType(entity.getEmplType());
		userDTO.setMail(entity.getMail());
		userDTO.setRestaurant(entity.getRestaurant());
		userDTO.setTel(entity.getTel());
		
		userDTO.setDescription(MessageFormat.format(rb.getString(TextResourceKeys.EMPLOYEE_DESC), 
				 userDTO.getName(), rb.getString(userDTO.getEmplType().getNameKey())));
		
		return userDTO;
	}

	@Override
	public User getEntity(UserDTO userData) {
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
		
		return user;
	}


}
