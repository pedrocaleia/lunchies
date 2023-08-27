package com.lunchies.gui.views;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

/**
 * @author Pedro Caleia
 */
@SuppressWarnings("serial")
@Route("login")
@AnonymousAllowed
public class LoginView extends VerticalLayout {
	
	private static final String OAUTH_URL = "/oauth2/authorization/lunchies-client-oidc";
	
	public LoginView() {
		Anchor loginLink = new Anchor(OAUTH_URL, "Login with Lunchies OAuth");
		loginLink.getElement().setAttribute("router-ignore", true);
		
		add(loginLink);
		
		getStyle().set("padding", "200px");
		setAlignItems(FlexComponent.Alignment.CENTER);
	}

}
