package pwr.itApp.customerStaff.presentation.login;

import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;

@Component
@RequestScoped
public class LoginForm {

	private String loginUsername;
	private String passHash;
	
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getPassHash() {
		return passHash;
	}
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	
}
