import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
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
	
	// Would TreeSet be a better choice?
	// Allow sorting by item ID code
	private TreeSet<Object> menu;
	
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
		
		while(scan.hasNextLine()) {
			
			String line = scan.nextLine();
			String[] data = line.split(";");
			
			// create new item object using data
			// add the object to the TreeSet
		}
		scan.close();
		}catch(Exception e){
			
		}
	}
	
	/** 
	 * method to return a requested item object from the menu
	 * 
	 * @param ID			desired Items unique ID
	 * @return 			item		
	 */ 
	public Object getItemID(int description) {
		// TODO
		return null;
	}
	
	/**
	 * returns the price of a requested item.
	 * 
	 * @param ID			requested items unique ID		
	 * @return			price
	 */
	public int getPrice(int ID) {
		// TODO
		return 0;
	}
	
	/**
	 * Returns an ArrayList of the menu descriptions.
	 * Returned in order and format to be displayed in menu.
	 * 
	 * @return
	 */
	public ArrayList<Integer> menuList(){
		// TODO
		return null;
	}
	
	/**
	 * Returns a price list ordered by the ID codes
	 * i.e in the order they appear in the menu.
	 * 
	 * @return			arrayList of all item prices
	 */
	public ArrayList<Integer> priceList(){
		// TODO
		return null;
	}
	
	/**
	 * Returns an items details.
	 * 
	 * @param name		item identifier
	 * @return			return item details in desired order
	 */
	public int get(String name) {
		// TODO
		return 0;
	}
	
	/**
	 * Returns a list containing the details of every item in that category.
	 * 
	 * @param			
	 * @return
	 */
	public ArrayList<String> getCategoryMembers(String catID){
		// TODO
		return null;
	}
	
	/**
	 * Returns all details needed to instantiate a new item object.
	 * 
	 * @param name		accepts the item identifier. Preferably the item ID code
	 * @return			returns [data structure/string with delimiter] with all item details
	 */
	public ArrayList<String> itemDetails(String name){
		// TODO
		return null;
	}
	

}
