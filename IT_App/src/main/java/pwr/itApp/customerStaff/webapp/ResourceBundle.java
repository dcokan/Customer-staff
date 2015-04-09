package pwr.itApp.customerStaff.webapp;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Dawid Cokan
 * Just to make it possible to use it in application before real
 * RB will be created
 *
 */
@Service("mockRB")
@SessionScoped
@Deprecated
public class ResourceBundle {

	public String getString(Object obj) { 
		return "mock-"+obj.toString();
	}
}
