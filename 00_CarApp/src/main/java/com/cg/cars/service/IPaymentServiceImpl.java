package com.cg.cars.service;

import java.util.List;

import com.cg.cars.beans.Payment;
import com.cg.cars.dao.IPaymentRepositoryImpl;

public class IPaymentServiceImpl implements IPaymentService {

	IPaymentRepositoryImpl paymentRepository;

	public IPaymentServiceImpl() {
		paymentRepository = new IPaymentRepositoryImpl();
	}

	/** This method add payments
	 * 
	 * @param Payment entity details   
	 * 
	 */
	@Override
	public Payment addPayment(Payment payment) {
		paymentRepository.beginTransaction();
		payment = paymentRepository.addPayment(payment);
		paymentRepository.commitTransaction();

		System.out.println("Payment added successfully");
		return payment;
	}

	/** This methods remove payments
	 * 
	 * @param paymentId - Payment entity details   
	 * 
	 */
	@Override
	public Payment removePayment(long id) {

		paymentRepository.beginTransaction();
		Payment payment = null;
		try {
		payment = paymentRepository.removePayment(id);
		}catch(PaymentIdNotFoundException e) {
			e.getMessage();
		}
		paymentRepository.commitTransaction();
		return payment;
	}

	/** This methods update payments
	 * 
	 * @param paymentId - Payment entity details   
	 * 
	 */
	@Override
	public Payment updatePayment(long id, Payment payment) {

		paymentRepository.beginTransaction();
		try {
		paymentRepository.updatePayment(id, payment);
		}catch(InvalidPaymentException e) {
			e.printStackTrace();
		}
		paymentRepository.commitTransaction();
		return payment;
	}

	/** This methods return payment details 
	 * 
	 * @param paymentId - Payment entity details   
	 * 
	 */
	@Override
	public Payment getPaymentDetails(long id) {
		paymentRepository.beginTransaction();
		Payment payment = null;
		try {
		payment = paymentRepository.getPaymentDetails(id);
		}catch(PaymentIdNotFoundException e) {
			e.printStackTrace();
		}
		paymentRepository.commitTransaction();
		return payment;
	}

	/*
	 * This methods returns list of payments by Payment entity details
	 */
	@Override
	public List<Payment> getAllPaymentDetails() {
		paymentRepository.beginTransaction();
		List<Payment> paymentList = paymentRepository.getAllPaymentDetails();
		paymentRepository.commitTransaction();
		return paymentList;
	}
}
