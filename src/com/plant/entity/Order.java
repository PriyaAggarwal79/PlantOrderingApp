package com.plant.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {

	private String orderId;
	private LocalDate orderDate;
	private String dropAddress;
	private LocalDateTime expectedDelivery;
	private String customerId;
	private Double billingAmount;
	private String status;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderId, LocalDate orderDate, String dropAddress, LocalDateTime expectedDelivery,
			String customerId, Double billingAmount, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dropAddress = dropAddress;
		this.expectedDelivery = expectedDelivery;
		this.customerId = customerId;
		this.billingAmount = billingAmount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", dropAddress=" + dropAddress
				+ ", expectedDelivery=" + expectedDelivery + ", customerId=" + customerId + ", billingAmount="
				+ billingAmount + ", status=" + status + "]";
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}

	public LocalDateTime getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(LocalDateTime expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
