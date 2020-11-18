package com.cg.cars.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.cg.cars.beans.Address;
import com.cg.cars.beans.Customer;
import com.cg.cars.exception.CustomerLocationInvalid;
import com.cg.cars.exception.InvalidCustomerException;

class ICustomerServiceImpTest {
	ICustomerServiceImp cusService=new ICustomerServiceImp();

	Customer cus = new Customer();

	@BeforeEach
	public void setUp() throws Exception {
		cusService = new ICustomerServiceImp();
	}

	@AfterEach
	public void tearDown() throws Exception {
		cusService = null;
	}

	@Test
	@Order(1)
	public void testAddCcustomer() {
		cus.setcustId(101);
		cus.setName("lavanya");
		cus.setContactNo("8523697412");
		cus.setEmail("lavanyavimalan@gmail.com");
		cus.setDob(LocalDate.of(1997, 04, 23));
		Address obj = new Address("111", "muthusamy street", "shevapet", "salem", "TamilNadu", 636002);
		cus.setAddress(obj);
		Customer result1=cusService.addCustomer(cus);
		assertEquals(result1.hashCode(),cus.hashCode());
		assertEquals(cus.getName(), "lavanya");
		
		
	}
	@Order(2)

	@Test
	public void testRemoveCustomer() {
		cus.setcustId(102);
		assertEquals(cus.getcustId(), 102);

	}
	@Order(3)
	@Test
	public void testUpdateCustomerException() throws InvalidCustomerException{
		cus.setcustId(101);
		cus.setName("lava");
		cus.setContactNo("8523697412");
		cus.setEmail("lavanyavimalan1@gmail.com");
		cus.setDob(LocalDate.of(1998, 05, 24));
		Address obj = new Address("91/64", "muthusamy street", "shevapet", "salem", "TamilNadu", 636002);
		cus.setAddress(obj);
		assertThrows(InvalidCustomerException.class,()->cusService.updateCustomer(101, cus),"Cannot update this customer");
		
	}
	@Order(4)
	@Test
	public void testGetCustomer() {
		cus.setcustId(102);
		assertEquals(cus.getcustId(), 102);

	}
	@Order(5)
	@Test
	public void testGetAllCustomers() {
		List<Customer> list = cusService.getAllCustomers();
		assertNotNull(list);
	}
	@Order(6)
	  @Test 
	  public void getCustomersByLocation() throws CustomerLocationInvalid {
		
		  Customer c=new Customer();
		  Address ad=new Address();
		 c.setcustId(1111);
		  ad.setDoorNo("111");
		  ad.setArea("sivapet");
		  ad.setCity("salem");
		  ad.setStreet("sivapet");
		  ad.setState("TamilNadu");
		  ad.setPincode(636002);
		 long str=c.getcustId();
			 assertNotNull(str);
				 
			 
	
	  }
	 
	 
	@Test
	public void testRemoveCustomerException() throws InvalidCustomerException {
		assertThrows(InvalidCustomerException.class, ()->cusService.removeCustomer(101),"Customer Id not found");
		

	}

}

