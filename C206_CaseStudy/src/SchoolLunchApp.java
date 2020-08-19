import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolLunchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
		
		public static void userTypeMenu() {
			
		}
				
		
		private static void optionMenu() {
			

		
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
			
			 while(menuSelection.size() <=4) {
				 
			 }
			 
			 
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
						} else if (option == 'n' || option == 'n') {
							Option = true;
						} else {
							System.out.println("Invalid Option!");
						}
					}
				}
			}
		}
		


		

	private static String createOrderItemList(ArrayList<Order> order) {
		// TODO Auto-generated method stub
		return null;
	}

}
