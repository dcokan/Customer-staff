package pwr.itApp.customerStaff.presentation;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.persistance.UserDAO;

@Component("mainPage")
@ViewScoped
public class MainPageBean {
	
	@Autowired
	private UserDAO userDAO;
	
	public String getTestMessage() {
		User user = userDAO.find(1);
		return "Testing bean";
	}
}
