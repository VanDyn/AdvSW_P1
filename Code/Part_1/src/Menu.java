import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * Class to create and access the coffee shops menu.
 * 
 * @author calumthompson
 *
 */
public class Menu {
	
	/** Would TreeMap be a better choice?
	 * Allow sorting by item ID code. 
	 * Will need custom comparator class.
	 * 
	 * EX. Unique ID: COF101
	 * 
	 * COF - Coffee
	 * TEA - Tea
	 * JUI - Juice
	 * SDW - Sandwich
	 * PST - Pastries
	 * 
	 */
	private HashSet<Object> menu;
	 
	
	/**
	 * Constructor reads in the menu .txt file and stores it in the [Selected data structure]
	 * 
	 * @param txtFile	name of the text file used to read in the menu
	 */
	Menu(String txtFile){
		// TODO
		
		try {
			
		BufferedReader buff = new BufferedReader(new FileReader("exampleMenu.txt"));
		Scanner scan = new Scanner(buff);
		String[] data = new String[4];
		
		while(scan.hasNextLine()) {
			
			String line = scan.nextLine();
			data = line.split(";");
			
			String description = data[0];
			String cost = data[1];
			String category = data[2];
			String ID = data[3];
			
			System.out.println(ID);
			
			// create new item object using data
			// add the object to the [data structure]
		}
		
		scan.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}
	}
	
	
	

	
	/**
	 * Returns all details needed to instantiate a new item object.
	 * Search menu for item.
	 * 
	 * @param name		accepts the item identifier. Preferably the item ID code
	 * @return			returns [data structure or string with delimiter] with all item details
	 */
	public String newItemDetails(String description){
		
		String items = new String();
		Iterator<Object> itr = menu.iterator();
				
		 // loop through each member of menu set. 
		while(itr.hasNext()) {
			
			if(itr.next().getDescription() == description) {
				items = itemDetails(itr.next());
			}
				
			
		}
		
		return items;
	}
	
	
	
	
	
	/**
	 * Returns a list containing the details of every item in that category.
	 * 
	 * Search menu for members of a specified category.
	 * 
	 * @param category		Specify which category to retrieve members from		
	 * @return				ArrayList of item objects
	 */
	public ArrayList<Object> getCategoryMembers(String category){
		
		ArrayList<Object> items = new ArrayList<Object>();
		Iterator<Object> itr = menu.iterator();
		
		// loop through each member of menu set.
		// if the first three
		while(itr.hasNext()) {
			
			if(itr.next().getCategory == category) {
				items.add(itr.next());
			}
		}
		
		return items;
	}
	
	
	
	
	
	/**
	 * Returns a list containing the details of every item in that category.
	 * -->[Description;Price;Category;ID]
	 * Search menu for members of a specified category.
	 * 
	 * @param category		category to return details of			
	 * @return
	 */
	public ArrayList<String> getCategoryDetails(String category){
		
		ArrayList<String> itemDeets = new ArrayList<String>();
		ArrayList<Object> categoryItems = getCategoryMembers(category);
			
		// loop through each member of menu set.
		// if the first three
		for(Object item: categoryItems) {
			itemDeets.add(itemDetails(item));
		}
		
		return itemDeets;
	}
	
	
	
	
	
	/**
	 * Check whether and item order is valid.
	 * Used for checking the initial order text file.
	 * This can be changed to only accept specific information
	 * 
	 * @param			order item details
	 * @return			true/false
	 */
	public boolean inMenu(String description, String price, String category, String ID) {
		
		menuItem tempItem = new menuItem(description,price,category,ID);
		Iterator<Object> itr = menu.iterator();
		boolean valid = false;
		
		
		if(menu.contains(tempItem)) {
			valid = true;
		}
		
//		while(itr.hasNext()) {
//			if(itr.next().getDescription() == description) {
//				valid = true;
//				break;
//			}
//		}
		 
		
		return valid;
	}
	
	/**
	 * Return the cost of an item.
	 * Searches the menu by the items description
	 * @param description		items description
	 * @return cost				specified items cost
	 */
	public String getItemCost(String description) {
		Iterator<Object> itr = menu.iterator();
		String cost;
		
		while(itr.hasNext()) {
			if(itr.next().getDescription() == description) {
				cost = itr.next().getCost();
			}
		}
		return cost;
	}
	
	
	/**
	 * Return a string of an items details.
	 */
	private String itemDetails(Object item) {
		
		String description = item.getDescription();
		int price = item.getPrice();
		String category = item.getCategory();
		String id = item.getID();
		
		String itemDetails = description + ";"+ price + ";" + category + ";"  + id;
		
		return itemDetails;
	}
	

	

}
