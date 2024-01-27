package com.plant.service;

import java.util.List;

import com.plant.entity.Cart;

public interface CartService {

	public boolean addToCart(Cart c);
	public boolean updateQuantity(String cartId, Integer quantity);
	public boolean deleteFoodItemCart(String cartId);
	public boolean clearMyCart(String customerId);
	
	public List<Cart> showMyCart(String customerId);
	public List<Cart> showAllCart();
	public Cart getCartById(String cartId);
	public boolean checkPlantItem(String customerId, String plantId);
	
	
}
