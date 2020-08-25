import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolLunchApp {

	public static void main(String[] args) {
		//  Auto-generated method stub
		SchoolLunchApp ese = new SchoolLunchApp();
		ese.start();
		
		
	}
	
				
		
		public static void addOrder(ArrayList<Order>orderArr) {
			System.out.print("Add a new order");
			String studentId = Helper.readString("Enter student ID: ");
			String orderDate = Helper.readString("Enter Order Date:");
			
			ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
			 ArrayList<MenuItem> menuSelection = new ArrayList<MenuItem>();
			 menuItem.add(new MenuItem("Fruits & Drinks", "Watermelon", true, 1.50));
			 menuItem.add(new MenuItem("Fruits & Drinks", "Apple", true, 0.50));
			 menuItem.add(new MenuItem("Set Meal", "Fishball Noodles", true, 2.50));
			 menuItem.add(new MenuItem("Set Meal", "Chicken Rice", true, 2.00));
			
			
			 Order od = new Order(studentId,orderDate,menuSelection);
			 orderArr.add(od);
			 System.out.println("Order added");
			 
		}
		
		
		
		
		
		public static void viewAllOrder(ArrayList<Order> Order) {
			String order = createOrderItemList(Order);
			
			System.out.println(order);
			
		}
		
		public static void deleteOrder(ArrayList<Order> orderArr) {
			System.out.println("Delete an Order");
			Order order1 = null;
			String studentId = Helper.readString("Student ID: ");
			String date = Helper.readString("Enter Date: ");
			for (Order o1 : orderArr) {
	            if (o1.getStudentId() == studentId && o1.getOrderDate() == date) {
	            	o1.toString();
					
					boolean Option = false;
					while(Option ==  false) {
						char option = Helper.readChar("Delete this order? ");
						
						if (option == 'Y' || option == 'y') {
							Option = true;
							orderArr.remove(order1);
							System.out.println("Order has been deleted successfully!");
						} else if (option == 'n' || option == 'N') {
							Option = true;
						} else {
							System.out.println("Invalid Option!");
						}
					}
				}
			}
		}
		public void createBill(ArrayList<Bill> billArr) {
			ArrayList<Bill> arrBill = new ArrayList<Bill>();
			System.out.println("Create a bill");
			String addPayee = Helper.readString("Enter payee name: ");
			double addTotalAmount = Helper.readDouble("Enter total amount: ");
			String addDueDate = Helper.readString("Enter due date: ");
			
			String payee = addPayee;
			double totalAmount = addTotalAmount;
			String dueDate = addDueDate;
			
			arrBill.add(new Bill(addPayee, addTotalAmount, addDueDate));
			System.out.println("Bill created");
			
			
			
			
		}
		public void deleteBill(ArrayList<Bill> billArr) {
			System.out.println("Delete a bill");
			String payee = Helper.readString("Payee name: ");
			double totalAmount = Helper.readDouble("Total amount: ");
			
			for (Bill b1 : billArr) {
				if (b1.getPayee() == payee && b1.getTotalAmount() == totalAmount) {
					b1.toString();
					
					boolean option = false;
					while(option == false) {
						
						char optionB = Helper.readChar("Delete this bill? ");
						
						if (optionB == 'Y' || optionB == 'y') {
							option = true;
							billArr.remove(payee);
							System.out.println("Bill deleted! ");
			
						}else if(optionB == 'N' || optionB =='n'){
							option = true;
							System.out.println("Bill not deleted! ");
						}else {
							System.out.println("Wrong option!");
						}
					}
				}
			}
		}
		public void viewAllBill(ArrayList<Bill> billArr) {
			
			String output = String.format("%-10s %-10s %-10s \n", "PAYEE", "TOTAL AMOUNT", "DUE DATE");
			
			for (Bill bill: billArr) {
				output += String.format("%-10s, %-10.2f, %-10s", bill.getPayee(), bill.getTotalAmount(),bill.getDueDate());
			}
		}
		
		public void createMenu(ArrayList<Menu> menu, ArrayList<MenuItem> items) {
			String disName = Helper.readString("What name do you want the monthly menu to be display as? > ");
			int month = Helper.readInt("Which month? > ");
			while (month <= 0 || month >= 13) {
				System.out.println("Invalid month");
				month = Helper.readInt("Which month? > ");
			}
			int num = Helper.readInt("Number of Item(s)? > ");
			
			String list = "----------";
			for (int i=0; i<items.size(); i++) {
				list += (i+1)+") "+items.get(i).toString()+"\n";
			}
			list += "----------";
			System.out.println(list);
			
			ArrayList<MenuItem> chosen = null;
			
			int idx = Helper.readInt("Which menu item you want to add in? *Enter the index num* > ");
			while (chosen.size() < num) {
				if ((idx-1) < items.size() && (idx-1) >= 0) {
					chosen.add(items.get(idx-1));
					idx = Helper.readInt("Which menu item you want to add in? *Enter the index num* > ");
				} else {
					System.out.println(idx+" not found");
					idx = Helper.readInt("Which menu item you want to add in? *Enter the index num* > ");
				}
			}
			
			menu.add(new Menu(disName, month, num, chosen));
			System.out.println(disName+" added");
		}
		
		public void viewAllMenu(ArrayList<Menu> menu) {
			String output = "";
			for (Menu m : menu) {
				output += m.toString()+"\n";
			}
			System.out.println(output);
		}
		
		public void deleteMenu(ArrayList<Menu> menu) {
			String list = "";
			for (int i=0; i<menu.size(); i++) {
				list += (i+1)+") "+menu.get(i).toString()+"\n";
			}
			System.out.println(list);
			
			int num = Helper.readInt("Which menu you want to delete? *Enter the index num* > ");
			if ((num-1) < menu.size() && (num-1) >= 0) {
				menu.remove(num-1);
				System.out.println(num+" deleted");
			} else {
				System.out.println(num+" not found");
			}
		}
		
		public void updateMenu(ArrayList<Menu> menu) {
			String list = "";
			for (int i=0; i<menu.size(); i++) {
				list += (i+1)+") "+menu.get(i).toString()+"\n";
			}
			System.out.println(list);
			
			int num = Helper.readInt("Which menu you want to update? *Enter the index num* > ");
			if ((num-1) < menu.size() && (num-1) >= 0) {
				String disName = Helper.readString("Enter the update name? > ");
				int month = Helper.readInt("Enter the update month? > ");
				while (month <= 0 || month >= 13) {
					System.out.println("Invalid month");
					month = Helper.readInt("Enter the update month? > ");
				} 
				menu.get(num-1).setDisplayName(disName);
				menu.get(num-1).setMonth(month);
				System.out.println(num+" updated");
			} else {
				System.out.println(num+" not found");
			}
		}
		
		public static void addMenuItem() {
			System.out.println("Adding MenuItem");
			String name = Helper.readString("What is the menu item name: " );
			String category = Helper.readString("What category is it under: ");
			boolean healthy = Helper.readBoolean("Is it Healthy ( true / false ): ");
			double price = Helper.readDouble("How much is this item: ");
			
			ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
			if(price > 0) {
				menu.add(new MenuItem(category, name , healthy , price));
				System.out.println("MenuItem added!");
			}else {
				System.out.println("Price is incorrect as it is NOT greater than 0.");
			}
			
			
			
			
		}
		
		
		public static void deleteMenuItem() {
			System.out.println("Deleting MenuItem");
			ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
			int i = 0;
			String output = String.format("%-5s %-20s %-20s %-10s %-10s" , i+1 ,"Name" , " Category" ,"Price" ," Healthier Choice?" );
		
			while( i < menu.size() ) {
				output += menu.get(i).toString();
				i++;
			}
			System.out.println(output);
			
			int index = Helper.readInt("Which item do you want to delete: ");
			
			menu.remove(index - 1);
			
			System.out.println("Menu Item deleted!");
		}
		
		
		public static void viewMenuItem() {
			System.out.println("Displaying Menu Item");
			System.out.println("1.View All Items");
			System.out.println("2.View By Category");
			ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
			String output = String.format("%-20s %-20s %-10s %-10s" , "Name" , " Category" ,"Price" ," Healthier Choice?" );
			int choice = Helper.readInt("View All Item or View Items by Category : ");
			
			if ( choice == 1) {
				int i = 0;
			while( i < menu.size() ) {
				String name = menu.get(i).getName();
				String cat = menu.get(i).getCategory();
				double price = menu.get(i).getPrice();
				boolean healthy = menu.get(i).getHealthyChoice();
				output += String.format("%-20s %-20s %-10s %-10s" , name , cat , price , healthy );
				i++;
			}
			System.out.println(output);
			
			}else {
				int i = 0;
				while( i < menu.size() ) {
					if(menu.get(i).getCategory().equalsIgnoreCase("Set Meal")) {
						output += menu.toString();
						i++;
					}
				}
				
				int o = 0;
				while ( o < menu.size()) {
					if(menu.get(o).getCategory().equalsIgnoreCase("Fruits & Drinks")) {
					output += menu.toString();
					o++;
				}
				}
				System.out.println(output);
			}
			
		}
		
		public static void updateMenuItem() {
			System.out.println("Updating Menu Item");
			ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
			String name = Helper.readString("What is the Menu Item name you want to update? ");
			String change = Helper.readString("What is the name you want to change to? ");
			double price = Helper.readDouble("What is the price you want to change to? ");
			int i = 0;
			while ( i < menu.size() ) {
				if(menu.get(i).getName().equalsIgnoreCase(name)) {
					if(price > 0) {
						menu.get(i).setName(change);
					menu.get(i).setPrice(price);
					break;
					}else {
						System.out.println("Price is incorrect as it is NOT more than 0.");
					}
					
				}
				i++;
			}
			
			System.out.println("Menu Item updated");
		}
		
		public static void searchItemByName() {
			System.out.println("Searching Item By Name");
			ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
			String name = Helper.readString("What do you want to find? ");
			int i = 0;
			
			while ( i < menu.size()) {
				if(menu.get(i).getName().equalsIgnoreCase(name)){
					System.out.println("Menu Item Name: " + menu.get(i).getName());
					System.out.println("Menu Item Price: " + menu.get(i).getPrice());
					System.out.println("Healthier Choice? " + menu.get(i).getHealthyChoice());
					System.out.println("Category: " + menu.get(i).getCategory());
				}
			}
			
			
			
		}
		
		

		public static String retrieveAllOrder(ArrayList<Order> OrderList) {
			String output = "";

			for (int i = 0; i < OrderList.size(); i++) {

				output += String.format("%-10s %-30s %-10s\n", OrderList.get(i).getStudentId());
						OrderList.get(i).getOrderDate();
						OrderList.get(i).getItems();
			}
			return output;
		}
		
		static ArrayList<Account> accountList = new ArrayList<Account>();
		
		
		private void start() {
			int option = -1;
			
			while (option !=5) {
				
				menu();
				option = Helper.readInt("Enter Choice >");
				
				if (option == 1) {
					addAccount(accountList);
					
					
				}
				else if (option == 2) {
					deleteAccount(accountList);
					
				}
				else if (option == 3) {
					viewAllAccount(accountList);
					
				}
				else if (option == 4) {
					updateAccount(accountList);
				}
				
				else {
					System.out.println("Thank you!");
					
				}
			}
		}
		private void menu() {
			Helper.line(60, "=");
			System.out.println("SCHOOL LUNCH ACCOUNT");
			Helper.line(60, "=");
			System.out.println("1) Create Account");
			System.out.println("2) Delete Account");
			System.out.println("3) View All Accounts");
			System.out.println("4) Update Account");
			System.out.println("5) Quit");
		}
			
		
		public static void addAccount(ArrayList<Account> accountList) {
			String userRole = Helper.readString("Enter your role > ");
			String contactNumber = Helper.readString("Enter your contact number > ");
			String studentId = Helper.readString("Enter your student ID > ");
			String username = Helper.readString("Enter your username > ");
			
			boolean check = true;
			
			for (Account acc : accountList) {
				if(acc.getUsername().equalsIgnoreCase(username)) {
					check = false;
					System.out.println("Error: Same username!");
					break;
				}
			}
			if (check == true) {
				Account a = new Account(userRole,contactNumber, studentId, username);
				accountList.add(a);
				System.out.println("Add Successfully!");
			}
		}
			
		
		public static void deleteAccount(ArrayList<Account> accountList) {
			
			String deleteAcc = Helper.readString("Enter the username you want delete the account > ");
			boolean check = true;
			for (Account acc : accountList) {
				if(acc.getUsername().equalsIgnoreCase(deleteAcc)) {
					check = true;
					accountList.remove(acc);
					System.out.println("Deleted Account Successfully");
					break;
					
				} else {
					System.out.println("No account with that username!");
				}
			}
		}
			
//			System.out.println("Delete an Account");
//			Account account1 = null;
//			String studentId = Helper.readString("Student ID: ");
//			String username = Helper.readString("Enter Username: ");
//			for (Account acc1 : accountList) {
//	            if (acc1.getStudentId() == studentId && acc1.getUsername() == username) {
//	            	acc1.toString();
//					
//					boolean Option = false;
//					while(Option ==  false) {
//						char option = Helper.readChar("Delete this Account? ");
//						
//						if (option == 'Y' || option == 'y') {
//							Option = true;
//							accountList.remove(account1);
//							System.out.println("Account has been deleted successfully!");
//						} else if (option == 'n' || option == 'N') {
//							Option = true;
//						} else {
//							System.out.println("Invalid Option!");
//						}
//					}
//				}
//			}
//		}
		
		public static void viewAllAccount(ArrayList<Account> accounList) {
			String StudentId = Helper.readString("Enter your Student ID > ");
			boolean check = true;
			
			for (Account acc: accountList) {
				if(acc.getStudentId().contentEquals(StudentId)) {
					check = false;
					String output = String.format("%-20s%-20s%-20s%-20s\n", "ROLE: ", "CONTACT NUMBER: ", "STUDENT: ", "USERNAME: ");
					output += String.format("%-20s%-20s%-20s%-20s", acc.getUserRole(), acc.getContactNumber(), acc.getStudentId(), acc.getUsername());
					System.out.println(output);
				}
			}
			
			if(check == true) {
				System.out.println("No account with the Student ID");
			}
		}
		
		public static void updateAccount(ArrayList<Account> accountList){
			String studentId = Helper.readString("Enter the Student ID > ");
			for(Account acc: accountList){
				if(acc.getStudentId().contentEquals(studentId)) {
					
					System.out.println("Option 1: Change Username");
					System.out.println("Option 2: Change Contact Number");
					int option = Helper.readInt("Which do you want to update? > ");
					
					if (option == 1) {
						String newUsername = Helper.readString("Enter your new Username > ");
						
						if(acc.getUsername().equalsIgnoreCase(newUsername)) {
							System.out.println("Error: Same Username");
						}
						else {
							acc.setUsername(newUsername);
							System.out.println("Update Successfully!");
						}
					}
					
					else if (option == 2) {
						String newContactNumber = Helper.readString("Enter your new Contact Number > ");
						
						if(acc.getContactNumber().equalsIgnoreCase(newContactNumber)) {
							System.out.println("Error: Same Contact Number");
						}
						else {
							acc.setContactNumber(newContactNumber);
							System.out.println("Update Successfully!");
						}
					}
					else {
						System.out.println("Error: Invalid option number");
						
					}
					
				}
				else {
					System.out.println("No account with that Student ID! ");
				}
			}
		}
		
//		private void menu() {
//			Helper.line(60, "=");
//			System.out.println("SCHOOL LUNCH ACCOUNT");
//			Helper.line(60, "=");
//			System.out.println("1) Add Menu Item");
//			System.out.println("2) Delete Menu Item");
//			System.out.println("3) View All Menu Item");
//			System.out.println("4) Update Menu Item");
//			System.out.println("5) Search Menu Item");
//			System.out.println("6) Quit");
//		}
//		
//		
//		private void start() {
//			int option = -1;
//			
//			while (option !=6) {
//				
//				menu();
//				option = Helper.readInt("Enter Choice >");
//				
//				if (option == 1) {
//					addMenuItem();
//					
//					
//				}
//				else if (option == 2) {
//					deleteMenuItem();
//					
//				}
//				else if (option == 3) {
//					viewMenuItem();
//					
//				}
//				else if (option == 4) {
//					updateMenuItem();
//					
//				}else if (option == 5) {
//					searchItemByName();
//				
//				}else {
//					System.out.println("Thank you!");
//					
//				}
//			}
//		}
		
		
		
}

