package com.cg.cars.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.cars.beans.Card;
import com.cg.cars.beans.Payment;

class PaymentTest {
	Payment payment;
	@BeforeEach
	void setUp() throws Exception{
		payment = new Payment();
	}
	
	@AfterEach
	void tearDown() throws Exception{
		payment = null;
	}
	
	@Test
	void testGetPaymentId() {
		payment.setPaymentId(101);
		assertEquals(payment.getPaymentId(), 101);
	}	 

	@Test
	void testGetType() {
		payment.setType("Card");
		assertEquals(payment.getType(), "Card");
	}

	@Test
	void testGetStatus() {
		payment.setStatus("Pending");
		assertEquals(payment.getStatus(), "Pending");
	}

	@Test
	void testGetCard() {
		Card card = new Card();
		payment.setCard(card);
		assertEquals(payment.getCard(), card);
		
	}	
}
