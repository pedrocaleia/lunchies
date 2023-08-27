package com.lunchies.gui.views;

import org.springframework.web.reactive.function.client.WebClient;

import com.lunchies.gui.rtos.ProductRto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;

/**
 * @author Pedro Caleia
 */
@SuppressWarnings("serial")
@Route("listproduct")
@PermitAll
public class ListProductView extends VerticalLayout {
	
	/*@Autowired
    private WebClient webClient;*/
	
	public ListProductView(WebClient webClient) {
		ProductRto[] products = webClient
				.get()
				.uri("http://127.0.0.1:9091/product")
				//.attributes(oauth2AuthorizedClient(authorizedClient))
				.retrieve()
				.bodyToMono(ProductRto[].class)
				.block();

		Grid<ProductRto> grid = new Grid<>();
		grid.addColumn(ProductRto::getName);
		grid.addColumn(ProductRto::getDescription);
		grid.addColumn(ProductRto::getType);
		grid.addColumn(ProductRto::getCalorieCount);
		grid.setItems(products);
		
		add(grid);
		
		Button backButton = new Button("Back");
        backButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		backButton.addClickListener(event -> {
			UI.getCurrent().navigate(MainView.class);
		});
		
		add(backButton);
	}

}
