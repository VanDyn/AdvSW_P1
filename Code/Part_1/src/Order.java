import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
public class Order 
{
	private String timeStamp;
	private String UniqueID;
	private LinkedList<String> itemList;
	
	public Order(LinkedList<String> Items) //Strings in linkedList to be changed to object menuItem
	{	
		this.itemList = Items;
		this.timeStamp = this.makeTimeStamp();
		this.UniqueID = this.makeUniqueID();
	}
	private String makeUniqueID() //source - https://java2blog.com/java-generate-random-string/
	{
		int length = 8;
		String charList = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer randStr = new StringBuffer(length);
		SecureRandom secureRandom = new SecureRandom();
		for( int i = 0; i < length; i++ ) 
			randStr.append( charList.charAt( secureRandom.nextInt(charList.length()) ) );
		return randStr.toString();
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
	public String getUniqueID()
	{
		return this.UniqueID;
	}
	public LinkedList<String> getItemList()
	{
		return this.itemList;
	}
	public float getOrderTotal()
	{
		int size = itemList.size();
		float orderTotal = 0;
		for(int i=0;i<size;i++)
		{
			orderTotal += this.itemList.get(i).cost; //wont work while objects are Strings. TODO implement item linkedlists
		}
		return orderTotal;
	}
	public void discount()
	{
		//TODO
	}
	public static void main(String [] args) //Testing
	{  
		LinkedList<String> Items = new LinkedList<String>();
		Items.add("Coffee");
		Order O = new Order(Items);
		String timeStamp = O.makeTimeStamp();
		System.out.println("Order No: " + O.getUniqueID());
		System.out.println("Current Date: " + timeStamp.trim());
		
	}
}

