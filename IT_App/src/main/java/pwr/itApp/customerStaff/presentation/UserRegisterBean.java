package pwr.itApp.customerStaff.presentation;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.enums.EmplType;
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
	
	public String onNewAccountRegistry() {
		log.info("New user button clicked");
		if (!validData()) {
			return null;
		}
		prepareAccountForCustomer();
		userService.createUser(user);
		return ApplicationURL.MAIN_PAGE + ApplicationURL.RELOAD;
	}

	private boolean validData() {
		if (!userService.isUniqueUserName(user.getLogin())) {
			addMessage(rb.getString(TextResourceKeys.DUPLICATED_LOGIN));
			return false;
		}
		
		return true;
	}

	private void prepareAccountForCustomer() {
		//TODO: uncomment this after actor will be correctly involved in the app
		//user.setCreatorId(actor.getUser().getId());
		user.setEmplType(EmplType.CUSTOMER);
	}
	

	private void addMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(message));
	}
	
}
