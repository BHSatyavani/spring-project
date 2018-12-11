package org.cap.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jdk.jfr.Label;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","created","updated","createdBy","lastUpdatedBy"})

public class Product {
	@Id
	
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	private Date expiryDate;

	@ManyToMany(fetch=FetchType.LAZY,
			cascade=CascadeType.PERSIST,mappedBy="products") 


	/*@JoinTable(name="products_customers",
	joinColumns= {@JoinColumn(name="productId")},
	inverseJoinColumns= {@JoinColumn(name="customerId")})*/
	//@JsonManagedReference
	@JsonIgnoreProperties("products")
	private List<Customer> customers;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int quantity, double price, Date expiryDate,
		 List<Customer> customers) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.expiryDate = expiryDate;
		this.customers = customers;
	}





	public Product(int productId, String productName, int quantity, double price, Date expiryDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.expiryDate = expiryDate;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Date getExpiryDate() {
		return expiryDate;
	}



	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	public List<Customer> getCustomers() {
		return customers;
	}



	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", expiryDate=" + expiryDate + ", customers=" + customers + "]";
	}
	




}
