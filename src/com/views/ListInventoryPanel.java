package com.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.inventory.controllers.InventoryController;
import com.inventory.model.Product;

public class ListInventoryPanel extends JPanel{

	private JButton addItem;
	
	private JTextField myProductId;
	private JTextField myProductName;
	private JTextField myProductDesc;
	private JTextArea resultArea;

	private InventoryController controller;
	
	public ListInventoryPanel(InventoryController controller) {
		this.controller = controller;
		buildGui();
	}
	
	public void buildGui() 
	{	
		removeAll();
		setLayout(new BorderLayout());
		
		//product data
		Map<Integer, Product> products = controller.listItems();
		
		//product headers
		String[] productHeaders = new String[]{"ID", "Name", "Description"};
				
		JTextArea allProductsArea = new JTextArea(20, 20);	
		
		TableColumnModel columnModel = new DefaultTableColumnModel();
		
		TableColumn firstColumn = new TableColumn(0);
		firstColumn.setHeaderValue(productHeaders[0]);
		TableColumn secondColumn = new TableColumn(1);
		secondColumn.setHeaderValue(productHeaders[1]);
		TableColumn thirdColumn = new TableColumn(2);
		thirdColumn.setHeaderValue(productHeaders[2]);
		columnModel.addColumn(firstColumn);
		columnModel.addColumn(secondColumn);
		columnModel.addColumn(thirdColumn);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn(firstColumn);
		tableModel.addColumn(secondColumn);
		tableModel.addColumn(thirdColumn);				
		
		for (Map.Entry<Integer, Product> entry : products.entrySet()) 
		{
			Vector<String> rowData = new Vector<String>();
			rowData.addElement(String.valueOf(entry.getKey()));
			rowData.addElement(entry.getValue().getName());
			rowData.addElement(entry.getValue().getDescription());
			tableModel.addRow(rowData);
		}
		
		JTable productTable = new JTable(tableModel, columnModel);		
		JScrollPane resultScrollPane = new JScrollPane(productTable);
		
		add(new JLabel("List all entry"), BorderLayout.PAGE_START);		
		add(resultScrollPane, BorderLayout.CENTER);
		
		revalidate();
	}


}
