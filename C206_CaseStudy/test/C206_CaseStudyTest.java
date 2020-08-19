import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private MenuItem i1;
	private MenuItem i2;
	private ArrayList<MenuItem> menuList;
	private ArrayList<Order> orderList;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	
	@Before
	public void setUp() throws Exception {
		i1 = new MenuItem("Fruits & Drinks", "Watermelon", true, 1.50);
		i2 = new MenuItem("Fruits & Drinks", "Apple", true, 0.50);
	orderList = new Order("19015183", "19-08-2020", menuList);
	   menuList = new ArrayList<MenuItem>();
	   orderList = new ArrayList<Order>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Test
	public void addOrderTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Order arraylist to add to", orderList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		orderList.add(od);
		assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
		assertSame("Check that Order is added", i1, orderList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		SchoolLunchApp.addOrder(orderList);
		assertEquals("Check that Order arraylist size is 2", 2, orderList.size());
		assertSame("Check that Order is added", i2, orderList.get(1));
	}

}
