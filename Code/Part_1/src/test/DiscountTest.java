package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import main.ApplyDiscount;
import main.Discount;
import main.Menu;
import main.MenuItem;
import main.NotOnMenuException;

public class DiscountTest {

	
	
	@Test
	public void twoCoffeesHalfPriceMuffinTest() throws NotOnMenuException {
		Menu menu = new Menu("exampleMenu.txt");
		LinkedList<MenuItem> ll = new LinkedList<MenuItem>();
		
		// Adding items to the LinkedList.
		ll.add(menu.getItem("Blueberry Muffin"));
		ll.add(menu.getItem("Americano"));
		ll.add(menu.getItem("Americano"));
		
		// Create order total
		BigDecimal total = new BigDecimal(0);
		total = total.add(menu.getItemCost("Blueberry Muffin"));
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
		
		assertEquals("6.70", (total).toString());
		assertEquals("5.950", (discount.getNewTotal()).toString());
	}
	@Test
	public void twoAmericanoDiscountTest() throws NotOnMenuException {
		Menu menu = new Menu("exampleMenu.txt");
		LinkedList<MenuItem> ll = new LinkedList<MenuItem>();
		
		// Adding items to the LinkedList.
		ll.add(menu.getItem("Americano"));
		ll.add(menu.getItem("Americano"));
		ll.add(menu.getItem("Americano"));
		
		// Create order total
		BigDecimal total = new BigDecimal(0);
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
		assertEquals("7.80", (total).toString());
		assertEquals("5.20", (discount.getNewTotal()).toString());
	}
	@Test
	public void MealDealTest() throws NotOnMenuException { //sandwich, drink, baked good for £6
		Menu menu = new Menu("exampleMenu.txt");
		LinkedList<MenuItem> ll = new LinkedList<MenuItem>();
		
		// Adding items to the LinkedList.
		ll.add(menu.getItem("Latte"));
		ll.add(menu.getItem("Ham and Cheese"));
		ll.add(menu.getItem("Brownie"));
		
		// Create order total
		BigDecimal total = new BigDecimal(0);
		total = total.add(menu.getItemCost("Latte"));
		total = total.add(menu.getItemCost("Ham and Cheese"));
		total = total.add(menu.getItemCost("Brownie"));

		
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
		System.out.println("Old Total: £" + total);
		System.out.println("New Total: £" + discount.getNewTotal());
		System.out.println("Amount Saved: £" + discount.getSavings());
		// Access information in the Discount object.
		assertEquals("7.75", (total).toString());
		assertEquals("6.00", (discount.getNewTotal()).toString());
	}

}
