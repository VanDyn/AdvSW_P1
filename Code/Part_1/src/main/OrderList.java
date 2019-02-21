package main;

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
	
		if(orderNumber < 10) apdOrdNum = "O00";
		else if (orderNumber < 100) apdOrdNum = "O0";
		else apdOrdNum = "O";
		apdOrdNum = apdOrdNum + orderNumber;
		orderList.put(apdOrdNum, order);
		orderNumber++;
	}
	
	//Print all orders and return map of all orders placed
	public Map<String,Order> getOrders() {
		
		for(Order o: orderList.values()) {
			System.out.println(o.getItemList());
			
		}
		System.out.println(orderList.toString());
		return orderList;
	}
	
	//Return specific order using the order number
	public Order getOrder(String orderNumber) throws OrderDoesNotExistException {
		if(orderList.get(orderNumber)!=null) return orderList.get(orderNumber);
		else throw new OrderDoesNotExistException();
	}
	
	public int getNumberOfOrders() {
		return orderList.size();
	}
}
