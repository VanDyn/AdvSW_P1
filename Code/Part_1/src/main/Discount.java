
package main;

import java.math.BigDecimal;
import java.util.LinkedList;
/**
 * Class for applying discount once customer has hit checkout
 * 
 * @author calumthompson
 *
 */
public class Discount {
	
	Discount(){
		
	}

	/**
	 * Applies the Discount "Buy two Americanos get a third free"
	 * @param ll				finished LinkedList order
	 * @param total			checkout total
	 * @return				new discounted total
	 */
	public BigDecimal twoAmericanoDiscount(LinkedList<MenuItem> ll, BigDecimal total) {
		
		int discountedCount = 0;
		BigDecimal itemCost = new  BigDecimal(1);
		//BigDecimal discountCost = new  BigDecimal(1);
		//BigDecimal itemMultiplier = new BigDecimal(2);
		BigDecimal newTotal = new BigDecimal(0);
		
		for(int i = 0; i < ll.size(); i++) {
			if(ll.get(i).getID().equals("COF101")){
				discountedCount++;
				itemCost = ll.get(i).getCost();
			}
		}
		
		// apply buy 2 get 1 free
		if(discountedCount > 2) {
			newTotal = total.subtract(itemCost);
			return newTotal;
		}
		
		return total;
	}
	
}
