import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order o1;
	private Order o2;
	private MenuItem i1;
	private MenuItem i2;
	
	private ArrayList<MenuItem> menuList;
	private ArrayList<Order> OrderList;
	
	public OrderTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		o1 = new Order(1,"19041130","20th March 2020","Set Meal");
		o2 = new Order(2,"19041150","18th February 2020","Fruits & Drinks");
		i1 = new MenuItem(1,"Set Meal","Nasi Briyani",false,3.20);
		i2 = new MenuItem(2,"Fruits & Drinks","Fruit Cup",true,1.50);
		 OrderList = new ArrayList<Order>();
		 menuList = new ArrayList<MenuItem>();
	
	}
	
	@Test
	public void addOrderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Order arraylist to add to", OrderList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		orderMain.addOrder(OrderList, o1);
		assertEquals("Test if that Order arraylist size is 1?", 1, OrderList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Order is added same as 1st item of the list?", o1, OrderList.get(0));

		// Add another item. test The size of the list is 2?
		orderMain.addOrder(OrderList, o2);
		assertEquals("Test that Order arraylist size is 2?", 2, OrderList.size());
	}
	
	@Test
	public void addMenuTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Order arraylist to add to", menuList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		orderMain.addMenu(menuList, i1);
		assertEquals("Test if that Order arraylist size is 1?", 1, menuList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Order is added same as 1st item of the list?", i1, menuList.get(0));

		// Add another item. test The size of the list is 2?
		orderMain.addMenu(menuList, i2);
		assertEquals("Test that Order arraylist size is 2?", 2, menuList.size());
	}
	
	@Test
	public void retrieveAllOrderTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Order arraylist to retrieve item", OrderList);
		
		//test if the list of orders retrieved from the Order is empty - boundary
		String allOrder= orderMain.retrieveAllOrder(OrderList);
		String testOutput = "";
		assertEquals("Check that viewAllOrder", testOutput, allOrder);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		orderMain.addOrder(OrderList, o1);
		orderMain.addOrder(OrderList, o2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, OrderList.size());
		
		//test if the expected output string same as the list of orders retrieved from the SourceCentre	
		allOrder= orderMain.retrieveAllOrder(OrderList);
		testOutput = String.format("%-25s %-25s %-30s %-15s \n",1,"19041130","20th March 2020","Set Meal");
		testOutput += String.format("%-25s %-25s %-30s %-15s \n",2,"19041150","18th February 2020","Fruits & Drinks");
	
		assertEquals("Test that viewAllOrder", testOutput, allOrder);
	}
	
	@Test
	public void retrieveAllMenuTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Order arraylist to retrieve item", OrderList);
		
		//test if the list of orders retrieved from the Order is empty - boundary
		String allMenu= orderMain.retrieveAllMenu(menuList);
		String testOutput = "";
		assertEquals("Check that viewAllOrder", testOutput, allMenu);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		orderMain.addMenu(menuList, i1);
		orderMain.addMenu(menuList, i2);
		assertEquals("Test that Menu arraylist size is 2", 2, menuList.size());
		
		//test if the expected output string same as the list of orders retrieved from the SourceCentre	
		allMenu= orderMain.retrieveAllMenu(menuList);
		testOutput = String.format("%-25s %-25s %-25s  %-25b %-15.2f  \n",1,"Set Meal","Nasi Briyani",false,3.20);
		testOutput += String.format("%-25s %-25s %-25s  %-25b %-15.2f  \n",2,"Fruits & Drinks","Fruit Cup",true,1.50);
	
		assertEquals("Test that viewMenu", testOutput, allMenu);
	}
	

	@After
	public void tearDown() throws Exception {
		o1 = null;
		o2 = null;
		i1 = null;
		i2 = null;
		OrderList = null;
		menuList = null;
	}
	
	
}
