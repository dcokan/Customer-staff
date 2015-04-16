package pwr.itApp.customerStaff.presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.enums.EmplType;
import pwr.itApp.customerStaff.presentation.components.NewUserForm;
import pwr.itApp.customerStaff.presentation.dto.UserDTO;
import pwr.itApp.customerStaff.service.UserService;
import pwr.itApp.customerStaff.webapp.ApplicationURL;
import pwr.itApp.customerStaff.webapp.ResourceBundle;
import pwr.itApp.customerStaff.webapp.TextResourceKeys;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("userRegister")
@Scope("view")
public class UserRegisterBean implements Serializable {
	private static final long serialVersionUID = -3945140317631571930L;

	private static Logger log = LoggerFactory.logger(UserRegisterBean.class);
	
	@Autowired
	private Actor actor;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NewUserForm userForm;
	
	@Autowired
	private ResourceBundle rb;

	private String activationCode;
	private String activationMail;
	

	private String createNewUser(UserDTO user) {
		if (!validData(user)) {
			return null;
		}
		prepareAccountForUser(user);
		userService.createUser(user);
		return ApplicationURL.EMPLOYEERS + ApplicationURL.RELOAD;
	}
	
	private String createNewUser(EmplType emplType, UserDTO user) {
		user.setEmplType(emplType);
		return createNewUser(user);
	}

	private void prepareAccountForUser( UserDTO user) {
		switch (user.getEmplType()) {
		case BARMAN:
		case COOKER:
		case WAITER:
//			user.setRestaurant(actor.getUser().getRestaurants());
			user.setCreatorId(actor.getUser().getId());
			break;
		case CUSTOMER:
			//TODO: uncomment this after actor will be correctly involved in the app
			user.setCreatorId(actor.getUser().getId());
			break;
		case OWNER:
			//TODO: We should somehow validate ActivationCode
			break;
		
		}
	}

	public String onNewManagerAccountRegistry() {
		log.info("New manager user button clicked");
		return createNewUser(EmplType.OWNER, userForm.getUser());
	}

	public String onNewAccountRegistry() {
		log.info("New user button clicked");
		
		return createNewUser(EmplType.CUSTOMER, userForm.getUser());
	}
	
	public String onNewEmployeeCreated() {
		log.info("New employee button clicked");
		
		return createNewUser(userForm.getUser());
				
	}
	
	private boolean validData(UserDTO user) {
		if (!userService.isUniqueUserName(user.getLogin())) {
			addMessage(rb.getString(TextResourceKeys.DUPLICATED_LOGIN));
			return false;
		}
		
		return true;
	}

	private void addMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(message));
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getActivationMail() {
		return activationMail;
	}

	public void setActivationMail(String activationMail) {
		this.activationMail = activationMail;
	}
	
}
