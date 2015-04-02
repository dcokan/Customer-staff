package pwr.itApp.customerStaff.presentation;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component("tabMenu")
@SessionScoped
public class TabMenuBean {

	private int activeIndex;
	
	@PostConstruct
	public void init() {
		activeIndex = 0;
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}
}
