package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.junit.*;

import orderList.OrderList;
import orderList.MenuItem;
import orderList.Order;


public class OrderListTest {

	OrderList ol = new OrderList();
	
	LinkedList<MenuItem> order; 
	LinkedList<MenuItem> order1;
	MenuItem m1;
	MenuItem m2;
	MenuItem m3;
	
	@Before
	public void setup(){
		order = new LinkedList<MenuItem>();
		order1 = new LinkedList<MenuItem>();
		m1 = new MenuItem("COF123", new BigDecimal(2), "Coffee with milk", "DRINK");
		m2 = new MenuItem("TEA234", new BigDecimal(2), "Tea with milk", "DRINK");
		m3 = new MenuItem("COF136", new BigDecimal(3), "Coffee", "DRINK");
		
	}
	
	
	
	@Test
	public void addOrderTest() {
		order.add(m1);
		order.add(m2);
		Order o = new Order("C001","13:00", order);
		ol.addOrder(o);
		assertEquals("Correct number of orders",ol.getNumberOfOrders(),1);
		
		
		
	}
	
	@Test
	public void getOrdersTest() {
		order.add(m1);
		order.add(m2);
		Order o = new Order("C001", "12:01", order);
		Order o2 = new Order("C001", "12:01", order);
		ol.addOrder(o);
		ol.addOrder(o2);
		
		Map<String,Order> m = ol.getOrders();
				
		assertFalse("Correct order reterned", m.containsKey("C001"));
		assertTrue("Correct order reterned", m.containsKey("O001"));
		
		Set<String> s = m.keySet();
		
		for(String custID : s) {
			System.out.println(custID);
		}
		
		//assertSame(ol.getOrders(),ol);
	}
	
//	@Test
	public void getOrderTest() {
		order.add(m1);
		order.add(m2);
		Order o = new Order("C001","12:04", order);
		ol.addOrder(o);
		order1.add(m2);
		order1.add(m3);
		Order o2 = new Order("C002","2:30", order1);
		ol.addOrder(o2);
		
		Map<String,Order> m = ol.getOrders();
		
		assertTrue("Correct order reterned", m.size() == 2);
		assertTrue("Correct order reterned", m.containsKey("O002"));
	}

}
