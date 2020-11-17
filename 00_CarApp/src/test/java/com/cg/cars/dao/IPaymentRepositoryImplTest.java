package com.cg.cars.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.cars.beans.Card;
import com.cg.cars.beans.Payment;
import com.cg.cars.exception.InvalidPaymentException;
import com.cg.cars.exception.PaymentIdNotFoundException;

class IPaymentRepositoryImplTest {

	IPaymentRepositoryImpl payservice;
	Payment payment = new Payment();
	Card card = new Card();

	@BeforeEach
	void setUp() throws Exception {
		payservice = new IPaymentRepositoryImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		payservice = null;
	}

	@Test
	void testAddPayment() {

		payment.setPaymentId(101);
		payment.setType("Card");
		payment.setStatus("Success");
		card.setCardId(123456);
		card.setCardName("Anshu");
		card.setCardNumber("4565 8653 6532");
		card.setCardExpiry(LocalDate.of(2025, 01, 14));
		card.setCvv(140);
		payment.setCard(card);

		Payment result = payservice.addPayment(payment);
		assertEquals(result.hashCode(), payment.hashCode());
	}

	@Test
	void testRemovePayment() throws PaymentIdNotFoundException {
		payment.setPaymentId(101);

		Payment result0 = payservice.removePayment(101);
		assertEquals(result0.hashCode(), payment.hashCode());
	}

	@Test
	void testUpdatePayment() throws InvalidPaymentException {
		payment.setPaymentId(102);
		payment.setStatus("Pending");

		Payment result1 = payservice.updatePayment(101, payment);
		assertEquals(result1.hashCode(), payment.hashCode());
	}

	@Test
	void testgetOrderDetails() throws PaymentIdNotFoundException {
		payment.setPaymentId(102);

		Payment result2 = payservice.getPaymentDetails(102);
		System.out.println(result2.toString());
		assertEquals(result2.hashCode(), payment.hashCode());
	}

	@Test
	void testgetAllPaymentDetails() {
		List<Payment> paymentList = payservice.getAllPaymentDetails();

		Boolean result3 = paymentList.contains(payment);
		System.out.println(paymentList);
		assertEquals(true, result3);
	}

}
