package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Order implements Comparable<Order>
{
	private String timeStamp;
	private LinkedList<MenuItem> itemList;
	private String ID;
	
	public Order(LinkedList<MenuItem> Items) //Strings in linkedList to be changed to object menuItem
	{	
		this.itemList = Items;
		this.timeStamp = this.makeTimeStamp();
	}
	
	public Order(String custID, String tStamp, LinkedList<MenuItem> link){
		this.ID = custID;
		this.timeStamp = tStamp;
		this.itemList = link;
		
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
	public float getOrderTotal()
	{
		int size = itemList.size();
		float orderTotal = 0;
		for(int i=0;i<size;i++)
		{
			//orderTotal += this.itemList.get(i).cost; //wont work while objects are Strings. TODO implement item linkedlists
		}
		return orderTotal;
	}
	public void discount()
	{
		//TODO
	}
	
	@Override
	public int compareTo(Order arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}

