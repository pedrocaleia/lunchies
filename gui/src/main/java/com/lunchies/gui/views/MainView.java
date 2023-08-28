package com.lunchies.gui.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import jakarta.annotation.security.PermitAll;

/**
 * @author Pedro Caleia
 */
@SuppressWarnings("serial")
@Route("")
@PermitAll
public class MainView extends VerticalLayout {
	
	public MainView() {
		Div menu = new Div();
	    menu.add(new RouterLink("New Product", NewProductView.class));
	    menu.add(new Paragraph());
	    menu.add(new RouterLink("List Product", ListProductView.class));
	    menu.add(new Paragraph());
	    menu.add(new RouterLink("New Order", NewOrderView.class));
	    
	    add(menu);
	}

}
