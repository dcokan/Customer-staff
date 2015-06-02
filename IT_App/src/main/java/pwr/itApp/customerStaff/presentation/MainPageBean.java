package pwr.itApp.customerStaff.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;
import pwr.itApp.customerStaff.presentation.enums.TabMenu;
import pwr.itApp.customerStaff.presentation.login.LoginForm;
import pwr.itApp.customerStaff.service.ActorActions;
import pwr.itApp.customerStaff.webapp.ApplicationURL;
import pwr.itApp.customerStaff.webapp.login.Actor;

@Component("mainPage")
@SessionScoped
public class MainPageBean implements ElementsList<RestaurantDTO>, Serializable {
	private static final long serialVersionUID = -1835800570392004951L;

	private static Logger log = LoggerFactory.logger(MainPageBean.class);
	
	@Autowired
	private LoginForm loginForm;
	
	@Autowired
	private ActorActions actorActions;
	
	@Autowired
	private Actor actor;
	
	@ManagedProperty("#{mainPage.selectedTab}")
	private TabMenu selectedTab;

	private RestaurantDTO selectedRestaurant;
	
	@PostConstruct
	public void init() {
		selectedTab = TabMenu.EMPLOYEERS;
	}
	
	public boolean isUserLogged() {
		return actor.getUser() != null;
	}
	
	public void onAccountCreate() {
		ApplicationURL.redirect(ApplicationURL.REGISTER);
	}
	
	public void onPasswordReminder() {
		//TODO: Reminder is not available at the moment
		ApplicationURL.redirect(ApplicationURL.MAIN_PAGE);
	}
	
	public void loginAction() {
		if (actorActions.authenticate(loginForm.getLoginUsername(), 
				loginForm.getPassword())) {
			ApplicationURL.redirect(ApplicationURL.EMPLOYEERS);
		} else {
			return;
		}
	}
	
	@Override
	public List<RestaurantDTO> getValueList() {
		// TODO Auto-generated method stub
		List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();
		restaurants.add(new RestaurantDTO());
		return restaurants;
	}

	public TabMenu[] getAdminTabs() {
		return TabMenu.values();
	}
	
	public String getLoggedUserName() {
		User usr = actor.getUser();
		return usr.getLastname() + ", " + usr.getFirstname();
	}

	public void onLogout() {
		log.info("User (" + actor.getUser().getId() + ") logs out" );
		actor.logoutUser();
		ApplicationURL.redirect(ApplicationURL.MAIN_PAGE);
	}
	
	public void onAdminTabChange() {
		ApplicationURL.redirect(selectedTab.getEntryURL(), false);
	}

	public TabMenu getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(TabMenu selectedTab) {
		this.selectedTab = selectedTab;
	}

	@Override
	public void onNewItemButton() {
		throw new UnsupportedOperationException("New entry is not acceptable");
	}

	@Override
	public void onDeailShowButton(RestaurantDTO restaurant) {
		selectedRestaurant = restaurant;
	}
	
}
