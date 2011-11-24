package com.inventory.controllers;

import java.util.Map;

import com.inventory.dao.InventoryDao;
import com.inventory.dao.InventoryDaoImpl;
import com.inventory.model.Product;
import com.views.InventoryView;

public class InventoryControllerImpl implements InventoryController {
			
	private InventoryDao dao;
	private InventoryView view;
	
    public InventoryControllerImpl(){
    	this.dao = new InventoryDaoImpl();
    }
    
	public void setView(InventoryView view) {
		this.view = view;
	}

	@Override
	public void addItem(Product product) {
		this.dao.create(product);
		view.updateListeners();	
	}
	
	public Map<Integer, Product> listItems()
	{
		return this.dao.listAllProducts();
	}
	

	@Override
	public int updateItem(Product product) {
		int numberOfUpdates = 0;
		Product foundProduct = getItem(product.getId());
		
		if (foundProduct.getName() != null) {
			numberOfUpdates = dao.update(product);
			view.updateListeners();	
		}		
		return numberOfUpdates;
	}

	@Override
	public Product getItem(int id) {
		return dao.get(id);
	}

}
