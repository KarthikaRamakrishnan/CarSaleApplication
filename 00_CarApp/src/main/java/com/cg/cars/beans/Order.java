package com.cg.cars.beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ORDER")

public class Order implements Serializable{
	private static final long serialVersionUID = -8900835335325445335L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private long orderId;
	@Column(name="amount")
	private double amount;
	@Column(name="billingDate")
	private LocalDate billingDate;
	@Column(name="Customer")
	@ManyToOne(cascade = CascadeType.ALL)

	private Customer customer;
	public Order() {
		super();
	}
	
	public Order(long orderId, double amount, LocalDate billingDate, Customer customer) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + "]";
	}

	
	}

