package man.fota.request.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import man.fota.entity.User;

public class UsuarioCustom implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String login;
    private String password;

    public UsuarioCustom(User usuario) {
        this.login = usuario.getLogin();
        this.password = usuario.getPassword();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}