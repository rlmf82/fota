package man.fota.request.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import man.fota.validation.LoginAlreadyExist;

public class UserRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@LoginAlreadyExist
	@NotNull(message = "Login may not be empty or null")
	@NotEmpty(message = "Login may not be empty or null")
	private String login;
	
	@NotNull(message = "Password may not be empty or null")
	@NotEmpty(message = "Password may not be empty or null")
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}