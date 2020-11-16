package com.cg.cars.beans;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARD")
public class Card {
	@Id
	@Column(name = "CARD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cardId;
	@Column
	private String cardName;
	@Column
	private String cardNumber;
	@Column
	private LocalDate cardExpiry;
	private int cvv;

	@OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
	private Set<Payment> payments = new HashSet<>();       //Initialization required to avoid NullPointerException
	
	public Card() {
		
	}

	public Card(long cardId, String cardName, String cardNumber, LocalDate cardExpiry, int cvv, Set<Payment> payments) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		this.payments = payments;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}		
	
	public Set<Payment> getPayments(){
		return payments;
	}
	
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
	//the method below will add employee to department 
		//also serves the purpose to avoid cyclic references.
		public void addPayment(Payment payment) {
			payment.setCard(this);              //this will avoid nested cascade
			this.getPayments().add(payment);
		}

}
