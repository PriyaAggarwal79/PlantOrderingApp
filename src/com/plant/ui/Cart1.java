package com.plant.ui;

import java.util.List;
import java.util.Scanner;

import com.plant.entity.Cart;
import com.plant.entity.Plant;
import com.plant.service.CartService;
import com.plant.service.CartServiceImpl;
import com.plant.service.PlantServiceImpl;

public class Cart1 {

	private String cartId;
	 String plantId;
	 String customerId;//customerId
	 Integer quantity;//the no. of Plant item added to cart
	 Double subTotal;//price * quantity
	 Double price;//Plant price
	 Plant p;
	 Integer option;
	 Boolean flag;
	 String ans;
	 String password;
	 
	 Scanner sc=new Scanner(System.in);
	 Cart c=null;
	 CartService cimpl=new CartServiceImpl();
	 List<Cart> clist=null;
	 
	public void cart(String username) {
		
		boolean logout=false;
		
		while(logout==false) {
			System.out.println("\n**************Cart page****************");
			System.out.println("\nEnter the number as given in options..........");
			System.out.println("   Enter 1---> Add to cart                      ");
			System.out.println("   Enter 2---> Show my cart                     ");
			System.out.println("   Enter 3---> Update quantity of Plant item    ");
			System.out.println("   Enter 4---> Delete Plant item from cart      ");
			System.out.println("   Enter 5---> Clear my cart                    ");
			System.out.println("   Enter 6---> See order menu                   ");
			System.out.println("   Enter 7---> Go back to home page             ");
			System.out.println("   Enter 8---> Logout                           ");
			
			option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:
				
				int min=100;
				int max=1000;
				int b=(int)(Math.random()*(max-min+1)+min);
				
				cartId="CA"+b+"RT";
				
				List<Plant> plist=new PlantServiceImpl().showAllPlant();
				System.out.println("Plantname and Plantid shown below...");
				for(Plant p1: plist) {
					
					System.out.println(p1.getPlantName()+"  ---> "+p1.getPlantId()+" , "+p1.getPlantCategory()+" , "+p1.getSeason()+" , "+p1.getPrice());
					
				}
				System.out.println("\nEnter the Plantid: ");
				plantId=sc.nextLine();
				
				System.out.println("Enter the customer id: ");
				customerId=sc.nextLine();
				
				flag=cimpl.checkPlantItem(customerId, plantId);
				
				if(flag) {
					System.out.println("Item was already present in your cart."
							+ "\n Quantity has been increased by 1");
				}
				else {
				
				quantity=1;
				price=new PlantServiceImpl().getPlantById(plantId).getPrice();
				
				subTotal=quantity*price;
				
				c=new Cart(cartId, plantId, customerId, quantity, subTotal, price);
				
				flag=cimpl.addToCart(c);
				if(flag)
					System.out.println("Plantitem added to cart successfully!!!!");
				else
					System.err.println("Error while adding Plantitem to cart!!!");
				
				}
				
				break;
				
			case 2:
				
				customerId=username;
				clist=cimpl.showMyCart(customerId);
				
				if(clist!=null && clist.isEmpty()!=true) {
					System.out.println("**********Your cart details***********");
					
					Double grandTotal=0.0;
					
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
						
						System.out.println("Do you want to go to order page? \n Answer in yes or no...");
						ans=sc.nextLine();
						
						if(ans.equalsIgnoreCase("yes")) {
							
							new OrderUI().orderMenu(customerId, clist);
						}
						else if(ans.equalsIgnoreCase("no"))
							System.out.println("Thank you for your response...\nContinue browsing.....");
						else
							System.out.println("Please answer in yes or no only!! Going back to main menu...");
				}
				else
					System.out.println("Your cart is empty. Please add to cart first....");
				
				break;
				
			case 3:
				
				System.out.println("Enter the cart id: ");
				cartId=sc.nextLine();
				
				c=cimpl.getCartById(cartId);
				if(c!=null) {
					
					System.out.println("Cart id: "+c.getCartId());
					System.out.println("Item added: "+c.getP().getPlantName());
					System.out.println("Price of single item: "+c.getPrice());
					System.out.println("Quantity in cart: "+c.getQuantity());
					System.out.println("SubTotal: "+c.getSubTotal());
					
					System.out.println("\nEnter new quantity: ");
					quantity=sc.nextInt();
					sc.nextLine();
					
					if(quantity>0) {
						flag=cimpl.updateQuantity(cartId, quantity);
						if(flag)
							System.out.println("Quantity updated successfully!!!");
						else
							System.out.println("Error while changing quantity!!!");
					}
					else
						System.out.println("Please give a number greater than 0 for quantity...");
				}
				
				break;
				
			case 4:
				
				System.out.println("Enter cartId of item to be deleted: ");
				cartId=sc.nextLine();
				
				System.out.println("Are you sure you want to delete this item?"
						+ "\nAnswer in yes or no: ");
				ans=sc.nextLine();
				
				if(ans.equalsIgnoreCase("yes")) {
					
					flag=cimpl.deleteFoodItemCart(cartId);
					if(flag)
						System.out.println("Item deleted from cart successfully!!!");
					else
						System.out.println("Error while deleting item!!!");
					
				}
				else if(ans.equalsIgnoreCase("no")){
					System.out.println("Thank you for input. please continue browsing....");
				}
				else
					System.out.println("Answer in yes or no only. Going back to main menu...");
				
				
				break;
				
			case 5:
				
				customerId=username;
				
				System.out.println("Are you sure you want to clear your cart?"
						+ "\nAnswer in yes or no: ");
				ans=sc.nextLine();
				
				if(ans.equalsIgnoreCase("yes")) {
					
					flag=cimpl.clearMyCart(customerId);
					if(flag)
						System.out.println("Your cart is now empty!!!");
					else
						System.out.println("Error while clearing cart!!!");
					
				}
				else if(ans.equalsIgnoreCase("no")){
					System.out.println("Thank you for input. please continue browsing....");
				}
				else
					System.out.println("Answer in yes or no only. Going back to main menu...");
				
				break;
				
			case 6:
				
				customerId=username;
				clist=cimpl.showMyCart(customerId);
				
				new OrderUI().orderMenu(customerId, clist);
				
				break;
				
			case 7:
				System.out.println("Going back to home page");
				return;
				
			case 8:
				
				logout=true;
				System.out.println("Thank you for using our services. Visit again soon!!!");
				
				break;
				
				default: System.out.println("Please give inputs as per the options given...");
			
			}
		}
	}
	
	public void cartAdmin(){
		
			boolean logout=false;
				while(logout==false) {
					System.out.println("*************Cart page******************");
					System.out.println("_______________________________________ ");
					System.out.println("\nEnter the number as given in option...");
					System.out.println("Enter 1--> Show all cart items          ");
					System.out.println("Enter 2---> Show cart by id             ");
					System.out.println("Enter 3---> Go back to home page        ");
					System.out.println("Enter 4---> Logout                      ");
					
				option=sc.nextInt();
				sc.nextLine();
				
				switch(option) {
				
				case 1:
					
					clist=cimpl.showAllCart();
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
					
					 c=cimpl.getCartById(cartId);
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