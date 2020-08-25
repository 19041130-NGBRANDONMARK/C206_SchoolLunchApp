import java.util.ArrayList;
import java.util.regex.Pattern;







public class orderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for student ID search
		String ID_PATTERN = "1[89][0-9]{6}";
		
		
		
		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
		menuList.add(new MenuItem(1,"Set Meal","Fish And Chips",false,3.50));
		menuList.add(new MenuItem(2,"Set Meal","Fish Soup", true,3.50));
		menuList.add(new MenuItem(3,"Set Meal","Nasi Briyani",false,3.20));
		menuList.add(new MenuItem(4,"Fruits & Drinks","Watermelon",true,0.80));
		menuList.add(new MenuItem(5,"Fruits & Drinks","Apple",true,0.60));
		menuList.add(new MenuItem(6,"Fruits & Drinks","Fruit Cup",true,1.50));
		
		
		ArrayList<Order> OrderList = new ArrayList<Order>();
		OrderList.add(new Order(1,"18001940","04/05/2020","Set Meal"));
		OrderList.add(new Order(2,"19004130","01/07/2020","Fruit & Drinks"));
		OrderList.add(new Order(3,"19041039","04/07/2020","Set Meal"));
		OrderList.add(new Order(4,"19001234","07/08/2020","Fruits & Drinks"));
		OrderList.add(new Order(5,"P2000593","21/06/2020","Fruits & Drinks"));
		
		int option = 0;
		
		while (option != 5) {
			
			menu();
			option = Helper.readInt("Enter option > ");
	
			
// new order
			if (option == 1) {

				System.out.println("1. Student");
				System.out.println("2. Parent");
				int accType = Helper.readInt("Enter option to select Account Type : ");
			
				if (accType ==1) {
					orderMain.viewAllMenu(menuList);
					Helper.line(40, "=");
					System.out.println("You will have a limited order of $15.00");
					Helper.line(40, "=");
					//input code here
					
					double total = 0;
					int orders = Helper.readInt("How many sets? ");
					int mid = Helper.readInt("Enter Menu ID to select order: ");
					
					for(MenuItem Mi : menuList) {
						if (mid == Mi.getmenuId()) {
								total = Mi.getPrice();
								double Sum = total * orders;
								while (Sum > 15.00) {				
									
									System.out.println("Your total cost is over the limit of $15! " +"Your total order is : $" +Sum);
									orders = Helper.readInt("How many sets? ");
									mid = Helper.readInt("Enter Menu ID: ");
									total = Mi.getPrice();
									Sum = total * orders;
								}
								String totalCost = String.format("Your total cost is: $%.2f",Sum);
								System.out.println(totalCost); 
								orderMain.viewAllOrder(OrderList);
								
								Helper.line(40, "=");
								System.out.println("ENTER NEW ORDER");
								Order or = inputOrder();
								orderMain.addOrder(OrderList, or);
							
						};
					}
					
				}
				else if(accType == 2) {
				
					orderMain.viewAllMenu(menuList);
				
					//input code here
					
					double total = 0;
					int orders = Helper.readInt("How many sets? ");
					int mid = Helper.readInt("Enter Menu ID to select order: ");
					
					for(MenuItem Mi : menuList) {
								total = Mi.getPrice();
								double Sum = total * orders;
								
									
									total = Mi.getPrice();
									Sum = total * orders;
								
								String totalCost = String.format("Your total cost is: $%.2f",Sum);
								System.out.println(totalCost); 
								orderMain.viewAllOrder(OrderList);
								
								Helper.line(40, "=");
								System.out.println("ENTER NEW ORDER");
								Order or = inputOrder();
								orderMain.addOrder(OrderList, or);
							
						};
					}
					
				}

//update
			else if (option == 2) {
				Helper.line(40, "=");
				System.out.println("Order Menu");
				Helper.line(40, "=");
				orderMain.viewAllOrder(OrderList);
				
				
				boolean updatedDate1 = false;
			
				
				int id = Helper.readInt("Enter Order ID: ");
				
				for (Order od : OrderList) {
					if(od.getOrderId() == id) {
						String updateDate = Helper.readString("Enter new date");
						od.setOrderDate(updateDate);
						updatedDate1 = true;
						System.out.println("New date has been updated!");
						break;
					}
					
			}
				if(updatedDate1 == false) {
					System.out.println("Invalid Order ID!");
					
				
					
//display menu				
				 }
				}else if  (option == 3) {
					Helper.line(40, "-");
					String ot = String.format("%-25s %-25s %-35s %-35s %-15s\n" ,"Menu ID","Category","Menu Name","Healthy Choice?","Price");
					for (MenuItem Mi : menuList) {
						ot += String.format("%-25s%-25s %-35s  %-35b %-15.2f  \n",Mi.getmenuId(),Mi.getCategory(),Mi.getName(),Mi.getHealthyChoice(),Mi.getPrice());
					}
					
					System.out.print(ot);
	//id Search
				} else if (option == 4) {
					
					String idSearch = Helper.readStringRegEx("Enter Student ID:  ", ID_PATTERN);
					//String idSearch = Helper.readString("Enter student ID to search:  ");
					boolean isFound = false;
					String ot = String.format("%-15s %-25s %-30s %-15s \n" , "Order ID","Student ID / Parent ID","Order Date: ","Order Name: ");
					for (Order od : OrderList) {
						
						 if (od.getStudentId().contains(idSearch)) {
						ot += String.format("%-25s %-25s %-30s %-15s \n", od.getOrderId(),od.getStudentId(), od.getOrderDate(), od.getorderName());
						
						}
						isFound = true;
					}
				
					if (isFound = true) {
						System.out.println(ot);
					} else { 
						System.out.println("This Student ID does not existt!");
					}
								
						} else if (option == 5) {
					System.out.println("Thank you for using School Lunch Box Online ");
				} else { 
					System.out.println("Invalid option!");
			}
		
		}
		
	}
		
		private static void menu() {
			Helper.line(50, "=");
			System.out.println("Welcome To School Lunch Box Online ");
			Helper.line(50, "=");
			System.out.println("1. Add New Order");
			System.out.println("2. Update Order");
			System.out.println("3. View Menu");
			System.out.println("4. Search orders by Student ID");
			System.out.println("5. Quit");
			
		}
		
		
		
		public static Order inputOrder() {
			int orderID = Helper.readInt("Enter New Order ID : ");
			String studentId = Helper.readString("Enter Student ID / Parent ID : ");
			String orderDate = Helper.readString("Enter Order Date(DD/MM/YYYY : ");
			String orderName = Helper.readString("Enter Order Name : (Set Meal / Fruits & Drinks)");

			Order or= new Order(orderID,studentId, orderDate, orderName);
			return or;
			
		}
		
		
		public static void addMenu(ArrayList<MenuItem> menuList,MenuItem mL) {
			menuList.add(mL);
			System.out.println("Menu added!");
		}
		
		public static void addOrder(ArrayList<Order> OrderList, Order or) {
			
			OrderList.add(or);
			System.out.println("Order added!");
		}
		
		
		public static String retrieveAllOrder(ArrayList<Order> orderList) {
			String output = "";

			for (int i = 0; i < orderList.size(); i++) {

				output += String.format("%-25s %-25s %-30s %-15s \n", orderList.get(i).getOrderId(),orderList.get(i).getStudentId(), orderList.get(i).getOrderDate(), orderList.get(i).getorderName());
			}
			return output;
		}
		public static void viewAllOrder(ArrayList<Order> orderList) {
			
			String output = String.format("%-15s %-25s %-30s %-15s \n" , "Order ID","Student ID / Parent ID","Order Date: ","Order Name: ");
			 output += retrieveAllOrder(orderList);	
			System.out.println(output);
		}
		
		
		
		public static String retrieveAllMenu(ArrayList<MenuItem> menuList) {
			String output = "";

			for (int i = 0; i < menuList.size(); i++) {

				output += String.format("%-25s %-25s %-25s  %-25b %-15.2f  \n", menuList.get(i).getmenuId(),menuList.get(i).getCategory(), menuList.get(i).getName(), menuList.get(i).getHealthyChoice(), menuList.get(i).getPrice());
			}
			return output;
		}
		public static void viewAllMenu(ArrayList<MenuItem> menuList) {
			
			String output = String.format("%-15s %-25s %-25s %-30s %-15s \n" , "Menu ID: ","Category: ","Name: ","Healthy Choice?","Price :");
			 output += retrieveAllMenu(menuList);	
			System.out.println(output);
		}
		
	}