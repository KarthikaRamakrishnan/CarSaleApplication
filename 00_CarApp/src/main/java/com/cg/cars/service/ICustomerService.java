package com.cg.cars.service;

import java.util.List;

import com.cg.cars.beans.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(long custId);
	public Customer updateCustomer(long custId, Customer customer);
	public Customer getCustomer(long custId);
	public List<Customer> getAllCustomers(); 
	public List<Customer> getCustomersByLocation();
}
