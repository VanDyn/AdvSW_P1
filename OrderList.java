package orderlist;

import java.util.*;

public class OrderList {

	private Map<Integer,Order> orderList;
	private int orderNumber;
	
	
	public OrderList() {
		orderList = new TreeMap<Integer,Order>();
		orderNumber = 0;
	}
	
	//Place an order 
	public void addOrder(String custId, LinkedList<String> itemList) {
		Order newOrder = new Order(custId, itemList);
		orderList.put(orderNumber, newOrder);
		orderNumber++;
	}
	
	//Print all orders and return map of all orders placed
	public Map<Integer,Order> getOrders() {
		for(Order o: orderList.values()) {
			System.out.println(o.getItemList());
		}
		return orderList;
	}
	
	//Return specific order using the order number
	public Order getOrder(int orderNumber) {
		return orderList.get(orderNumber);
	}
	
	public static void main(String[] args) {
		
		LinkedList<String> itemList = new LinkedList<String>();
		OrderList ol = new OrderList();
		
		itemList.add("Coffee");
		itemList.add("Tea");
		
		ol.addOrder("C001", itemList);
		ol.addOrder("C002", itemList);
		ol.getOrders();
		
		
	}
}
