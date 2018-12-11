package org.cap.demo.service;

import java.util.List;

import org.cap.demo.model.Product;

public interface IInventoryService {

	public List<Product> saveProduct(Product product);
	public List<Product> getAllProducts();
	public boolean deleteProducts(Integer productId);
	public List<Product> updateProduct(Product product);
	
	

}
