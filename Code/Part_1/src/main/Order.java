package main;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Order implements Comparable<Order>
{
	private String timeStamp;
	private LinkedList<MenuItem> itemList;
	private String ID;
	private BigDecimal total;
	
	public Order(LinkedList<MenuItem> Items, BigDecimal total) //GUI constructor
	{	
		this.itemList = Items;
		this.timeStamp = this.makeTimeStamp();
		this.total = total;
	}
	
	public Order(String custID, String tStamp, LinkedList<MenuItem> link){ //File read constructor
		this.ID = custID;
		this.timeStamp = tStamp;
		this.itemList = link;
		this.total = this.getOrderTotal();
	}
	private String makeTimeStamp()
	{
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("d.M.yyyy,hh:mm:ss");
		String time = ft.format(dNow);
		return time;
	}
	public String getTimeStamp()
	{
		return this.timeStamp;
	}
	public LinkedList<MenuItem> getItemList()
	{
		return this.itemList;
	}
	public BigDecimal getOrderTotal() throws EmptyLinkedListException
	{
		BigDecimal orderTotal = null;
		int size = itemList.size();
		for(int i=0;i<size;i++)
			{
				orderTotal = orderTotal.add(this.itemList.get(i).getCost()); //wont work while objects are Strings. TODO implement item linkedlists
			}
		return orderTotal;
	}
	
	@Override
	public int compareTo(Order arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}

