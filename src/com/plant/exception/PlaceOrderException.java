package com.plant.exception;

public class PlaceOrderException extends Exception{

	public PlaceOrderException() {
		
		System.out.println("There should be an item in cart to place order!!!");
		
	}
	
	public String getMessage() {
		
		return "No item in the cart list";
		
	}
	
	public String toString() {
		
		return "com.plant.exception.PlaceOrderException: Zero item is in the cart !!! ";
		
	}
}
