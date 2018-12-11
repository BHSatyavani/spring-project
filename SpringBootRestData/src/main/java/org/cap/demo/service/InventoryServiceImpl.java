package org.cap.demo.service;

import java.util.List;

import org.cap.demo.dao.ICustomerDao;
import org.cap.demo.dao.IInventoryDao;
import org.cap.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inventoryService")
public class InventoryServiceImpl implements IInventoryService{

	@Autowired
	private IInventoryDao inventoryDao;
	@Autowired
	private ICustomerDao customerDao;
	@Override
	public List<Product> saveProduct(Product product) {
		
		 inventoryDao.save(product);
		 return inventoryDao.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return inventoryDao.findAll();
	}

	

	@Override
	public boolean deleteProducts(Integer productId) {
		
			inventoryDao.deleteById(productId);
			return true;
		
	}

	@Override
	public List<Product> updateProduct(Product product) {
		inventoryDao.save(product);
		return inventoryDao.findAll();
	}


}
