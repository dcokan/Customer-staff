package pwr.itApp.customerStaff.webapp;


public class ApplicationURL {

	private ApplicationURL() {}

	public static final String RELOAD = "?faces-redirect=true";
	
	public static final String MAIN_PAGE = "/public/index.jsf";
	public static final String REGISTER = "/public/register.jsf";
	public static final String EMPLOYEERS = "/public/administration/employee.jsf";
	public static final String PRODUCTS = "/public/administration/products.jsf";
	public static final String RESOURCES = "/public/administration/resources.jsf";
	public static final String RESTAURANTS = "/public/administration/restaurants.jsf"; 
	public static final String NEW_EMPLOYEE = "/public/create_account.jsf";
}
