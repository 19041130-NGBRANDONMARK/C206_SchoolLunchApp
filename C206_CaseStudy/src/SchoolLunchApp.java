import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolLunchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
		
		public static void userTypeMenu() {
			System.out.println("1. Admin login");
			System.out.println("1. User login");
		}
				
		
		private static void optionMenu() {
			
			System.out.println("1. Display Menu Items");
			System.out.println("2. Display Bills");
			System.out.println("3. Display Menu");
			System.out.println("4. Display Orders");
			System.out.println("5. Quit");
			
		
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
							option = false;
							System.out.println("Bill not deleted! ");
						}else {
							System.out.println("Wrong option!");
						}
					}
				}
			}
		}
		public void viewAllBill(ArrayList<Bill> billArr) {
			
		}
		
		public void createMenu(ArrayList<Menu> menu) {
//			viewAllMenuItem(ArrayList<MenuItem> items);
			ArrayList<MenuItem> choosen3 = null;
			boolean yesNo = false;
			
			//first one
			String name1 = Helper.readString("The first menu you want to add in? *Enter the name* > ");
//			for (int i=0; i<items.size(); i++) {
//				if (name.equalsIgnoreCase(items.get(i).getName())) {
//					choosen3.add(items.get(i));
//					yesNo = true;
//				}
//			}
//			if (yesNo == false) {
//				System.out.println(name1+" not found");
//				choosen3.clear();
//				yesNo = false;
//				createMenu(menu);
//			}
			
			//second one
			String name2 = Helper.readString("The second menu you want to add in? *Enter the name* > ");
//			for (int i=0; i<items.size(); i++) {
//				if (name.equalsIgnoreCase(items.get(i).getName())) {
//					choosen3.add(items.get(i));
//					yesNo = true;
//				}
//			}
//			if (yesNo == false) {
//				System.out.println(name1+" not found");
//				choosen3.clear();
//				yesNo = false;
//				createMenu(menu);
//			}
			
			//third one
			String name3 = Helper.readString("The second menu you want to add in? *Enter the name* > ");
//			for (int i=0; i<items.size(); i++) {
//				if (name.equalsIgnoreCase(items.get(i).getName())) {
//					choosen3.add(items.get(i));
//					yesNo = true;
//				}
//			}
//			if (yesNo == false) {
//				System.out.println(name1+" not found");
//				choosen3.clear();
//				yesNo = false;
//				createMenu(menu);
//			}
			
			String disName = Helper.readString("What name do you want it to be display as? > ");
			int month = Helper.readInt("Which month? > ");
			int num = Helper.readInt("Number of Item(s)? > ");
			menu.add(new Menu(disName, month, num, choosen3));
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
			String output = "";
			for (Menu m : menu) {
				output += m.toString()+"\n";
			}
			System.out.println(output);
			
			Boolean yesNo = false;
			String name = Helper.readString("Which one do you want to delete? *Enter the name* > ");
			for (int i=0; i<menu.size(); i++) {
				if (name.equalsIgnoreCase(menu.get(i).getDisplayName())) {
					menu.remove(i);
					yesNo = true;
				}
			}
			if (yesNo) {
				System.out.println(name+" deleted");
			} else {
				System.out.println(name+" not found");
			}
		}

		public void addMenuItem(ArrayList<MenuItem> menuItem) {
			System.out.println("Adding MenuItem");
			String name = Helper.readString("What is the menu item name: " );
			String category = Helper.readString("What category is it under: ");
			boolean healthy = Helper.readBoolean("Is it Healthy ( true / false ): ");
			double price = Helper.readDouble("How much is this item: ");
			
			ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
			menu.add(new MenuItem(category, name , healthy , price));
			System.out.println("MenuItem added!");
			
			
			
		}
		
		public void deleteMenuItem(ArrayList<MenuItem> menuItem) {
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
		
		
		public  void viewMenuItem(ArrayList<MenuItem> menuItem) {
			System.out.println("Displaying Menu Item");
			ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
			String output = String.format("%-20s %-20s %-10s %-10s" , "Name" , " Category" ,"Price" ," Healthier Choice?" );
			int i = 0;
			while( i < menu.size() ) {
				output += menu.get(i).toString();
				i++;
			}
			System.out.println(output);
		
		}
		

	private static String createOrderItemList(ArrayList<Order> order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
