package com.cg.cars.dao;
/** The IPaymentRepositoryImpl class provides methods to add, remove, update, view payment details by payment_id and to get all payment lists
 * 
 **@author Jayasree's
 **
 */
import java.util.List;
import javax.persistence.EntityManager;
import com.cg.cars.beans.Payment;


public class IPaymentRepositoryImpl implements IPaymentRepository {	

	EntityManager em;
	
	public IPaymentRepositoryImpl() {
	 em = JPAUtil.getEntityManager();
	}

	/** This method add payments
	 * 
	 * @param Payment entity details   
	 * 
	 */
	@Override
	public Payment addPayment(Payment payment) {
		em.persist(payment);
		return payment;
	}

	/** This methods remove payments
	 * 
	 * @param paymentId - Payment entity details   
	 * 
	 */
	@Override
	public Payment removePayment(long id) {
		Payment payment = em.find(Payment.class, id);
		em.remove(payment);
		return payment;
	}

	/** This methods update payments
	 * 
	 * @param paymentId - Payment entity details   
	 * 
	 */
	@Override
	public Payment updatePayment(long id, Payment payment) {
		em.find(Payment.class, id);
		em.merge(payment);
		return payment;
	}

	/** This methods return payment details 
	 * 
	 * @param paymentId - Payment entity details   
	 * 
	 */
	@Override
	public Payment getPaymentDetails(long id) {
		Payment payment = em.find(Payment.class, id);
		return payment;
	}

	/*
	 * This methods returns list of payments by Payment entity details
	 */
	  	  
	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> paymentList = em.createQuery("select from Payment payment", Payment.class).getResultList();
		for (Payment payment : paymentList) {
			System.out.println("Payment Id : " + payment.getPaymentId());
			System.out.println("Payment Type : " + payment.getType());
			System.out.println("Payment Status : " + payment.getStatus());
			System.out.println("Payment Card : " + payment.getCard());
		}
		return paymentList;
	}

	@Override
	public void beginTransaction() {
		em.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		em.getTransaction().commit();
	}
}
