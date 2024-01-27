package com.plant.ui;

import java.util.Scanner;

import com.plant.entity.Customer;
import com.plant.service.CustomerServiceImpl;

public class Customer1 {

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
	
	public void profile() {
		

	while(true) {
		System.out.println("Welcome to your profile!!!");
		System.out.println("Enter 1----> To see your details");
		System.out.println("Enter 2----> To update your details");
		System.out.println("Enter 3----> To delete your details");
		System.out.println("Enter 4----> To change your email-id");
		System.out.println("Enter 5----> To change your password");
		System.out.println("Enter 6----> Go back to home page");
		
		Integer choice2=sc.nextInt();
		sc.nextLine();
		
		switch(choice2) {
		
		case 1:
			
			System.out.println("For viewing the details\n Please enter your Email-Id: ");
			custEmailId=sc.nextLine();
			
			c=cimpl.getDetailsByEmail(custEmailId);
			if(c!=null) {
			System.out.println(" ");
			System.out.println(c);
			}
			else
				System.out.println("No details available!!!");
			
			break;
			
		case 2:
			
			System.out.println("For updating the details\n Please enter your Customer-Id: ");
			customerId=sc.nextLine();
			
			c=cimpl.getDetailsById(customerId);
			
			if(c!=null) {
				System.out.println(c);
				
				System.out.println("Are you sure you want to update your details??"
						                  +"\nAnswer in yes or no");
				
				String answer=sc.next();
				sc.nextLine();
				
				if(answer.equalsIgnoreCase("yes")) {
					
					System.out.println("What do you want to update?");
					System.out.println("Enter a----> update name  \nEnter b----> update phone-No. "
							   +" \nEnter c----> update country \nEnter d----> update state"
							   + "\nEnter e----> update address  \nEnter f---->update pincode ");
					
					char choice3=sc.next().toLowerCase().charAt(0);
					sc.nextLine();
					
					switch(choice3) {
					
					case 'a':
						
						System.out.println("\nEnter the name: ");
						customerName=sc.nextLine();
						
						c.setCustomerName(customerName);
						
						flag=cimpl.updateCustomerDetails(c);
						if(flag) 
							System.out.println("Name is updated successfully!!!");
						else
							System.out.println("Error while updating the name...");
						
						break;
						
					case 'b':
						
						System.out.println("Enter the new phone-no.: ");
						custPhnNo=sc.nextLong();
						
						c.setCustPhnNo(custPhnNo);
						
						flag=cimpl.updateCustomerDetails(c);
						if(flag) 
							System.out.println("Phone-no. is updated successfully!!!");
						else
							System.out.println("Error while updating the phone Number...");
						
						break;
						
					
					case 'e':
						
						System.out.println("Enter the new address: ");
						homeAddress=sc.nextLine();
						
						c.setHomeAddress(homeAddress);
						
						flag=cimpl.updateCustomerDetails(c);
						if(flag) 
							System.out.println("address is updated successfully!!!");
						else
							System.out.println("Error while updating the address...");
						
						break;
						
					case 'f':
						
						System.out.println("Enter the pincode: ");
						pincode=sc.nextLine();
						
						c.setPincode(pincode);
						
						flag=cimpl.updateCustomerDetails(c);
						if(flag) 
							System.out.println("pincode is updated successfully!!!");
						else
							System.out.println("Error while updating the pincode...");
						
						break;
						
					default:System.out.println("Choose correct options!!!");
					
					
					}
					
				}	
				else if(answer.equalsIgnoreCase("No")) {
					System.out.println("Thank you for your response!!!");
				}
				else
					System.out.println("Please give answer in yes or no!!!");
				
			}
			else
				System.out.println("No id found with this customer id...");
			
			break;
			
		case 3:
			
			System.out.println("Are you sure ? you want to delete your id from the website... \nAnswer in yes or no: ");
			ans=sc.nextLine();
			
			if(ans.equalsIgnoreCase("yes")) {
				System.out.println("Enter your customer id: ");
				customerId=sc.nextLine();
				
				flag=cimpl.deleteCustomerDetails(customerId);
				if(flag) 
					System.out.println("Your Id is deleted...");
				else
					System.out.println("Error while deleting the id...");
				
			}
			else if(ans.equalsIgnoreCase("No")) {
				System.out.println("Thank you for your response!!!");
			}
			else
				System.out.println("Please give answer in yes or no!!!");
			
			
			break;
			
		case 4:

			System.out.println("Are you sure ? you want to change the Email-id \nAnswer in yes or no: ");
			ans=sc.nextLine();
			
			if(ans.equalsIgnoreCase("yes")) {
				System.out.println("Enter your customer id: ");
				customerId=sc.nextLine();
				
				System.out.println("Enter your password: ");
				password=sc.nextLine();
				
				if(customerId.equals(cimpl.getDetailsById(customerId).getCustomerId()) && password.equals(cimpl.getDetailsById(customerId).getPassword())) 
					{
					System.out.println("Enter the new email-Id: ");
					custEmailId=sc.nextLine();
					
					c.setCustEmailId(custEmailId);
					flag=cimpl.updateCustomerDetails(c);
					if(flag)
						System.out.println("Email-Id is changed....");
					else
						System.out.println("Error in changing the Email-Id...");
				
				}
				else
					System.out.println("Details are wrong...");
			
			}
			else if(ans.equalsIgnoreCase("No")) {
				System.out.println("Thank you for your response!!!");
			}
			else
				System.out.println("Please give answer in yes or no!!!");
			
			
			break;
			
		case 5:
			System.out.println("Are you sure ? you want to change the password \nAnswer in yes or no: ");
			ans=sc.nextLine();
			
			if(ans.equalsIgnoreCase("yes")) {
				System.out.println("Enter your email-id: ");
				custEmailId=sc.nextLine();
				
				System.out.println("Enter your old password: ");
				password=sc.nextLine();
				
				if(custEmailId.equals(cimpl.getDetailsByEmail(custEmailId).getCustEmailId()) &&
						customerId.equals(cimpl.getDetailsByEmail(custEmailId).getPassword())) {
					System.out.println("Enter the new password: ");
					password=sc.nextLine();
					
					c.setPassword(password);
					flag=cimpl.updateCustomerDetails(c);
					if(flag)
						System.out.println("Password is changed....");
					else
						System.out.println("Error in changing the password...");
				
				}
				else
					System.out.println("Email-Id or customerId is wrong...");
			
			}
			else if(ans.equalsIgnoreCase("No")) {
				System.out.println("Thank you for your response!!!");
			}
			else
				System.out.println("Please give answer in yes or no!!!");
			
			break;
			
		case 6:
			System.out.println("Going back to home page!!!");
			return;
			
		default: System.out.println("Please enter the correct choice!!!!");
		
		}
		}
	}
}
