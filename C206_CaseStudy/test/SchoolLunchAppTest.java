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
    private Order i1;
	private MenuItem i2;
	private Menu mMenu1;
    
    private ArrayList <Account> accountList;
    private ArrayList <Order> orderList;
    private ArrayList <MenuItem> menuItem;
    private ArrayList<Menu> menu;
    
    public SchoolLunchAppTest() {
        super();
    }

 

    @Before
    public void setUp() throws Exception {
        //prepare test data
        account1 = new Account("Student", "19000001", "80007000", "spass");
        account2 = new Account("Parent", "18000001", "90007000", "ppass");
        order1 = new Order("45000", "16/08/20", menuItem);
        order2 = new Order("35000", "16/08/20", menuItem);
        menu1 = new MenuItem("fish", "chicken", true, 10.0);
        menu2 = new MenuItem("fish", "chicken", true, 10.0);
        
        accountList = new ArrayList<Account>();
        orderList = new ArrayList<Order>();
        menuItem = new ArrayList<MenuItem>();
        
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
        
        //Given an empty list, after adding 1 account, the size of the list is 1
        accountList.add(account1);        
        assertEquals("Test if that Account arraylist size is 1?", 1, accountList.size());
        
        //The account just added is as same as the first account of the list
        assertSame("Test that account is added same as 1st account of the list?", account1, accountList.get(0));
        
        //Add another Account. test The size of the list is 2?
        accountList.add(account2);        
        assertEquals("Test if that Account arraylist size is 2?", 2, accountList.size());
    }
    
    @Test
    public void deleteAccount() {
        // Account list is not null, so that can add a new account
        assertNotNull("Test if there is valid Account arraylist to delete from", accountList);
        
        //If username does not match to the account in the accountList
        assertEquals(account2, accountList.get(2));
        
        //The account username is the same as account in the list
        assertEquals("Test that account deleted is the same as account in the list?", account2, accountList.get(3));
        assertNull("Test the account is empty", accountList);
        
    }
    @Test
	public void addOrderTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Order arraylist to add to", orderList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		orderList.add(i1);
		assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
		assertSame("Check that Order is added", i1, orderList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		SchoolLunchApp.addOrder(orderList);
		assertEquals("Check that Order arraylist size is 2", 2, orderList.size());
		assertSame("Check that Order is added", i2, orderList.get(1));
	}
    
    public void createMenuTest() {
    	//check if the list size is correct
    	menu.add(mMenu1);
    	assertEquals("Check that the rraylist size is 1", 1, menu.size());
    	//check the first item in list is correct
    	assertSame("Check that the first item in list is correct", menu1, orderList.get(0));
    }
    
    public void viewAllMenuTest() {
		//error
    	//check if the list is empty
		assertNotNull("Check if there is a valid arraylist to retreive", menu);
		//check if the list size is correct
		menu.add(mMenu1);
		assertEquals("Check that the rraylist size is 1", 1, menu.size());
	}
	
	public void deleteMenuTest() {
		//error
    	//check if the list is empty
		assertNotNull("Check if there is a valid arraylist to retreive", menu);
		//check if the list size is correct
		menu.add(mMenu1);
		assertEquals("Check that the rraylist size is 1", 1, menu.size());
	}

}