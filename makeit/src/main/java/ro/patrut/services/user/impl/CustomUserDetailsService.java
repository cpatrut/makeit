package ro.patrut.services.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ro.patrut.models.user.User;
import ro.patrut.models.user.UserProfile;
import ro.patrut.services.user.UserService;

public class CustomUserDetailsService implements UserDetailsService {

	final static Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);

	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
		User user = userService.findBySso(ssoId);
		if (user == null) {
			LOG.warn("User not found");
			throw new UsernameNotFoundException("Username not found");
		}

		return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
				user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserProfile userProfile : user.getUserProfiles()) {
			LOG.debug("User profile:" + userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));

		}
		LOG.debug("authorities:" + authorities);
		return authorities;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
