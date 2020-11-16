package com.cg.cars.dao;


import java.util.List;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.cars.beans.Customer;
import com.cg.cars.exception.CustomerLocationInvalid;
import com.cg.cars.exception.CustomerNotFoundException;
import com.cg.cars.exception.InvalidCustomerException;

public class ICustomerRepositoryImp implements ICustomerRepository {
	private EntityManager entityManager;

	public ICustomerRepositoryImp() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(long custId) throws InvalidCustomerException {
		Customer cus = null;
		cus = entityManager.find(Customer.class, custId);
		if(cus==null)
		{
			throw new InvalidCustomerException("Customer Id not found");
			
		}
		entityManager.remove(cus);
		return cus;

	}

	@Override
	public Customer updateCustomer(long custId, Customer customer)throws InvalidCustomerException {
		Customer cus1 = entityManager.find(Customer.class, custId);
		if(cus1==null)
		{
			throw new InvalidCustomerException("Invalid Customer ID");
		}
		customer=entityManager.merge(cus1);
		return customer;
	}

	@Override
	public Customer getCustomer(long custId) throws CustomerNotFoundException{
		Customer cus = null;
		cus = entityManager.find(Customer.class, custId);
		if(cus==null)
		{
			throw new CustomerNotFoundException("Customer not Found");
		}
		return cus;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String c1 = " Select c from  customer c";
		TypedQuery<Customer> q = entityManager.createQuery(c1, Customer.class);
		List<Customer> all = q.getResultList();
		return all;

	}

	@Override
	public List<Customer> getCustomersByLocation() throws CustomerLocationInvalid {
		TypedQuery<Customer> q1= entityManager.createQuery("select c from customer c where c.city=salem",Customer.class);
		List<Customer> cusLoc = q1.getResultList();
		if(cusLoc==null)
		{
			throw new CustomerLocationInvalid("Location of customer is Invalid");
		
		}
		return cusLoc;

	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();

	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();

	}

}
