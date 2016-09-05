package ro.patrut.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	//configure authentication
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	//configure authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home")
				.permitAll().antMatchers("/admin/**").access("hasRole('ADMIN')").antMatchers("/db/**")
				.access("hasRole('ADMIN') and hasRole('DBA')").and().formLogin().loginPage("/login")
				.usernameParameter("ssoId").passwordParameter("password").and().csrf().and().exceptionHandling()
				.accessDeniedPage("/access-denied");
		
		//and().logout().logoutSuccessHandler(logoutsuccesshandler).invalidateHttpSession(true).addLogoutHandler(logoutHandler).deleteCookies(cookieNamesToClear)
		
		
	}
	

}
