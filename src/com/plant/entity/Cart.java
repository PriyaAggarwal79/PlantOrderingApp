package com.plant.entity;

public class Cart {

	private String cartId;
	private String plantId;
	private String customerId;
	private Integer quantity;
	private Double subTotal;
	private Double price;
	private Plant p;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String cartId, String plantId, String customerId, Integer quantity, Double subTotal, Double price) {
		super();
		this.cartId = cartId;
		this.plantId = plantId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", plantId=" + plantId + ", customerId=" + customerId + ", quantity="
				+ quantity + ", subTotal=" + subTotal + ", price=" + price + ", p=" + p + "]";
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Plant getP() {
		return p;
	}

	public void setP(Plant p) {
		this.p = p;
	}
	
	
	
}
