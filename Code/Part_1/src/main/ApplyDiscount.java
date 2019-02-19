
package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Class for applying discount once customer has hit checkout.
 * To use:
 * 			> Create ApplyDiscount object, using the order LinkedList and order total as constructor arguments.
 * 			> Call method checkForDiscounts() which returns an object of type Discount.
 * 			> Discount object contains - the discounted total, customer savings, and the discounts applied.
 * 		
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
		
		savings = savings.add(twoAmericanoDiscount());
		savings = savings.add(twoCoffeesHalfPriceMuffin());
		
		discountedTotal = currentTotal.subtract(savings);
		
		
		Discount discount = new Discount(discountedTotal,savings, appliedDiscounts);
		return discount;
	}
	
	/*
	 * Return an ArrayList with all available discounts.
	 */
	public ArrayList<String> getAvailableDiscounts(){
		ArrayList<String> availableDiscounts = new ArrayList<String>();
		availableDiscounts.add("Buy two Americanos get a third free");
		availableDiscounts.add("Buy any two coffees get a free Blueberry muffin");
		
		return availableDiscounts;
	}
	
	/**
	 * Applies discount "Buy two coffees, get a muffin half price
	 * @return savings			Return the amount of money saved 
	 */
	private BigDecimal twoCoffeesHalfPriceMuffin() {
		
		BigDecimal savings = new BigDecimal(0); // New total when applying this discount
		int coffeeCount = 0; // Check how many coffees have been ordered
		boolean muffinOrdered = false; // Check if a muffin has been ordered
		BigDecimal muffinCost = new BigDecimal(0); // Get cost of the muffin
		BigDecimal discountOperator = new BigDecimal(0.5);
		
		for(MenuItem item : orderedItems) {
			if(item.getDescription().equals("Blueberry Muffin") && muffinOrdered == false) {
				muffinOrdered = true;
				muffinCost = item.getCost();
			}else if(item.getCategory().equals("Coffee")) {
				coffeeCount++;
			} if(muffinOrdered && (coffeeCount > 1)) { // If a muffin and two coffees have been ordered. Apply the discount
				savings = muffinCost.multiply(discountOperator); 
				appliedDiscounts.add("Buy two coffees get a free muffin");
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
				appliedDiscounts.add("Buy two Americanos get a third free");
			}
		}
		
		// apply buy 2 get 1 free
		if(discountedCount > 2) { // If three Americanos have been ordered apply discount
			savings = itemCost;
			
		}
		return savings;
	}
	
	/**
	 * Apply meal deal. Get and sandwich, drink, and baked good for £6
	 * @return
	 */
	private BigDecimal mealDeal() {
		
		int sandwichCount = 0;
		int drinkCount = 0;
		int bakeryCount = 0;
		
		BigDecimal mealDealCost = new BigDecimal(0);
		
		for(MenuItem item : orderedItems) {
			switch(item.getCategory()) {
			case "Sandwich" :
				sandwichCount++;
			case "Coffee" :
				drinkCount++;
			case "Tea" :
				drinkCount++;
			case "Bakery" :
				drinkCount++;
			}
		}
		
		
		
		return null;
	}
	
	 
	
}
