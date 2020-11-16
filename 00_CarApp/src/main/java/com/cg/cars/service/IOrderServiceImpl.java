package com.cg.cars.service;

import java.util.List;

import com.cg.cars.beans.Order;
import com.cg.cars.dao.IOrderRepository;
import com.cg.cars.dao.IOrderRepositoryImpl;
import com.cg.cars.exception.InvalidOrderException;
import com.cg.cars.exception.OrderIdNotFoundException;

public class IOrderServiceImpl implements IOrderService{
	private IOrderRepository dao;
	public IOrderServiceImpl() {
		dao =new IOrderRepositoryImpl();
	}
	@Override
	public Order addOrder(Order order) {
		 dao.beginTransaction();
	     order=dao.addOrder(order);
	     dao.commitTransaction();
	     return order;
		
		
	}

	@Override
	public Order removeOrder(long id) {
		 dao.beginTransaction();
    	 Order order=null;
	     try {
			order=dao.removeOrder(id);
		} catch (OrderIdNotFoundException e) {
			e.getMessage();
		}
	     dao.commitTransaction();
	     return order;
		
		
	}

	@Override
	public Order updateOrder(long id, Order order) {
		 dao.beginTransaction();
	     try {
			order=dao.updateOrder(id,order);
		} catch (InvalidOrderException e) {
			e.printStackTrace();
		}
	     dao.commitTransaction();
	     return order;
		
		
	}

	@Override
	public Order getOrderDetails(long id) {
		 dao.beginTransaction();
		Order order = null;
		try {
			order = dao.getOrderDetails(id);
		} catch (OrderIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     dao.commitTransaction();
    	 return order;
		
	}

	@Override
	public List<Order> getAllOrders() {
		dao.beginTransaction();
		List<Order> appointmentList=dao.getAllOrders();
		dao.commitTransaction();
		return appointmentList;
	}


}
