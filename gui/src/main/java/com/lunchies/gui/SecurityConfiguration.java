package com.lunchies.gui;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.vaadin.flow.spring.security.VaadinWebSecurity;

/**
 * @author Pedro Caleia
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {
	
	private static final String LOGIN_URL = "/login";

	@SuppressWarnings("removal")
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.oauth2Login().loginPage(LOGIN_URL).defaultSuccessUrl("/").permitAll();
	}

}
