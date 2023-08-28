package com.lunchies.gui.views;

import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.reactive.function.client.WebClient;

import com.lunchies.gui.clients.OrderClient;
import com.lunchies.gui.rtos.NewOrderRto;
import com.lunchies.gui.rtos.ProductRto;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;

import jakarta.annotation.security.PermitAll;

/**
 * @author Pedro Caleia
 */
@SuppressWarnings("serial")
@Route("neworder")
@PermitAll
public class NewOrderView extends VerticalLayout {
	
	public NewOrderView(OrderClient orderClient, WebClient webClient, AuthenticationContext authContext) {
		Optional<DefaultOidcUser> userDetails = authContext.getAuthenticatedUser(DefaultOidcUser.class);
		
		TextField employee = new TextField("Employee");
		employee.setRequired(true);
		employee.setValue(userDetails.get().getName());
		employee.setEnabled(false);
		
		NumberField calorieSum = new NumberField("Calories");
		calorieSum.setValue(0.0);
		calorieSum.setRequired(false);
		calorieSum.setEnabled(false);
		
		ProductRto[] entries = getProductsForType(webClient, "ENTRY");
		
		Select<ProductRto> entrySelect = new Select<>();
		entrySelect.setRequiredIndicatorVisible(true);
		entrySelect.setLabel("Entry");
		entrySelect.setItemLabelGenerator(ProductRto::getName);
		entrySelect.setItems(entries);
		entrySelect.addValueChangeListener(event -> {
			calculateNewCaloriesValue(calorieSum, event);
		});
		
		ProductRto[] mainCourses = getProductsForType(webClient, "MAIN_COURSE");
		
		Select<ProductRto> mainCourseSelect = new Select<>();
		mainCourseSelect.setRequiredIndicatorVisible(true);
		mainCourseSelect.setLabel("Main Course");
		mainCourseSelect.setItemLabelGenerator(ProductRto::getName);
		mainCourseSelect.setItems(mainCourses);
		mainCourseSelect.addValueChangeListener(event -> {
			calculateNewCaloriesValue(calorieSum, event);
		});
		
		ProductRto[] beverages = getProductsForType(webClient, "BEVERAGE");
		
		Select<ProductRto> beverageSelect = new Select<>();
		beverageSelect.setRequiredIndicatorVisible(true);
		beverageSelect.setLabel("Beverage");
		beverageSelect.setItemLabelGenerator(ProductRto::getName);
		beverageSelect.setItems(beverages);
		beverageSelect.addValueChangeListener(event -> {
			calculateNewCaloriesValue(calorieSum, event);
		});
		
		
		
		Button submitButton = new Button("Save");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        Button backButton = new Button("Back");
        backButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		FormLayout formLayout = new FormLayout(employee, calorieSum, entrySelect, mainCourseSelect, beverageSelect, submitButton, backButton);
		add(formLayout);
		
		submitButton.addClickListener(event -> {
            try {
            	NewOrderRto newOrder = new NewOrderRto(employee.getValue(), entrySelect.getValue().getId(), entrySelect.getValue().getCalorieCount(), mainCourseSelect.getValue().getId(), 
            			mainCourseSelect.getValue().getCalorieCount(), beverageSelect.getValue().getId(), beverageSelect.getValue().getCalorieCount());

            	int newOrderId = orderClient.saveNewOrder(newOrder);
            	
            	Notification notification = Notification.show("Order saved with id '" + newOrderId + "'");
    	        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    	        
    	        UI.getCurrent().navigate(MainView.class);
            }
            catch(Exception e) {
            	Notification notification = Notification.show("Error while saving Order");
            	notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });
		
		backButton.addClickListener(event -> {
			UI.getCurrent().navigate(MainView.class);
		});
	}
	
	private ProductRto[] getProductsForType(WebClient webClient, String type) {
		ProductRto[] products = webClient
				.get()
				.uri("http://127.0.0.1:9091/product?type=" + type)
				.retrieve()
				.bodyToMono(ProductRto[].class)
				.block();
		
		return products;
	}
	
	private void calculateNewCaloriesValue(NumberField calorieSum, ComponentValueChangeEvent<Select<ProductRto>, ProductRto> event) {
		if(event.getOldValue() == null) {
			calorieSum.setValue(calorieSum.getValue() + event.getValue().getCalorieCount());
		}
		else {
			calorieSum.setValue(calorieSum.getValue() - event.getOldValue().getCalorieCount() + event.getValue().getCalorieCount());
		}
	}

}
