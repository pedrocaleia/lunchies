package com.lunchies.gui.views;

import java.util.List;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

import com.lunchies.gui.clients.OrderClient;
import com.lunchies.gui.rtos.OrderRto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;

import jakarta.annotation.security.PermitAll;

/**
 * @author Pedro Caleia
 */
@SuppressWarnings("serial")
@Route("listorder")
@PermitAll
public class ListOrderView extends VerticalLayout {
	
	public ListOrderView(AuthenticationContext authContext, OrderClient orderClient) {
		Optional<DefaultOidcUser> userDetails = authContext.getAuthenticatedUser(DefaultOidcUser.class);
		
		List<OrderRto> orders = orderClient.getOrdersForEmployee(userDetails.get().getName());
		
		Grid<OrderRto> grid = new Grid<>();
		grid.addColumn(OrderRto::getEntry);
		grid.addColumn(OrderRto::getMainCourse);
		grid.addColumn(OrderRto::getBeverage);
		grid.addColumn(OrderRto::getCalories);
		grid.setItems(orders);
		
		add(grid);
		
		Button backButton = new Button("Back");
        backButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		backButton.addClickListener(event -> {
			UI.getCurrent().navigate(MainView.class);
		});
		
		add(backButton);
	}

}
