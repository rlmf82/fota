package man.fota.response.dto;

import java.io.Serializable;

import man.fota.entity.User;

public class UserResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String login;
	
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static UserResponse tranform(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setLogin(user.getLogin());
		userResponse.setPassword(user.getPassword());
		
		return userResponse;
	}
}