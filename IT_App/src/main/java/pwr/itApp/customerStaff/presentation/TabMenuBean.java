package pwr.itApp.customerStaff.presentation;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component("tabMenu")
@SessionScoped
public class TabMenuBean implements Serializable {
	private static final long serialVersionUID = -2149085665570492742L;
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
