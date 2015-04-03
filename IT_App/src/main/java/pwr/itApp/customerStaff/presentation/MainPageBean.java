package pwr.itApp.customerStaff.presentation;

import java.util.ArrayList;
import java.util.List;
	
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;
import pwr.itApp.customerStaff.presentation.login.LoginForm;
import pwr.itApp.customerStaff.service.ActorActions;
import pwr.itApp.customerStaff.webapp.ApplicationURL;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("mainPage")
@SessionScoped
public class MainPageBean implements ElementsList<RestaurantDTO> {
	
	@Autowired
	private LoginForm loginForm;
	
	@Autowired
	private ActorActions actorActions;
	
	@Autowired
	private Actor actor;
	
	public boolean isUserLogged() {
		return actor.getUser() != null;
	}
	
	public String loginAction() {
		if (actorActions.authenticate(loginForm.getLoginUsername(), 
				loginForm.getPassword())) {
			return ApplicationURL.REGISTER;
		} else {
			return ApplicationURL.MAIN_PAGE;
		}
	}
	
	@Override
	public List<RestaurantDTO> getValueList() {
		// TODO Auto-generated method stub
		List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();
		restaurants.add(new RestaurantDTO());
		return restaurants;
	}
}
