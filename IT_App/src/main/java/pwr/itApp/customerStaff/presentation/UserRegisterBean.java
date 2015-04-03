package pwr.itApp.customerStaff.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@ViewScoped	
public class UserRegisterBean {
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
	
	public String onNewAccountRegistry() {
		log.info("New user button clicked");
		
		return createNewUser(EmplType.CUSTOMER, userForm.getUser()) ? 
				ApplicationURL.MAIN_PAGE + ApplicationURL.RELOAD : null;
	}

	private boolean createNewUser(EmplType emplType, UserDTO user) {
		if (!validData(user)) {
			return false;
		}
		prepareAccountForUser(emplType, user);
		userService.createUser(user);
		return true;
	}

	private void prepareAccountForUser(EmplType emplType, UserDTO user) {
		user.setEmplType(emplType);
		switch (emplType) {
		case BARMAN:
			break;
		case COOKER:
			break;
		case CUSTOMER:
			//TODO: uncomment this after actor will be correctly involved in the app
			//user.setCreatorId(actor.getUser().getId());
			break;
		case OWNER:
			//TODO: We should somehow validate ActivationCode
			break;
		case WAITER:
			break;
		default:
			break;
		
		}
	}

	public String onNewManagerAccountRegistry() {
		log.info("New manager user button clicked");
		return createNewUser(EmplType.OWNER, userForm.getUser()) ? 
				ApplicationURL.MAIN_PAGE + ApplicationURL.RELOAD : null;
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
