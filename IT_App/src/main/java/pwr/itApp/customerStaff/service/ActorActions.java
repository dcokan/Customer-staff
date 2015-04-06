package pwr.itApp.customerStaff.service;

import static pwr.itApp.customerStaff.webapp.TextResourceKeys.USER_NOT_FOUND_MSG;
import static pwr.itApp.customerStaff.webapp.TextResourceKeys.WRONG_PASS_MSG;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.persistance.UserDAO;
import pwr.itApp.customerStaff.webapp.ApplicationURL;
import pwr.itApp.customerStaff.webapp.ResourceBundle;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Service
public class ActorActions {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Actor actor;
	@Autowired
	private ResourceBundle rb;
	
	public boolean authenticate(String login, String pass) {
		User userByLogin = userDAO.findUserByLogin(login);
		
		if (userByLogin == null) {
			addMessage(rb.getString(USER_NOT_FOUND_MSG));
			return false;
		} else if (!validUserPassword(userByLogin, pass)) {
			addMessage(rb.getString(WRONG_PASS_MSG));
			return false;
		} else {
			actor.afterAuthentication(userByLogin);
			return true;
		}
	}

	private boolean validUserPassword(User userByLogin, String pass) {
		byte[] passToCheckByte = pass.getBytes();
		String md5UserPass = 	userByLogin.getPassHash();
		String md5ToCheckPass = DigestUtils.md5DigestAsHex(passToCheckByte);	
		
		return md5ToCheckPass.equals(md5UserPass);
	}

	private void addMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(message));
	}
}
