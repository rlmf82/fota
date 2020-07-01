package man.fota.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import man.fota.request.dto.UserRequest;

@Entity
@Table(name = "user", schema = "fota") 
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGIN")
    private String login;
    
    @Column(name = "PASSWORD")
    private String password;

    public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public static User transform(UserRequest request, PasswordEncoder passwordEncoder) {
		User user = new User();
		user.setLogin(request.getLogin());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		return user;
	}
}