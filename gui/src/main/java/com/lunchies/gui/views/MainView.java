package com.lunchies.gui.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * @author Pedro Caleia
 */
@SuppressWarnings("serial")
@Route
public class MainView extends VerticalLayout {
	
	public MainView() {
		Button testButton = new Button("Perform Test", t -> Notification.show("Test successful"));
		add(testButton);
	}

}
