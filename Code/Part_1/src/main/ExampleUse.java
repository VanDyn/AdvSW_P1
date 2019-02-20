package main;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Example use of how discounts are applied
 * @author calumthompson
 *
 */
public class ExampleUse {
	
	public static void main(String[] args) throws NotOnMenuException {

		Menu menu = new Menu("exampleMenu");
		LinkedList<MenuItem> ll = new LinkedList<MenuItem>();
		
		// Adding items to the LinkedList.
		ll.add(menu.getItem("Brownie"));
		ll.add(menu.getItem("Egg"));
		ll.add(menu.getItem("Americano"));
		ll.add(menu.getItem("Americano"));
		ll.add(menu.getItem("Americano"));
		
		// Create order total
		BigDecimal total = new BigDecimal(0);
		total = total.add(menu.getItemCost("Brownie"));
		total = total.add(menu.getItemCost("Egg"));
		total = total.add(menu.getItemCost("Americano"));
		total = total.add(menu.getItemCost("Americano"));
		total = total.add(menu.getItemCost("Americano"));
		
		// Create ApplyDiscount object using LinkedList and order total in constructor. 
		ApplyDiscount d = new ApplyDiscount(ll,total);
		
		// Run checkForDiscounts() method to apply available discounts.
		// Returned Object encapsulates all relevant information.
		Discount discount = d.checkForDiscounts();
		
		// Check which discounts have been applied.
		ArrayList<String> appliedDiscounts = discount.getAppliedDiscounts();
		
		// Print out ArrayList of the discounts that are applied.
		System.out.println(appliedDiscounts.size());
		for(String aD : appliedDiscounts) {
			System.out.println(aD);
		}
		
		// Access information in the Discount object.
		System.out.println("Old Total: £" + total);
		System.out.println("New Total: £" + discount.getNewTotal());
		System.out.println("Amount Saved: £" + discount.getSavings());
		
	}

}
