package com.lunchies.gui.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.lunchies.gui.rtos.NewProductRto;
import com.lunchies.gui.rtos.NewProductRtoResponse;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;

/**
 * @author Pedro Caleia
 */
@SuppressWarnings("serial")
@Route("newproduct")
@PermitAll
public class NewProductView extends VerticalLayout {
	
	@Autowired
    private WebClient webClient;
	
	// Add AuthenticationContext authContext when the authorization mechanism is working
	public NewProductView() {
		TextField name = new TextField("Name");
		name.setRequired(true);
		TextField description = new TextField("Description");
		description.setRequired(true);
		
		Select<String> typeSelect = new Select<>();
		typeSelect.setRequiredIndicatorVisible(true);
		typeSelect.setLabel("Type");
		typeSelect.setItems("ENTRY", "MAIN_COURSE", "BEVERAGE");
		typeSelect.setValue("ENTRY");
		
		NumberField calorieCount = new NumberField("Calorie Count");
		calorieCount.setRequired(true);
		
		Span messageSpan = new Span();
		
		// TODO pedrocaleia
		//Optional<DefaultOidcUser> userDetails = authContext.getAuthenticatedUser(DefaultOidcUser.class);
		
		Button submitButton = new Button("Save");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        Button backButton = new Button("Back");
        backButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		FormLayout formLayout = new FormLayout(name, description, typeSelect, calorieCount, messageSpan, submitButton, backButton);
        
		add(formLayout);
		
		submitButton.addClickListener(event -> {
            try {
            	NewProductRto newProduct = new NewProductRto(name.getValue(), description.getValue(), typeSelect.getValue(), calorieCount.getValue().intValue());
    			
            	NewProductRtoResponse response = this.webClient
        			.post()
        			.uri("http://127.0.0.1:9091/product")
        			//.attributes(oauth2AuthorizedClient(authorizedClient))
        			.bodyValue(newProduct)
        			.retrieve()
        			.bodyToMono(NewProductRtoResponse.class)
        			.block();
    			
    			Notification notification = Notification.show("Product saved with id '" + response.getId() + "'");
    	        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    	        
    	        UI.getCurrent().navigate(MainView.class);
            }
            /*catch(ValidationException ve) {
            	ve.printStackTrace();
            }
            catch(ServiceException se) {
            	se.printStackTrace();
            }*/
            catch(Exception e) {
            	Notification notification = Notification.show("Error while saving product");
            	notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
        });
		
		backButton.addClickListener(event -> {
			UI.getCurrent().navigate(MainView.class);
		});
	}

}
