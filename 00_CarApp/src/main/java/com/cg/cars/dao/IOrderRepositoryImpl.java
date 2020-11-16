package com.cg.cars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.cars.beans.Order;
import com.cg.cars.exception.OrderIdNotFoundException;
import com.cg.cars.exception.InvalidOrderException;

public class IOrderRepositoryImpl implements IOrderRepository {
	
	private EntityManager entityManager;
	public IOrderRepositoryImpl() {
		entityManager =JPAUtil.getEntityManager();
	}
	
	@Override
	public Order addOrder(Order order) {
		
		entityManager.persist(order);
		return order;
	}
	
	@Override
	public Order removeOrder(long id) throws OrderIdNotFoundException{
		Order order1=entityManager.find(Order.class, id);
		
		if(order1==null) {
			throw new OrderIdNotFoundException("Order Id not found");
		}
		entityManager.remove(order1);
		return order1;
	}

	@Override
	public Order updateOrder(long id, Order order) throws InvalidOrderException
	{
		Order order1=entityManager.find(Order.class, id);
		if(order1==null)
			throw new InvalidOrderException("Order not found");
		order=entityManager.merge(order);
		return order;
	}

	@Override
	public Order getOrderDetails(long id)throws OrderIdNotFoundException {
		Order order=null;
		Query query=entityManager.createQuery("Select order from Order order where order.orderId=id",Order.class);
		
		order=(Order) query.getSingleResult();
		return order;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> appointmentlist=entityManager.createQuery("Select order From Order order",Order.class).getResultList();
		return appointmentlist;
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





