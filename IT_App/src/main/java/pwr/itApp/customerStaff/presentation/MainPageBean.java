package pwr.itApp.customerStaff.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;
import pwr.itApp.customerStaff.presentation.enums.TabMenu;
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

	private TabMenu selectedTab;
	
	@PostConstruct
	public void init() {
		selectedTab = TabMenu.EMPLOYEERS;
	}
	
	public boolean isUserLogged() {
		return actor.getUser() != null;
	}
	
	public void loginAction() {
		if (actorActions.authenticate(loginForm.getLoginUsername(), 
				loginForm.getPassword())) {
			redirect(ApplicationURL.EMPLOYEERS+ApplicationURL.RELOAD);
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

	private void redirect(String URL) {
	    try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(URL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onAdminTabChange() {
		redirect(selectedTab.getEntryURL());
	}

	public TabMenu getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(TabMenu selectedTab) {
		this.selectedTab = selectedTab;
	}

	@Override
	public String onNewItemButton() {
		throw new UnsupportedOperationException("New entry is not acceptable");
	}
	
}
