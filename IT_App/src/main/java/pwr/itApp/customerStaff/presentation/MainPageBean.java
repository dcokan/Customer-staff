package pwr.itApp.customerStaff.presentation;

import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

@Component("mainPage")
@ViewScoped
public class MainPageBean {
	
	public String getTestMessage() {
		return "Testing bean";
	}
}
