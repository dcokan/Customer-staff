package pwr.itApp.customerStaff.webapp.utils;


public class LabelUtils {
	private LabelUtils() {
		throw new IllegalStateException("None initialized instance can exist");
	}
	

	public static String prepareResourceLabel(String resourceName, Double amount) {
		return resourceName + " (" + String.format("%.3f", amount) +" )";
	}
}
