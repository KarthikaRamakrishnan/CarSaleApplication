package com.cg.cars.service;

import java.util.List;

import com.cg.cars.beans.Order;
import com.cg.cars.exception.InvalidOrderException;
import com.cg.cars.exception.OrderIdNotFoundException;

public interface IOrderService {
	public Order addOrder(Order order);
	public Order removeOrder(long id) throws OrderIdNotFoundException;
	public Order  updateOrder(long id, Order order) throws InvalidOrderException; 
	public Order  getOrderDetails(long id) throws OrderIdNotFoundException;
	public List<Order> getAllOrders(); 

}
