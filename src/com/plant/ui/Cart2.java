package com.plant.ui;

import java.util.List;
import java.util.Scanner;

import com.plant.entity.Cart;
import com.plant.entity.Plant;
import com.plant.service.CartService;
import com.plant.service.CartServiceImpl;

public class Cart2 {

	String cartId;
	 String plantId;
	 String customerId;//customerId
	 Integer quantity;//the no. of Plant item added to cart
	 Double subTotal;//price * quantity
	 Double price;//Plant price
	 Plant p;
	 Integer option;
	 Boolean flag;
	 String ans;
	 
	 Scanner sc=new Scanner(System.in);
	 Cart c=null;
	 CartService cImpl=new CartServiceImpl();
	 List<Cart> clist=null;
	public void cart(){
		
	Scanner sc=new Scanner(System.in);
		boolean logout=false;
			while(logout==false) {
				System.out.println("*************Cart page******************");
				System.out.println("_______________________________________ ");
				System.out.println("\nEnter the number as given in option...");
				System.out.println("Enter 1--> Show all cart items          ");
				System.out.println("Enter 2---> Show cart by id             ");
				System.out.println("Enter 3---> Go back to home page        ");
				System.out.println("Enter 4---> Logout                      ");
			int option;
			option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:
				
				clist=cImpl.showAllCart();
				if(clist!=null && clist.isEmpty()!=true) {
					
					for(Cart cart: clist)		
					{
						System.out.println("Cart id: "+cart.getCartId());
						System.out.println("Customer id: "+cart.getCustomerId());
						System.out.println("Item added: "+cart.getP().getPlantName());
						System.out.println("Price of single item: "+cart.getPrice());
						System.out.println("Quantity in cart: "+cart.getQuantity());
						System.out.println("SubTotal: "+cart.getSubTotal());
						
						System.out.println("_______________________________");
					}
					
				}
				else
					System.out.println("The cart is empty. No data available at this moment!!!");
				
				break;
				
			case 2:
				
				System.out.println("Enter the cart id: ");
				cartId=sc.nextLine();
				
				 c=cImpl.getCartById(cartId);
				if(c!=null) {
					
					System.out.println("Cart id: "+c.getCartId());
					System.out.println("Customer id: "+c.getCustomerId());
					System.out.println("Item added: "+c.getP().getPlantName());
					System.out.println("Price of single item: "+c.getPrice());
					System.out.println("Quantity in cart: "+c.getQuantity());
					System.out.println("SubTotal: "+c.getSubTotal());
					
				}
				else
					System.out.println("No cart with this id found...");
				
				break;
				
			case 3:
				System.out.println("______Going back to home page______");
				return;
				
			case 4:
				
				logout = true;
				System.out.println("Thank you for using our services. Visit again soon!!!");
				
				break;
				
			default:System.out.println("Please enter the valid option!!!");
				
			}//switch ends

		}	
	}
}
