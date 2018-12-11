package org.cap.demo.controller;

import java.util.List;

import org.cap.demo.model.Product;
import org.cap.demo.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InventoryController {
	@Autowired
	private IInventoryService inventoryService;
	@PostMapping("/products")
	public ResponseEntity<List<Product>> saveProduct(@RequestBody Product product){
		
		List<Product> products= inventoryService.saveProduct(product);
		if(products.isEmpty())
		{
			return new ResponseEntity("Sorry! Products  are not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
	}
	
	@GetMapping("/products")
	private ResponseEntity<List<Product>> getProducts(){
		List<Product> products=inventoryService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<List<Product>> deleteProduct(
			@PathVariable("productId")Integer productId){
		boolean products= inventoryService.deleteProducts(productId);
		if(products==true)
			return new ResponseEntity("deleted", 
					HttpStatus.OK);
		
		
		return new ResponseEntity("products not available", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/product")
	private ResponseEntity<List<Product>> updateProduct(@RequestBody Product product){
		List<Product> products=inventoryService.updateProduct(product);
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}  
	
	

}
