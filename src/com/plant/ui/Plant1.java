package com.plant.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.plant.entity.Plant;
import com.plant.service.PlantServiceImpl;

public class Plant1 {

	 String plantId;
	 String plantName;
	 String plantType;
	 String plantCategory;
	 String season;
	 Double price;
	 Integer quantityInStock;
	 Boolean flag;
	 
	 Plant p=null;
	 PlantServiceImpl pImpl=new PlantServiceImpl();
	 List<Plant> plist=null;
	 
	 Scanner sc=new Scanner(System.in);
	 
	 public void plant() {
		 
		 System.out.println("********************Welcome in Plant Page****************************");
		 while(true) {
			 
			 System.out.println("\n Please Enter the number as given in menu");
			 System.out.println("Enter 1---> To Add Item in Plant");
			 System.out.println("Enter 2---> To Update Item in Plant");
			 System.out.println("Enter 3---> To Delete Item in Plant");
			 System.out.println("Enter 4---> To Show all the Item ");
			 System.out.println("Enter 5---> Search the item on the basis on Type");
			 System.out.println("Enter 6---> Search the item on the basis on Category");
			 System.out.println("Enter 7---> Search the item on the basis on Season");
			 System.out.println("Enter 8---> Go back to home page");
			 
			 Integer choice=sc.nextInt();
			 sc.nextLine();
			 
			 switch(choice) {
			 
			 case 1:
				 
				 Random random=new Random();//for producing random number
				 Integer randomInt=random.nextInt(10000);
				 plantId="PL"+randomInt;//plantId
				 
				 System.out.println("Enter the name of the plant: ");//plantName
				 plantName=sc.nextLine();
				 System.out.println();
				 
				 System.out.println("Enter the type of the plant: ");//type or size of plant
				 System.out.println("Enter the one of the given options:\n \n1: Small sized houseplant "
				 		+ "\n2: Medium sized houseplant \n3: Large sized houseplant \n4:Basket plants \n5: Trailing and climbing plants");
				 String t=sc.nextLine();
				 
				 if(t.equalsIgnoreCase("small sized houseplant") || t.equals("1")) {
						
						plantType="small sized houseplant";
				
					}
					else if(t.equalsIgnoreCase("medium sized houseplant") || t.equals("2")) {
						
						plantType="medium sized houseplant";
						
					}
					else if(t.equalsIgnoreCase("large sized houseplant")|| t.equals("3")){
						
						plantType="large sized houseplant";
						
					}
					else if(t.equalsIgnoreCase("Basket plants") || t.equals("4")){
						
						plantType="Basket plants";
						
					}
					else if(t.equalsIgnoreCase("Trailing and climbing plants") || t.equals("5")){
						
						plantType="Trailing and climbing plants";
						
					}
					else {
						
						System.out.println("Please enter as per the given type");
						plantType="data unavailable";
					}
				 
				 System.out.println("\nEnter the category of plant");//category of plant
				 System.out.println("\n1. Flowering houseplants \n2. Perennials houseplants \n3.Colorful Foliage houseplants"
				 		+ "\n4.Air purifying plants \n5.Shrubs and bushes \n6.Herbs \n7.Creepers and Climbers \n8.Succulents & Cacti "
				 		+ "\n9.Fruits & Vegetables \n10.Tree Type Plants");
					Integer choice2=sc.nextInt();
					sc.nextLine();
					
					switch(choice2) {
					
					case 1: plantCategory="Flowering houseplants";
					break;
					
					case 2: plantCategory="Perennials houseplants";
					break;
					
					case 3: plantCategory="Colorful Foliage houseplants";
					break;
					
					case 4: plantCategory="Air purifying plants";
					break;
					
					case 5: plantCategory="Shrubs and bushes";
					break;
					
					case 6: plantCategory="Herbs";
					break;
					
					case 7: plantCategory="Creepers and Climbers";
					break;
					
					case 8: plantCategory="Succulents & Cacti";
					break;
					
					case 9: plantCategory="Fruits & Vegetables";
					break;
					
					case 10: plantCategory="Tree Type Plants";
					break;
					
					default: System.out.println("Please enter only those numbers as given in"
					                                +"category menu");
								plantCategory="data unavailable";
					}
					
					System.out.println("\nEnter the season of plants: ");
					season=sc.nextLine();
					
					System.out.println("\nEnter the price of plant: ");
					price=sc.nextDouble();
					sc.nextLine();
					
					System.out.println("\nEnter the quantity of item in stock: ");
					quantityInStock=sc.nextInt();
					sc.nextLine();
					
					p=new Plant(plantId, plantName, plantType, plantCategory, season, price, quantityInStock);
					
					flag=pImpl.addPlant(p);
					if(flag)
						System.out.println("Details are added to database!!!");
					else
						System.out.println("Error in adding!!!");
				 
				 break;
				 
			 case 2:
				 
				 System.out.println("Enter the id of the food you want to update: ");
					plantId=sc.nextLine();
					
					p=pImpl.getPlantById(plantId);
					
					if(p!=null) {
						System.out.println(p);
						
						System.out.println("Are you sure you want to update this food item??"
								                  +"\nAnswer in yes or no");
						
						String ans=sc.next();
						sc.nextLine();
						
						if(ans.equalsIgnoreCase("yes")) {
							
							System.out.println("What do you want to update?");
							System.out.println("Enter a----> update name \nEnter b----> update type \nEnter c----> update category "
									   +"\nEnter d----> update season \nEnter e----> update price \nEnter f----> update quantity");
									    
						
							Character ch=sc.next().toLowerCase().charAt(0);
							sc.nextLine();
							
							switch(ch) {
							
							case 'a':
								System.out.println("Enter the new name: ");
								plantName=sc.nextLine();
								
								p.setPlantName(plantName);
								
								flag=pImpl.updatePlant(p);
								if(flag)
									System.out.println("Name is updated successfully");
								else
									System.out.println("Error while updating the name...");
								
								break;
							
							case 'b':
								System.out.println("Enter the type: ");
								
								System.out.println("Enter the one of the given options:\n \n1: Small sized houseplant "
								 		+ "\n2: Medium sized houseplant \n3: Large sized houseplant \n4:Basket plants \n5: Trailing and climbing plants");
								 String t1=sc.nextLine();
								 
								 if(t1.equalsIgnoreCase("small sized houseplant") || t1.equals("1")) {
										
										plantType="small sized houseplant";
								
									}
									else if(t1.equalsIgnoreCase("medium sized houseplant") || t1.equals("2")) {
										
										plantType="medium sized houseplant";
										
									}
									else if(t1.equalsIgnoreCase("large sized houseplant")|| t1.equals("3")){
										
										plantType="large sized houseplant";
										
									}
									else if(t1.equalsIgnoreCase("Basket plants") || t1.equals("4")){
										
										plantType="Basket plants";
										
									}
									else if(t1.equalsIgnoreCase("Trailing and climbing plants") || t1.equals("5")){
										
										plantType="Trailing and climbing plants";
										
									}
									else {
										
										System.out.println("Please enter as per the given type");
										plantType="data unavailable";
									}
								
								p.setPlantType(plantType);
								
								flag=pImpl.updatePlant(p);
								if(flag)
									System.out.println("Type is updated successfully");
								else
									System.out.println("Error while updating the Type...");
								
								break;
								
							case 'c':
								System.out.println("Enter the category: ");
								
								System.out.println("\n1. Flowering houseplants \n2. Perennials houseplants \n3.Colorful Foliage houseplants"
								 		+ "\n4.Air purifying plants \n5.Shrubs and bushes \n6.Herbs \n7.Creepers and Climbers \n8.Succulents & Cacti "
								 		+ "\n9.Fruits & Vegetables \n10.Tree Type Plants");
									Integer choice3=sc.nextInt();
									sc.nextLine();
									
									switch(choice3) {
									
									case 1: plantCategory="Flowering houseplants";
									break;
									
									case 2: plantCategory="Perennials houseplants";
									break;
									
									case 3: plantCategory="Colorful Foliage houseplants";
									break;
									
									case 4: plantCategory="Air purifying plants";
									break;
									
									case 5: plantCategory="Shrubs and bushes";
									break;
									
									case 6: plantCategory="Herbs";
									break;
									
									case 7: plantCategory="Creepers and Climbers";
									break;
									
									case 8: plantCategory="Succulents & Cacti";
									break;
									
									case 9: plantCategory="Fruits & Vegetables";
									break;
									
									case 10: plantCategory="Tree Type Plants";
									break;
									
									default: System.out.println("Please enter only those numbers as given in"
									                                +"category menu");
												plantCategory="data unavailable";
									}
								
								p.setPlantCategory(plantCategory);
								
								flag=pImpl.updatePlant(p);
								if(flag)
									System.out.println("Category is updated successfully");
								else
									System.out.println("Error while updating the category...");
								
								break;
								
							case 'd':
								System.out.println("Enter the season: ");
								season=sc.nextLine();
								
								p.setSeason(season);
								
								flag=pImpl.updatePlant(p);
								if(flag)
									System.out.println("Season is updated successfully");
								else
									System.out.println("Error while updating the season...");
								
								break;
								
							case 'e':
								System.out.println("Enter the price:");
								price=sc.nextDouble();
								
								p.setPrice(price);
								
								flag=pImpl.updatePlant(p);
								if(flag)
									System.out.println("Price is updated successfully");
								else
									System.out.println("Error while updating the price...");
								
								break;
								
								
							case 'f':
								System.out.println("Enter quantity in stock: ");
								quantityInStock=sc.nextInt();
								
								p.setQuantityInStock(quantityInStock);
								
								flag=pImpl.updatePlant(p);
								if(flag)
									System.out.println("Quantity is updated successfully");
								else
									System.out.println("Error while updating the quantity...");
								
								break;
								
							default:System.out.println("Please choose the given options...");
							}
							
						}
						else if (ans.equalsIgnoreCase("no")) {
							System.out.println("Thank you for your response!!! Continue browsing.....");
						}
						else
							System.out.println("Please answer in yes or no only. Going back to main menu");
						
					}
					else
						System.out.println("No plant item with this id found.\n Please check the id given...");
					
					
						
				 break;
				 
			 case 3:
				 System.out.println("Enter the plant id to be deleted: ");
				 plantId=sc.nextLine();
				 
				 p=pImpl.getPlantById(plantId);
				 
				 if(p!=null) {
						System.out.println("*****Plant Details*****");
						System.out.println(p);
						
						System.out.println("Are you sure you want to delete this plant item??"
				                  +"\nAnswer in yes or no");
		
							String ans=sc.next();
							sc.nextLine();
							
							if(ans.equalsIgnoreCase("yes")) {
								flag=pImpl.deletePlant(plantId);
								
								if(flag)
									System.out.println("Plant is deleted is successfully!!!");
								
								else
									System.out.println("Error while deleting the plant....");
								
							}
							
							else if(ans.equalsIgnoreCase("No"))
								System.out.println("Thank you continue browsing...");
							
							
						 	else 
								System.out.println("Please answer in yes or no only!!Going back to main menu");
							}
											
							else {
									System.out.println("No plant item with this id found!!!");
					}
				 
				 break;
				 
			 case 4:
				 plist=pImpl.showAllPlant();
				 
				 if(plist!=null && plist.isEmpty()!=true) {
					 
					 Iterator<Plant> it=plist.iterator();
					 while(it.hasNext()) {
						 System.out.println(it.next());
						 System.out.println("__________________________________________");
					 }
				 }
				 else
					 System.out.println("No data available at this moment!!!");
				 
				 break;
				 
			 case 5:
				 System.out.println("Enter the plant type to be searched: ");
				 System.out.println("Enter the one of the given options:\n \n1: Small sized houseplant "
					 		+ "\n2: Medium sized houseplant \n3: Large sized houseplant \n4:Basket plants \n5: Trailing and climbing plants");
					 String t1=sc.nextLine();
					 
					 if(t1.equalsIgnoreCase("small sized houseplant") || t1.equals("1")) {
							
							plantType="small sized houseplant";
					
						}
						else if(t1.equalsIgnoreCase("medium sized houseplant") || t1.equals("2")) {
							
							plantType="medium sized houseplant";
							
						}
						else if(t1.equalsIgnoreCase("large sized houseplant")|| t1.equals("3")){
							
							plantType="large sized houseplant";
							
						}
						else if(t1.equalsIgnoreCase("Basket plants") || t1.equals("4")){
							
							plantType="Basket plants";
							
						}
						else if(t1.equalsIgnoreCase("Trailing and climbing plants") || t1.equals("5")){
							
							plantType="Trailing and climbing plants";
							
						}
						else {
							
							System.out.println("Please enter as per the given type");
							plantType="data unavailable";
						}
					
					 plist=pImpl.getPlantByType(plantType);
					 
					 if(plist!=null && plist.isEmpty()!=true) {
						 
						 Iterator<Plant> it=plist.iterator();
						 while(it.hasNext()) {
							 System.out.println(it.next());
							 System.out.println("__________________________________________");
						 }
					 }
					 else
						 System.out.println("No data available at this moment!!!");
					 
				 break;
				 
			 case 6:
				 System.out.println("Enter the category to be searched: ");
					
					System.out.println("\n1. Flowering houseplants \n2. Perennials houseplants \n3.Colorful Foliage houseplants"
					 		+ "\n4.Air purifying plants \n5.Shrubs and bushes \n6.Herbs \n7.Creepers and Climbers \n8.Succulents & Cacti "
					 		+ "\n9.Fruits & Vegetables \n10.Tree Type Plants");
						Integer choice3=sc.nextInt();
						sc.nextLine();
						
						switch(choice3) {
						
						case 1: plantCategory="Flowering houseplants";
						break;
						
						case 2: plantCategory="Perennials houseplants";
						break;
						
						case 3: plantCategory="Colorful Foliage houseplants";
						break;
						
						case 4: plantCategory="Air purifying plants";
						break;
						
						case 5: plantCategory="Shrubs and bushes";
						break;
						
						case 6: plantCategory="Herbs";
						break;
						
						case 7: plantCategory="Creepers and Climbers";
						break;
						
						case 8: plantCategory="Succulents & Cacti";
						break;
						
						case 9: plantCategory="Fruits & Vegetables";
						break;
						
						case 10: plantCategory="Tree Type Plants";
						break;
						
						default: System.out.println("Please enter only those numbers as given in"
						                                +"category menu");
									plantCategory="data unavailable";
						}
						
						plist=pImpl.getPlantByCategory(plantCategory);
				 
				 if(plist!=null && plist.isEmpty()!=true) {
					 
					 Iterator<Plant> it=plist.iterator();
					 while(it.hasNext()) {
						 System.out.println(it.next());
						 System.out.println("__________________________________________");
					 }
				 }
				 else
					 System.out.println("No data available at this moment!!!");
				 
				 break;
				 
			 case 7:
				 System.out.println("Enter the seasonal plants to be searched:");
				 season=sc.nextLine();
				 
				 plist=pImpl.getPlantBySeason(season);
				 
				 if(plist!=null && plist.isEmpty()!=true) {
					 
					 Iterator<Plant> it=plist.iterator();
					 while(it.hasNext()) {
						 System.out.println(it.next());
						 System.out.println("__________________________________________");
					 }
				 }
				 else
					 System.out.println("No data available at this moment!!!");
				 
				 break;
				 
			 case 8:
				 System.out.println("**************************Going back to home page***************************");
				 return;
			 
				default: System.out.println("Please enter the right option from the list...");
			 }
			 
		 }
		
	 }
	 
	 public void custplant() {
		 
		 System.out.println("****************Search page********************"); 
		 System.out.println("Enter 1---> To Show all the Item ");
		 System.out.println("Enter 2---> Search the item on the basis on Type");
		 System.out.println("Enter 3---> Search the item on the basis on Category");
		 System.out.println("Enter 4---> Search the item on the basis on Season");
		 System.out.println("Enter 5---> Go back to home page");
		 
		 Integer choice=sc.nextInt();
		 sc.nextLine();
		 
		 switch(choice) {
		 
	 case 1:
		 plist=pImpl.showAllPlant();
		 
		 if(plist!=null && plist.isEmpty()!=true) {
			 
			 Iterator<Plant> it=plist.iterator();
			 while(it.hasNext()) {
				 System.out.println(it.next());
				 System.out.println("__________________________________________");
			 }
		 }
		 else
			 System.out.println("No data available at this moment!!!");
		 
		 break;
		 
	 case 2:
		 System.out.println("Enter the plant type to be searched: ");
		 System.out.println("Enter the one of the given options:\n \n1: Small sized houseplant "
			 		+ "\n2: Medium sized houseplant \n3: Large sized houseplant \n4:Basket plants \n5: Trailing and climbing plants");
			 String t1=sc.nextLine();
			 
			 if(t1.equalsIgnoreCase("small sized houseplant") || t1.equals("1")) {
					
					plantType="small sized houseplant";
			
				}
				else if(t1.equalsIgnoreCase("medium sized houseplant") || t1.equals("2")) {
					
					plantType="medium sized houseplant";
					
				}
				else if(t1.equalsIgnoreCase("large sized houseplant")|| t1.equals("3")){
					
					plantType="large sized houseplant";
					
				}
				else if(t1.equalsIgnoreCase("Basket plants") || t1.equals("4")){
					
					plantType="Basket plants";
					
				}
				else if(t1.equalsIgnoreCase("Trailing and climbing plants") || t1.equals("5")){
					
					plantType="Trailing and climbing plants";
					
				}
				else {
					
					System.out.println("Please enter as per the given type");
					plantType="data unavailable";
				}
			
			 plist=pImpl.getPlantByType(plantType);
			 
			 if(plist!=null && plist.isEmpty()!=true) {
				 
				 Iterator<Plant> it=plist.iterator();
				 while(it.hasNext()) {
					 System.out.println(it.next());
					 System.out.println("__________________________________________");
				 }
			 }
			 else
				 System.out.println("No data available at this moment!!!");
			 
		 break;
		 
	 case 3:
		 System.out.println("Enter the category to be searched: ");
			
			System.out.println("\n1. Flowering houseplants \n2. Perennials houseplants \n3.Colorful Foliage houseplants"
			 		+ "\n4.Air purifying plants \n5.Shrubs and bushes \n6.Herbs \n7.Creepers and Climbers \n8.Succulents & Cacti "
			 		+ "\n9.Fruits & Vegetables \n10.Tree Type Plants");
				Integer choice3=sc.nextInt();
				sc.nextLine();
				
				switch(choice3) {
				
				case 1: plantCategory="Flowering houseplants";
				break;
				
				case 2: plantCategory="Perennials houseplants";
				break;
				
				case 3: plantCategory="Colorful Foliage houseplants";
				break;
				
				case 4: plantCategory="Air purifying plants";
				break;
				
				case 5: plantCategory="Shrubs and bushes";
				break;
				
				case 6: plantCategory="Herbs";
				break;
				
				case 7: plantCategory="Creepers and Climbers";
				break;
				
				case 8: plantCategory="Succulents & Cacti";
				break;
				
				case 9: plantCategory="Fruits & Vegetables";
				break;
				
				case 10: plantCategory="Tree Type Plants";
				break;
				
				default: System.out.println("Please enter only those numbers as given in"
				                                +"category menu");
							plantCategory="data unavailable";
				}
				
				plist=pImpl.getPlantByCategory(plantCategory);
		 
		 if(plist!=null && plist.isEmpty()!=true) {
			 
			 Iterator<Plant> it=plist.iterator();
			 while(it.hasNext()) {
				 System.out.println(it.next());
				 System.out.println("__________________________________________");
			 }
		 }
		 else
			 System.out.println("No data available at this moment!!!");
		 
		 break;
		 
	 case 4:
		 System.out.println("Enter the seasonal plants to be searched:");
		 season=sc.nextLine();
		 
		 plist=pImpl.getPlantBySeason(season);
		 
		 if(plist!=null && plist.isEmpty()!=true) {
			 
			 Iterator<Plant> it=plist.iterator();
			 while(it.hasNext()) {
				 System.out.println(it.next());
				 System.out.println("__________________________________________");
			 }
		 }
		 else
			 System.out.println("No data available at this moment!!!");
		 
		 break;
		 
	 case 5:
		 System.out.println("**************************Going back to home page***************************");
		 return;
	 
		default: System.out.println("Please enter the right option from the list...");
	 }
	 
	 }
}
