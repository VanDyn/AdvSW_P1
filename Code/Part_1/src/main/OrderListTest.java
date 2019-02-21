package orderList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.*;
import org.junit.jupiter.api.Test;

class OrderListTest {

	OrderList ol = new OrderList();
	
	LinkedList<MenuItem> order = new LinkedList<MenuItem>();
	LinkedList<MenuItem> order1 = new LinkedList<MenuItem>();
	MenuItem m1 = new MenuItem("COF123", 2, "Coffee with milk", "DRINK");
	MenuItem m2 = new MenuItem("TEA234", 1, "Tea with milk", "DRINK");
	MenuItem m3 = new MenuItem("COF136", 1, "Coffee", "DRINK");
	
	
	@Test
	void addOrderTest() {
		order.add(m1);
		order.add(m2);
		Order o = new Order("C001", order);
		ol.addOrder(o);
		assertEquals(ol.getNumberOfOrders(),1);
	}
	
	@Test
	void getOrdersTest() {
		order.add(m1);
		order.add(m2);
		Order o = new Order("C001", order);
		ol.addOrder(o);
		assertSame(ol.getOrders(),ol);
	}
	
	@Test
	void getOrderTest() throws OrderDoesNotExistException {
		order.add(m1);
		order.add(m2);
		Order o = new Order("C001", order);
		ol.addOrder(o);
		order1.add(m2);
		order1.add(m3);
		Order o2 = new Order("C002", order1);
		ol.addOrder(o2);
		ol.getOrder("C004");
		assertEquals(ol.getOrder("O002"),o2);
	}

}
