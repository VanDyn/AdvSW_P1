package orderList;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class OrderTest {
	
	LinkedList<MenuItem> itemList = new LinkedList<MenuItem>(); 
	MenuItem cof = new MenuItem("COF001", 1.50, "Coffee with milk", "Coffee");
	MenuItem tea = new MenuItem("COF002", 0.50, "Tea without milk", "Tea");
	String orderId = "O001";

	SimpleDateFormat ft = new SimpleDateFormat ("d.M.yyyy,hh:mm:ss");
	
	
	@Test
	void getTimeStamp() {
		Date dNow = new Date();
		String time = ft.format(dNow);
		itemList.add(cof);
		itemList.add(tea);
		Order o = new Order(orderId, itemList);
		assertEquals(time, o.getTimeStamp());
	}
	
	@Test
	void getUniqueID() {
		itemList.add(cof);
		itemList.add(tea);
		Order o = new Order(orderId, itemList);
		assertEquals(orderId, o.getUniqueID());
	}
	
	@Test 
	void getItemList() {
		itemList.add(cof);
		itemList.add(tea);
		Order o = new Order(orderId, itemList);
		assertSame(o.getItemList(), itemList);
	}

}
