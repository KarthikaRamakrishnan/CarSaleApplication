package com.cg.cars.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.cars.beans.Order;
//import com.cg.cars.dao.IOrderRepositoryImpl;

class IOrderRepositoryImplTest {
	private IOrderRepository repository=new IOrderRepositoryImpl();
Order order=new Order();
	
	@Test
	void testaddOrder() {
		order.setOrderId(12345678);
		order.setAmount(500.00);
		order.setBillingDate(LocalDate.of(2018,10,5));
		assertEquals(order.getOrderId(),12345678);
		assertEquals(order.getAmount(),500.00);
		assertEquals(order.getBillingDate(),LocalDate.of(2018,10,5));
		
	}
	@Test
	void testRemoveOrder() { 
		order.setOrderId(12345678); 
		assertEquals(order.getOrderId(),12345678);
	}
	@Test
	void testUpdateOrder() {
			order.setOrderId(1234);
			assertEquals(order.getOrderId(),1234);
		}
	@Test
	void testgetOrderDetails() {
		order.setOrderId(12345678);
		order.setAmount(500.00);
		order.setBillingDate(LocalDate.of(2018,10,5));
		
}
}
	
