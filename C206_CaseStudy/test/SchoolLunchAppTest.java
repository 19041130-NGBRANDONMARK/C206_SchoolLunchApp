import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SchoolLunchAppTest {

	private Account account1;
	private Account account2;
	private Order order1;
	private Order order2;
	private MenuItem menu1;
	private MenuItem menu2;
	private MenuItem i1;
	private MenuItem i2;
	private Menu mMenu1;
	private Bill b1;
	private Bill b2;

	private ArrayList<Account> accountList;
	private ArrayList<Order> orderList;
	private ArrayList<MenuItem> menuItem;
	private ArrayList<Menu> menu;
	private ArrayList<Bill> bill;

	public SchoolLunchAppTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		account1 = new Account("Student", "19000001", "80007000", "spass");
		account2 = new Account("Parent", "18000001", "90007000", "ppass");
		order1 = new Order("45000", "16/08/20", menuItem);
		order2 = new Order("35000", "16/08/20", menuItem);
		menu1 = new MenuItem("fish", "chicken", true, 10.0);
		menu2 = new MenuItem("fish", "chicken", true, 10.0);
		b1 = new Bill("Jack", 100.00, "19/08/2020");
		b2 = new Bill("Jack", 100.00, "19/08/2020");

		accountList = new ArrayList<Account>();
		orderList = new ArrayList<Order>();
		menuItem = new ArrayList<MenuItem>();
		bill = new ArrayList<Bill>();

		i1 = new MenuItem("Fruits & Drinks", "Watermelon", true, 1.50);
		i2 = new MenuItem("Fruits & Drinks", "Apple", true, 0.50);
		orderList = new Order("19015183", "19th March 2020", menuItem);
		menuItem = new ArrayList<MenuItem>();
		orderList = new ArrayList<Order>();

		mMenu1 = new Menu("menu1", 1, 1, menuItem);
	}

	@Test
	public void addAccount() {
		// Account list is not null, so that can add a new account
		assertNotNull("Test if there is valid Account arraylist to add to", accountList);
		

		// Given an empty list, after adding 1 account, the size of the list is 1
		accountList.add(account1);
		accountList.add(account2);
		assertEquals("Test if that Account arraylist size is 1?", 2, accountList.size());
		
		//If username already exist, display error message
		String username = Helper.readString("Enter your Username > ");
		for(Account acc: accountList) {
			assertSame(acc.getUsername(), username);
			System.out.println("Error: Username already exist!");
		}
	}

	@Test
	public void deleteAccount() {
		String username = Helper.readString("Enter your Username > ");
		// Account list is not null, so that can add a new account
		assertNotNull("Test if there is valid Account arraylist to delete from", accountList);
			

		// If username does not match to the account in the accountList
		assertNotSame(account2.getUsername(), username);
		System.out.println("Error: Cannot find account with that username!");

		// The account username is the same as account in the list
		assertSame(account1.getUsername(), username);
		System.out.println("Account deleted");
	}
	
	@Test
	public void updateAccount() {
		//
		String username = Helper.readString("Enter your Username > ");
		String contactNumber = Helper.readString("Enter your Username > ");
		assertNotSame(account2.getUsername(), username);
		assertNotSame(account2.getContactNumber(), contactNumber);
		System.out.println("Update success!");
	
	}
	@Test
	public void addOrderTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Order arraylist to add to", orderList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		orderList.add(i1);
		assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
		assertSame("Check that Order is added", i1, orderList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		SchoolLunchApp.addOrder(orderList);
		assertEquals("Check that Order arraylist size is 2", 2, orderList.size());
		assertSame("Check that Order is added", i2, orderList.get(1));
	}

	public void createMenuTest() {
		// check if the list is null
		assertNotNull("Check that the arraylist is empty", menu);
		// check if the list size is correct
		menu.add(mMenu1);
		assertEquals("Check that the arraylist size is 1", 1, menu.size());
		// check the first item in list is correct
		assertSame("Check that the first item in list is correct", menu1, menu.get(0));
	}

	public void viewAllMenuTest() {
		// check if the list is empty
		assertNotNull("Check if there is a valid arraylist to retreive", menu);
		// check if the list retrieve correctly
		menu.add(mMenu1);
		assertSame("Check that the first item in list is correct", menu1, menu.get(0));
	}

	public void deleteMenuTest() {
		// check if the list is null
		assertNotNull("Check that the arraylist is empty", menu);
		// check if the list size is correct
		menu.add(mMenu1);
		assertEquals("Check that the arraylist size is 1", 1, menu.size());
		// check the first item in list is correct
		assertSame("Check that the first item in list is correct", menu1, menu.get(0));
		// check if delete successfully
		Menu mMenu2 = menu.get(0);
		menu.remove(0);
		assertNotNull("Check that the arraylist is empty", menu);
		// check if delete correctly
		assertSame("check if delete correctly", mMenu2, mMenu1);
	}
	
	public void updateMenuTest() {
		// check if the list is null
		assertNotNull("Check that the arraylist is empty", menu);
		// check if the list size is correct
		menu.add(mMenu1);
		assertEquals("Check that the arraylist size is 1", 1, menu.size());
		// check the first item in list is correct
		assertSame("Check that the first item in list is correct", menu1, menu.get(0));
		// check if update correctly
		String newName = "FEB is the correct one";
		int newMonth = 2;
		menu.get(0).setDisplayName(newName);
		menu.get(0).setMonth(newMonth);
		assertSame("check if update correctly", newName, menu.get(0).getDisplayName());
		assertSame("check if update correctly", newMonth, menu.get(0).getMonth());
	}

	public void viewMenuItemTest() {
		// error
		// check if the list is empty
		assertNotNull("Check if there is a valid arraylist to retrieve", menu);

		// check if the list size is correct
		menu.add(mMenu1);
		assertEquals("Check that the rraylist size is 1", 1, menu.size());

	}

	public void deleteMenuItemTest() {
		// fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Check if there is a valid arraylist to retreive", menu);
		
		// check if the list size is correct
		menu.add(mMenu1);
		assertEquals("Check that the rraylist size is 1", 1, menu.size());
		
	}

	public void addMenuItemTest() {
		// error
		// check if the list is empty
		menu.add(mMenu1);
		assertEquals("Check that the rraylist size is 1", 1, menu.size());
		
		
		// check the first item in list is correct
		assertSame("Check that the first item in list is correct", menu1, orderList.get(0));


	}
	public void viewBillTest() {
		//check if the bill list is empty
		//error
		assertNotNull("Check if there is a valid arraylist to retrieve", bill);
		
		// check if the list size is correct
		bill.add(b1);
		assertEquals("Check that the Arraylist size is 1", 1, bill.size());
	}
	public void createBillTest() {
		// check if the list size is correct
		bill.add(b1);
		bill.add(b2);
		assertEquals("Check that the Arraylist size is 1", 1, bill.size());
		// check that the correct fields are added into the arraylist
		assertSame("Check that the correct fields in list are correct", b1, b2);
			
	}
	public void deleteBillTest() {
		// to see if there is any bill to delete from the list
		assertNotNull("Test if there is bill to delete from the list", bill);
		// The bill given is inside the list
		assertEquals("Test that the bill user wants to find is in the list", b1, bill.get(1));
		assertNull("Test the bill is deleted", bill);

		
	}
}