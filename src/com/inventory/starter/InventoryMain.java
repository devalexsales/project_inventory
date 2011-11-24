package com.inventory.starter;

import com.inventory.controllers.InventoryController;
import com.inventory.controllers.InventoryControllerImpl;
import com.views.InventoryView;

public class InventoryMain {
	public static void main(String[] args) {
		InventoryController controller = new InventoryControllerImpl();
		InventoryView view = new InventoryView(controller);
		controller.setView(view);
	}
}
