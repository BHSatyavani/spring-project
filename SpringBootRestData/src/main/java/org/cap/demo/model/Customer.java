package org.cap.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Customer {
	@Id
	private int customerId;
	private String customerName;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= CascadeType.DETACH)
	@JoinTable(name="products_customers",
	joinColumns= {@JoinColumn(name="customerId")},
	inverseJoinColumns= {@JoinColumn(name="productId")})
	
	//@JsonBackReference
	@JsonIgnoreProperties("customers")
	private List<Product> products;
	public Customer() {
		super();
	}
	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	

	public Customer(int customerId, String customerName,  List<Product> products) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.products = products;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}
	
	

}
