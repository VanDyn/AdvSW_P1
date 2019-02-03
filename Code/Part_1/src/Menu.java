import java.util.ArrayList;
import java.util.HashSet;

public class Menu {
	
	public HashSet<Object> menu;
	
	Menu(){
		
	}
	
	/** 
	 * method to return a requested item object from the menu
	 * @param ID			desired Items unique ID
	 * @return 			item		
	 */ 
	public Object getItem(int ID) {
		// TODO
		return null;
	}
	
	/**
	 * returns the price of a requested item
	 * @param ID			requested items unique ID		
	 * @return			price
	 */
	public int getPrice(int ID) {
		// TODO
		return 0;
	}
	
	/**
	 * Returns an ArrayList of the menu descriptions.
	 * Returned in order and format to be displayed in menu
	 * @return
	 */
	public ArrayList<Integer> menuList(){
		// TODO
		return null;
	}
	
	/**
	 * Returns a price list ordered by the ID codes
	 * i.e in the order they appear in the menu
	 * 
	 * @return			arrayList of all item prices
	 */
	public ArrayList<Integer> priceList(){
		// TODO
		return null;
	}
}
