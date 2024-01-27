package com.plant.service;

import java.util.List;

import com.plant.entity.Order;

public interface OrderService {

	public Order placeOrder(Order o);
	public boolean cancelOrder(String orderId);
	public boolean updateOrderStatus(String status, String orderId);
	
	public List<Order> showMyOrderHistory(String customerId);
	public Order showOrderById(String orderId);
	
}
