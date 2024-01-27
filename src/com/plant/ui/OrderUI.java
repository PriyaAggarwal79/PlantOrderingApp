package com.plant.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.plant.entity.Cart;
import com.plant.entity.Customer;
import com.plant.entity.Order;
import com.plant.exception.PlaceOrderException;
import com.plant.service.CustomerServiceImpl;
import com.plant.service.OrderServiceImpl;

public class OrderUI {

	private String orderId;
	private LocalDate orderDate;
	private String dropAddress;
	private LocalDateTime expectedDelivery;
	private String customerId;
	private Double billingAmount;
	private String status;
	Boolean flag;
	String ans;
	
	Order o=null;
	OrderServiceImpl oimpl=new OrderServiceImpl();
	List<Order> olist=null;
	Cart c=null;
	Scanner sc=new Scanner(System.in);
	
	public void orderMenu(String customerId, List<Cart> clist) {
		
		Customer cust=new CustomerServiceImpl().getDetailsById(customerId);
		System.out.println("Welcome to the Order page "+cust.getCustomerName()+" !!!");
		
		int option;
		
		Double grandTotal=0.0;
		if(clist!=null && clist.isEmpty()!=true) {
		for(Cart cart: clist)		
				{
				System.out.println("Cart id: "+cart.getCartId());
				System.out.println("Item added: "+cart.getP().getPlantName());
				System.out.println("Price of single item: "+cart.getPrice());
				System.out.println("Quantity in cart: "+cart.getQuantity());
				System.out.println("SubTotal: "+cart.getSubTotal());
				
				grandTotal+=cart.getSubTotal();
				System.out.println("_______________________________");
				}
			System.out.println("Grand total= "+grandTotal);	
		}
		else {
			
			System.out.println("Your cart is empty and so you will not be able to place order.");
			System.out.println("Do you want to continue with the order menu??");
			
			ans=sc.nextLine();
			if(ans.equals("no")) {
				return;
			}
			else if(ans.equals("yes")) {
				System.out.println("Thankyou for input. Please do not place order.\nYou can check other options");
			}
			else {
				System.out.println("Please enter yes or no only.....Returning to main menu");
			}
		}
		
		while(true) {
			
			System.out.println("\nEnter 1---> Place Order");
			System.out.println("Enter 2---> Cancel my Order");
			System.out.println("Enter 3---> Show my Order history");
			System.out.println("Enter 4---> Show order by id");
			System.out.println("Enter 5---> Go Back to the main menu ");
			
			option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:
				if(clist!=null && clist.isEmpty()!=true) {
				
				 Random random=new Random();//for producing random number
				 Integer randomInt=random.nextInt(10000);
				 sc.nextLine();
				 
				 orderId="OR"+randomInt;
				 
				 orderDate=LocalDate.now();
				 
				 System.out.println("Do you want to deliver at the below given address??");
				 System.out.println(cust.getHomeAddress());
				 System.out.println("\n Answer in yes or no");
				 
				 ans=sc.nextLine();
				 
				 if(ans.equalsIgnoreCase("yes")) {
					
					 dropAddress=cust.getHomeAddress();
					 
					}
					else if(ans.equalsIgnoreCase("no")) {
						
						System.out.println("Enter your Drop location: ");
						dropAddress=sc.nextLine();
					
					}	
					else
						System.out.println("Please answer in yes or no only!! Going back to main menu...");
				 
				 	expectedDelivery=LocalDateTime.now().plusDays(3);
				 	
				 	billingAmount=grandTotal;
				 	
				 	status="Processing...";
				 	
				 	o=new Order(orderId, orderDate, dropAddress, expectedDelivery, customerId, billingAmount, status);
				 	
				 	Order order=oimpl.placeOrder(o);
				 	if(order!=null) {
				 		System.out.println("Your order has been placed. Details given below....");
				 		System.out.println("Order number: "+order.getOrderId());
				 		System.out.println("Drop Location: "+order.getDropAddress());
				 		
				 		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy  HH:mm");
				 		LocalDateTime delivery=order.getExpectedDelivery();
				 		
				 		System.out.println("Delivered by: "+delivery.format(pattern));
				 		System.out.println("Billing amount: "+order.getBillingAmount());
				 		
				 		return;
				 		
				 	}
				 	else
				 		System.out.println("Error while placing order...");
				}
			
			else {
				try {
					
					throw new PlaceOrderException();
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
				break;
				
			case 2:
				
				System.out.println("Enter the order id to be cancelled: ");
				orderId=sc.nextLine();
				
				flag=oimpl.cancelOrder(orderId);
				
				if(flag) {
					System.out.println("Your order has been cancelled!!!");
				}
				else {
					System.out.println("Error while cancelling your order. Try again later....");
				}
				
				break;
				
			case 3:
				
				olist=oimpl.showMyOrderHistory(customerId);
				if(olist!=null && olist.isEmpty()!=true) {
					
					for(Order o1:olist) {
						
						System.out.println("\nYour order has been placed. Details given below....");
				 		System.out.println("Order number: "+o1.getOrderId());
				 		System.out.println("Drop Location: "+o1.getDropAddress());
				 		
				 		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy  HH:mm");
				 		LocalDateTime delivery=o1.getExpectedDelivery();
				 		
				 		System.out.println("Delivered by: "+delivery.format(pattern));
				 		System.out.println("Billing amount: "+o1.getBillingAmount());
				 		System.out.println("Status: "+o1.getStatus());
				 		
				 		System.out.println("_______________________________________________");
				 		
					}
					
				}
				
				break;
				
			case 4:
				
				System.out.println("Enter the order id: ");
				orderId=sc.nextLine();
				o=oimpl.showOrderById(orderId);
				if(o!=null) {
					
					System.out.println("\nYour order has been placed. Details given below....");
			 		System.out.println("Order number: "+o.getOrderId());
			 		System.out.println("Drop Location: "+o.getDropAddress());
			 		
			 		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy  HH:mm");
			 		LocalDateTime delivery=o.getExpectedDelivery();
			 		
			 		System.out.println("Delivered by: "+delivery.format(pattern));
			 		System.out.println("Billing amount: "+o.getBillingAmount());
			 		System.out.println("Status: "+o.getStatus());	
					
				}
				else {
					System.out.println("No order found with this id.");
				}
				
				break;
				
			case 5:
				System.out.println("\nGoing back to main menu.....");
				return;
				
				
			default:System.out.println("Please enter the correct option!!!");
			
			
			}
					
		}
	}
	
	public void showOrders() {
		System.out.println("Update status of an order: ");
		
		System.out.println("Enter the order id: ");
		orderId=sc.nextLine();
		
		o=oimpl.showOrderById(orderId);
		 System.out.println("Do you want to change the status of this order: \n");
		 System.out.println(o);
		 System.out.println("\n Answer in yes or no");
		 
		 ans=sc.nextLine();
		 
		 if(ans.equalsIgnoreCase("yes")) {
			
			System.out.println("Enter the status of Ordered item: ");
			status=sc.nextLine();
			
			flag=oimpl.updateOrderStatus(status, orderId);
			if(flag)
				System.out.println("Status updated successfully!!!");
			else
				System.out.println("Error while updating the status!!!");
			
			 
			}
			else if(ans.equalsIgnoreCase("no")) {
				System.out.println("Thank you for your response!!!");
			
			}	
			else
				System.out.println("Please answer in yes or no only!! Going back to main menu...");
		 
	}
}
