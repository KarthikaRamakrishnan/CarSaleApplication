package com.cg.cars.service;

import java.util.List;

import com.cg.cars.beans.Customer;
import com.cg.cars.dao.ICustomerRepository;
import com.cg.cars.dao.ICustomerRepositoryImp;
import com.cg.cars.exception.CustomerLocationInvalid;
import com.cg.cars.exception.CustomerNotFoundException;
import com.cg.cars.exception.InvalidCustomerException;

public class ICustomerServiceImp implements ICustomerService{
	private ICustomerRepository rep;
	public ICustomerServiceImp()
	{
		rep=new ICustomerRepositoryImp();     
	}

	@Override
	public Customer addCustomer(Customer customer) {
		rep.beginTransaction();
		rep.addCustomer(customer);
		rep.commitTransaction();
		return customer;
	}

	@Override
	public Customer removeCustomer(long custId) {
		Customer cus=null;
		rep.beginTransaction();
		try
		{
		cus= rep.removeCustomer(custId);
		}
		catch(InvalidCustomerException e)
		{
			e.printStackTrace();
		}
		
		rep.commitTransaction();
		return cus;
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		Customer cus=null;
		try
		{
			cus= rep.updateCustomer(custId, customer);
		}
		catch(InvalidCustomerException e)
		{
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public Customer getCustomer(long custId) {
		Customer cus=null;
		try
		{
			cus=rep.getCustomer(custId);
		}
		catch(CustomerNotFoundException e)
		{
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return rep.getAllCustomers();
		
	}

	@Override
	public List<Customer> getCustomersByLocation() {
		List<Customer> cus=null;
		try
		{
		 cus=rep.getCustomersByLocation();
		}
		catch(CustomerLocationInvalid e)
		{
			e.printStackTrace();
		}
		return cus;
	}

}
