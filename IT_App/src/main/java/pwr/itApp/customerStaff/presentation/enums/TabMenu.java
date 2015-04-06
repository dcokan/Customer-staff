package pwr.itApp.customerStaff.presentation.enums;

import pwr.itApp.customerStaff.webapp.ApplicationURL;

public enum TabMenu {
	EMPLOYEERS("tabMenu.employeers", ApplicationURL.EMPLOYEERS),
	PRODUCTS("tabMenu.products", ApplicationURL.PRODUCTS),
	RESOURCES("tabMenu.resources", ApplicationURL.RESOURCES),
	RESTAURANTS("tabMenu.restaurants", ApplicationURL.RESTAURANTS);

	private String nameKey;
	private String entryURL;
	
	private TabMenu(String nameKey, String entryURL) {
		this.nameKey = nameKey;
		this.entryURL = entryURL;
	}

	public String getNameKey() {
		return nameKey;
	}

	public String getEntryURL() {
		return entryURL;
	}

}
