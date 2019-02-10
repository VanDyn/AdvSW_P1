package orderlist;

import java.util.*;

public class OrderList {
     
	private Map<String,Order> orderList;
	private int orderNumber;
	private String apdOrdNum;
	
	public OrderList() {
		orderList = new TreeMap<String,Order>();
		orderNumber = 0;
	}
	
	//Place an order 
	public void addOrder(Order order) {
	
		if(orderNumber < 10) apdOrdNum = "C00";
		else if (orderNumber < 100) apdOrdNum = "C0";
		else apdOrdNum = "C";
		apdOrdNum = apdOrdNum + orderNumber;
		orderList.put(apdOrdNum, order);
		orderNumber++;
	}
	
	//Print all orders and return map of all orders placed
	public Map<String,Order> getOrders() {
		for(Order o: orderList.values()) {
			System.out.println(o.getUniqueID() + " " + o.getItemList());
		}
		return orderList;
	}
	
	//Return specific order using the order number
	public Order getOrder(String orderNumber) {
		return orderList.get(orderNumber);
	}
	
	public static void main(String[] args) {
		
		OrderList oL = new OrderList();
		LinkedList<String> order = new LinkedList<String>();
		
		order.add("Coffee");
		order.add("Tea");
		Order o1 = new Order("C001", order);
		oL.addOrder(o1);
		
		oL.getOrders();
	}
}
