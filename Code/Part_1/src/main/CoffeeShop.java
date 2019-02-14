package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class CoffeeShop {
	
	public static orderList orderList = new orderList();
	
	LinkedList<MenuItem> ll;

	CoffeeShop(){
		
		Menu menu = new Menu("examplemenu.txt");
		ll = new LinkedList<MenuItem>(); 
		
		MenuItem item;
		
		try {

			BufferedReader buff = new BufferedReader(new FileReader("existingOrders"));
			Scanner scan = new Scanner(buff);
			String[] data = new String[6];
			
			String prevCustomer;
			String prevTime;
			
			String timeStamp = "s";
			String custID = "j";
			String itemID = "j";
			double cost = 0;
			String description = "j";;
			String category = "j";;
			
			boolean first = true;
			
			while(scan.hasNextLine()) {

				String line = scan.nextLine();
				
				data = line.split(";");
				
				
				prevCustomer = custID;
				
				prevTime = timeStamp;
				timeStamp = data[0];
			
				custID = data[1];
				itemID = data[2];
				cost = Double.parseDouble(data[3]);
				description = data[4];
				category = data[5];
				
//				check if current customer ID is the same as the previous or if its the first order
				if(prevCustomer.equals(custID) || prevCustomer.equals(null) || first == true) {
					item = new MenuItem(itemID,cost,description,category);
					first = false;
					// check that item is on the menu
					if(menu.inMenu(item)) {
						addToList(item);
					}
					
				/**	New customer. 
				 *	Send linkedList to orderList 
				 *	Clear Linked list.
				 *	Add new customers first order
				 * 
				 */
				}else {
					orderList.addOrders(ll,prevCustomer,prevTime);
					clearL();
					item = new MenuItem(itemID,cost,description,category);
					addToList(item);
				}
				

			}

			scan.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	
	
private void addToList(MenuItem item) {
	ll.add(item);
}

private void clearL() {
	ll.clear();
}
	
	
	
	

}

