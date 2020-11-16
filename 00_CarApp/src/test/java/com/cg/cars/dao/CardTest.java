package com.cg.cars.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.cars.beans.Card;

class CardTest {

	Card card;

	@BeforeEach
	void setUp() throws Exception {
		card = new Card();
	}

	@AfterEach
	void tearDown() throws Exception {
		card = null;
	}

	@Test
	void testGetCardId() {
		card.setCardId(123);
		assertEquals(card.getCardId(), 123);
	}

	@Test
	void testGetCardName() {
		card.setCardName("Anshu");
		assertEquals(card.getCardName(), "Anshu");
	}

	@Test
	void testGetCardNumber() {
		card.setCardNumber("1234 5678 9874");
		assertEquals(card.getCardNumber(), "1234 5678 9874");
	}

	@Test
	void testGetCardExpiry() {
		card.setCardExpiry(LocalDate.of(2025, 07, 14));
		assertEquals(card.getCardExpiry(), LocalDate.of(2025, 07, 14));
	}

	@Test
	void testGetCvv() {
		card.setCvv(147);
		assertEquals(card.getCvv(), 147);
	}

}
