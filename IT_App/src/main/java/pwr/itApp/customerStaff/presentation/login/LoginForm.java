package pwr.itApp.customerStaff.presentation.login;

import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;

@Component("loginForm")
@RequestScoped
public class LoginForm {

	private String loginUsername;
	private String password;
	
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
