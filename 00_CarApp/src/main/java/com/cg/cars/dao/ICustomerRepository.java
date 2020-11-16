package com.cg.cars.dao;

import java.util.List;

import com.cg.cars.beans.Customer;
import com.cg.cars.exception.CustomerLocationInvalid;
import com.cg.cars.exception.CustomerNotFoundException;
import com.cg.cars.exception.InvalidCustomerException;

public interface ICustomerRepository {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(long custId) throws InvalidCustomerException;
	public Customer updateCustomer(long custId, Customer customer) throws InvalidCustomerException;
	public Customer getCustomer(long custId) throws CustomerNotFoundException;
	public List<Customer> getAllCustomers(); 
	public List<Customer> getCustomersByLocation() throws CustomerLocationInvalid;
	public void beginTransaction();
	public void commitTransaction();
}
