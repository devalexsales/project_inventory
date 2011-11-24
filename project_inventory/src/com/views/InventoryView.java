package com.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.inventory.controllers.InventoryController;
import com.inventory.controllers.InventoryControllerImpl;
import com.inventory.model.Product;

public class InventoryView extends JFrame {
	
	private InventoryController controller; 
	private AddInventoryPanel addInventory;
	private UpdateInventoryPanel updateInventory;
	private ListInventoryPanel listInventory;
	
	public InventoryView(InventoryController controller) {
		this.controller = controller;
		addInventory = new AddInventoryPanel(controller);
		updateInventory = new UpdateInventoryPanel(controller);
		listInventory = new ListInventoryPanel(controller);
		buildGui();
	}

	public void setController(InventoryControllerImpl controller) {
		this.controller = controller;
	}
	
	private void buildGui() 
	{
		this.setSize(640, 640);
		
		JPanel topPanel = new JPanel();
		JTabbedPane tabMenu = new JTabbedPane();
		
		//add here
		tabMenu.addTab("List Item",listInventory);
		tabMenu.addTab("Add Item",addInventory);
		tabMenu.addTab("Update Item",updateInventory);
		
		tabMenu.setSelectedComponent(addInventory);
		topPanel.add(tabMenu);
		getContentPane().add(topPanel);
		setVisible(true);		

	}

	public void updateListeners() 
	{
		listInventory.buildGui();		
	}


	
	
	
	
}
