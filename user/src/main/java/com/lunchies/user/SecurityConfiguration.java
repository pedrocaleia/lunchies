package com.lunchies.user;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Pedro Caleia
 */
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated()).formLogin(withDefaults());
		return http.build();
	}

	@SuppressWarnings("deprecation")
	@Bean
	UserDetailsService users() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN", "USER").build();
		UserDetails pedrocaleia = User.withDefaultPasswordEncoder().username("pedrocaleia").password("password").roles("USER").build();
		return new InMemoryUserDetailsManager(admin, pedrocaleia);
	}

}
