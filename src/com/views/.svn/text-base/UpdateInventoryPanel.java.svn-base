package com.views;

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

public class UpdateInventoryPanel extends JPanel implements ActionListener{

	private JButton addItem;
	
	private JTextField myProductId;
	private JTextField myProductName;
	private JTextField myProductDesc;
	private JTextArea resultArea;

	private InventoryController controller;
	

	private void buildGui() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
		myProductId = new JTextField(10);
		JLabel productIdLabel = new JLabel("Product ID: ");
		
		myProductName = new JTextField(10);
		JLabel productNameLabel = new JLabel("Product Name: ");
		
		myProductDesc = new JTextField(10);
		JLabel productDescLabel = new JLabel("Product Description: ");
				
		addItem = new JButton("Update Item");
		addItem.setActionCommand("update");
		addItem.addActionListener(this);
		

		this.add(productIdLabel);
		this.add(myProductId);
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
	
	
	public UpdateInventoryPanel(InventoryController controller) {
		this.controller = controller;
		buildGui();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("update"))
		{
			int result = controller.updateItem(new Product(Integer.parseInt(myProductId.getText()),myProductName.getText(),myProductDesc.getText()));			
			resultArea.append(result + " number of items were updated.\n");
		}
		
	}

}
