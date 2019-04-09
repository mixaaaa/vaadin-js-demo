package com.gruenidev.vaadin.jsdemo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class JsDemoUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Label demoLabel = new Label("Init");

		final MyComponent mycomponent = new MyComponent();

		// Set the value from server-side
		mycomponent.setValue("Server-side value");

		// Process a value input by the user from the client-side
		mycomponent.addValueChangeListener(
				(MyComponent.ValueChangeListener) () -> Notification.show("Value: " + mycomponent.getValue()));

		VerticalLayout mainLayout = new VerticalLayout(demoLabel, mycomponent);

		setContent(mainLayout);
	}

}
