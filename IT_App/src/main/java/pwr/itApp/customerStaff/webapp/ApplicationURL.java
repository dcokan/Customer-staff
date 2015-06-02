package pwr.itApp.customerStaff.webapp;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;

import pwr.itApp.customerStaff.presentation.dto.ResourceDTO;


public class ApplicationURL {

	private ApplicationURL() {}

	public static final String RELOAD = "?faces-redirect=true";
	
	public static final String MAIN_PAGE = "/public/index.jsf";
	public static final String REGISTER = "/public/register.jsf";
	public static final String EMPLOYEERS = "/administration/employee.jsf";
	public static final String PRODUCTS = "/administration/products.jsf";
	public static final String RESOURCES = "/administration/resources.jsf";
	public static final String RESTAURANTS = "/administration/restaurants.jsf"; 
	public static final String NEW_EMPLOYEE = "/public/create_account.jsf";
	

	/**
	 * Redirect to given address and redirect by default
	 * @param URL - address where user has to be redirected to
	 */
	public static void redirect(String URL) {
		redirect(URL, true);
	}

	public static void redirect(String URL, boolean reload) {
	    try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(URL + (reload ? RELOAD : ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void puToFlash(String itemName, Serializable item) {
		FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().put(itemName, item);
	}

	public static Object getFromFlash(String itemCode) {
		return FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().get(itemCode);
	}
}
