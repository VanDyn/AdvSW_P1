
package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Class for applying discount once customer has hit checkout
 * 
 * @author calumthompson
 *
 */
public class ApplyDiscount {
	
	private LinkedList<MenuItem> orderedItems;
	private BigDecimal currentTotal;
	private BigDecimal discountedTotal;
	private BigDecimal savings;
	ArrayList<String> appliedDiscounts;
	
	ApplyDiscount(LinkedList<MenuItem> ll, BigDecimal t){
		this.appliedDiscounts = new ArrayList<String>();
		this.orderedItems = ll;
		this.currentTotal = t;
		discountedTotal = new BigDecimal(0);
		savings = new BigDecimal(0);
	}
	
	/**
	 * Method called to check which discount can be applied to current order
	 * @param ll			LinkedList of ordered items
	 * @param t			Current total
	 * @return			Returns the object Discount, containing the discountedTotal and a list of applied discounts
	 */
	public Discount checkForDiscounts() {	
		
		
		/**
		 * Apply discount methods.
		 * Check which have been applied.
		 * Max limit of discount that can be applied.
		 * Only one free item
		 * Only one 
		 */
		savings = twoAmericanoDiscount();
		discountedTotal = discountedTotal.subtract(savings);
		
		
		Discount discount = new Discount(discountedTotal,savings, appliedDiscounts);
		return discount;
	}
	
	/**
	 * Applies discount "Buy two coffees, get a muffin half price
	 * @return savings			Return the amount of money saved 
	 */
	private BigDecimal twoCoffeesHalfMuffin() {
		
		BigDecimal savings = new BigDecimal(0); // New total when applying this discount
		int coffeeCount = 0; // Check how many coffees have been ordered
		boolean muffinOrdered = false; // Check if a muffin has been ordered
		BigDecimal muffinCost = new BigDecimal(0); // Get cost of the muffin
		BigDecimal discountOperator = new BigDecimal(0.5);
		
		for(MenuItem item : orderedItems) {
			if(item.getDescription().equals("Blueberry Muffin")) {
				muffinOrdered = true;
				muffinCost = item.getCost();
			}else if(item.getCategory().equals("Coffee")) {
				coffeeCount++;
			}else if(muffinOrdered && (coffeeCount >= 2)) { // If a muffin and two coffees have been ordered. Apply the discount
				savings = muffinCost.multiply(discountOperator); 
			}
		}
		
		return savings;
	}

	/**
	 * Applies the Discount "Buy two Americanos get a third free"
	 * @param ll				finished LinkedList order
	 * @param total			checkout total
	 * @return				new discounted total
	 */
	private BigDecimal twoAmericanoDiscount() {
		
		BigDecimal savings = new BigDecimal(0);
		int discountedCount = 0;
		BigDecimal itemCost = new  BigDecimal(1);
		
		for(int i = 0; i < orderedItems.size(); i++) {
			if(orderedItems.get(i).getID().equals("COF101")){
				discountedCount++;
				itemCost = orderedItems.get(i).getCost();
			}
		}
		
		// apply buy 2 get 1 free
		if(discountedCount > 2) { // If three Americanos have been ordered apply discount
			savings = itemCost;
			
		}
		return savings;
	}
	
	 
	
}
