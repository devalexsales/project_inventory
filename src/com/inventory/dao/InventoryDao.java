package com.inventory.dao;

import java.util.List;
import java.util.Map;

import com.inventory.model.Product;

public interface InventoryDao {
	
	void create(Product item);


	Map<Integer, Product> listAllProducts();

	
	int update(Product item);
	
	Product get(int id);
}
