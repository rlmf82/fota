package man.fota.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	public static final String context = "/fota";
	
    @Override
    public void configure(HttpSecurity http) throws Exception {

    	http.headers().frameOptions().disable();
    	
    	http.authorizeRequests()
        	
        	.antMatchers(HttpMethod.GET, context + "/oauth/token").permitAll()
            .antMatchers(HttpMethod.GET, context + "/read").permitAll()
            .antMatchers(HttpMethod.POST, context + "/user").permitAll()
            .antMatchers(HttpMethod.GET, context + "/user").authenticated();
    }
}