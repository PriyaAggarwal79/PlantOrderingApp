package com.plant.ui;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.plant.entity.Cart;
import com.plant.entity.Customer;
import com.plant.service.CartService;
import com.plant.service.CartServiceImpl;
import com.plant.service.CustomerServiceImpl;
import com.plant.service.LoginServiceImpl;

public class App {

	public static void main(String[] args) {
		

		Scanner sc=new Scanner(System.in);
		
		 String customerId;
		 String customerName;
		 String custEmailId;
		 Long custPhnNo;
		 String homeAddress;
		 String pincode;
		 String dropAddress=null;
		 String password;
		 Boolean flag;
		 String ans;
		 
		 Customer c=null;
		CustomerServiceImpl cimpl=new CustomerServiceImpl();
		 CartService cImpl=new CartServiceImpl();
		 List<Cart> clist=null;
		 Cart C=null;
		
		
		 while(true) {
		System.out.println("\n***************Welcome to Anudip Plant Ordering App******************");
		
		System.out.println("Enter Login---> if you are a existed user");
		System.out.println("Enter sign up---> if you are a new user");
		
		String choice=sc.nextLine().toLowerCase();
		Boolean logout=false;
		
		while (logout==false) {
			
			switch(choice) {
		case "sign up" :
		 System.out.println("Hello new user!!!!");
		
		 System.out.println("Enter your full name: ");
		 customerName=sc.nextLine();
						  
		 System.out.println("Enter your email-Id: ");
		 custEmailId=sc.nextLine();
						  
		 System.out.println("Enter your phone number: ");
		 custPhnNo=sc.nextLong();
		 sc.nextLine();
		 
		 System.out.println("Enter your Address: ");
		 homeAddress=sc.nextLine();
						  
		 System.out.println("Enter your area-pincode: ");
			pincode=sc.next();
			sc.nextLine();
			
		 System.out.println("Enter your new password: (there shouldn't be any blank space in password)");
		 password=sc.next();
		 sc.nextLine();
		
		 System.out.println("Re-Enter your password: ");
		 String pass=sc.next();
		 sc.nextLine();
		 
		 if(password.equals(pass))
			 System.out.println("You have successfully registered in the app!!!");
		 
		 //for producing customerId
		 String letter=custEmailId.substring(0, 4);
		 Random random=new Random();//for producing random number
		 Integer randomInt=random.nextInt(10000);
		 sc.nextLine();

		 customerId="C"+randomInt+letter;
		 
		 c=new Customer(customerId, customerName, custEmailId, custPhnNo, homeAddress, pincode, dropAddress,password);
		 
		 flag=cimpl.addCustomerDetails(c);
		 
		 if(flag) {
				System.out.println("Customer details added to database....");
				logout=true;
				}
			else {
				System.out.println("Error while adding Customer deatails...");}
			
		 break;
		
			case "login" : 
				
			Boolean log=true;
			while(log) {
			
				
				System.out.println("\nEnter your email-id: ");
				String username=sc.nextLine().trim();
				
				System.out.println("Enter password: ");
				 password=sc.nextLine();
				
				String login=new LoginUI().login(username, password);
				LoginServiceImpl l=new LoginServiceImpl();
					
				 if(login==null ) {
					System.out.println("UserName or password given is wrong. please login again");
				 
					
					System.out.println("Do you forget the password: ");
					ans=sc.nextLine();
					
					if(ans.equalsIgnoreCase("yes")) {
						System.out.println("Enter your Email-id: ");
						custEmailId=sc.nextLine();
						username=custEmailId;
						
						System.out.println("Enter customerId:");
						customerId=sc.nextLine();
						
						if(custEmailId.equals(cimpl.getDetailsByEmail(custEmailId).getCustEmailId()) &&
								customerId.equals(cimpl.getDetailsByEmail(custEmailId).getCustomerId())) {
							System.out.println("Enter the new password: ");
							password=sc.nextLine();
							
						
					flag=l.forgetCustPassword(username, customerId, password);
					
						if(flag) {
							System.out.println("New password is set!!!");
							break;
						}
						else
							System.out.println("Error....");
					}
					else if(ans.equalsIgnoreCase("no")) {
						System.out.println("Ok...Continue on login page");
					
					}
					else {
						System.out.println("Please answer in yes or no only!! Going back to login page...");
					
					}
					}
				}
				else if(login.equals("customer")) {
						
						Customer cust=new CustomerServiceImpl().getDetailsByEmail(username);
						
						System.out.println("\nWelcome to our website "+cust.getCustomerName()+"\n");
						
						Boolean custLogin=true;
						while(custLogin) {
							System.out.println("***********************Welcome to home page********************");
							System.out.println("|Enter 1---> To go to your profile page|");
							System.out.println("|Enter 2---> To go to your cart page   |");
							System.out.println("|Enter 3---> To go to your order page   |");
							System.out.println("|Enter 4---> To go to search page      |");
							System.out.println("|Enter 5---> Logout                    |");
							
							Integer choice1= sc.nextInt();
							sc.nextLine();
							
							switch(choice1) {
							
							case 1:
								
								new Customer1().profile();
								
								break;
								
							case 2:
								
								customerId=cust.getCustomerId();
								new Cart1().cart(customerId);
								
								break;
								
							case 3:
								customerId=cust.getCustomerId();
								clist=cImpl.showMyCart(customerId);
								
								new OrderUI().orderMenu(customerId, clist);
								break;
								
							case 4:
								new Plant1().custplant();
								
								break;
								
							case 5:
								custLogin=false;
								log=false;
								logout=true;
								System.out.println("********************Thank you for using our services**************");
								System.out.println("*************************Visit again soon***********************\n");
								break;
								
								default: System.out.println("Please enter the correct option!!!!");
							
							}
						}
				

				}
				 
				else if(login.equals("admin")) {
					System.out.println("You have logged in as admin\n");
					
					
					while(logout==false) {
					System.out.println("Enter the number as given in option...");
					System.out.println("Enter 1---> Show plant page");
					System.out.println("Enter 2---> Show cart page");
					System.out.println("Enter 3---> Show order page");
					System.out.println("Enter 4---> Logout     \n ");
					
					Integer option=sc.nextInt();
					sc.nextLine();
					
					switch(option) {
					
					case 1:
						new Plant1().plant();
						
						break;
						
					case 2:
						new Cart1().cartAdmin();
						
						break;
						
					case 3:
						
						new OrderUI().showOrders();
						
						break;
						
					case 4:
						log=false;
						logout=true;
						System.out.println("********************Thank you for using our services**************");
						System.out.println("*************************Visit again soon*************************");
						break;
						
						default:System.out.println("Please enter the correct given choice...");
					}
				}	
			}
			}
				 
			break;
	
	default:
		System.out.println("Please choose correct option!!!");
		logout=true;
			}
			
		}
		
	}

	
	}
}
