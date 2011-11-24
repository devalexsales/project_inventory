package com.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.inventory.controllers.InventoryController;
import com.inventory.model.Product;

public class AddInventoryPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private JButton addItem;
	
	private JTextField myProductName = new JTextField(10);
	private JTextField myProductDesc = new JTextField(10);
	private JTextArea resultArea;

	private InventoryController controller;
	

	private void buildGui() {
		System.out.println("INT");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
		myProductName = new JTextField(10);
		JLabel productNameLabel = new JLabel("Product Name: ");
		
		myProductDesc = new JTextField(10);
		JLabel productDescLabel = new JLabel("Product Description: ");
				
		addItem = new JButton("Add Item");
		addItem.setActionCommand("add");
		addItem.addActionListener(this);
		this.add(productNameLabel);
		this.add(myProductName);
		this.add(productDescLabel);
		this.add(myProductDesc);		
		this.add(addItem);
		
		resultArea = new JTextArea(20, 20);
		JScrollPane resultScrollPane = new JScrollPane(resultArea);
		this.add(resultArea);
		this.add(resultScrollPane);
		
	}
	
	
	public AddInventoryPanel(InventoryController controller) {
		this.controller = controller;
		buildGui();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("add"))
		{
			controller.addItem(new Product(myProductName.getText(),myProductDesc.getText()));			
			resultArea.append("Product:  name="+ myProductName.getText() + ", description="+myProductDesc.getText()+"\n");
		}
		
	}
	
}
