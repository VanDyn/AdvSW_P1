package main;

import java.math.BigDecimal;
import java.util.LinkedList;

public class CoffeeShop {

	public static void main(String[] args) throws NotOnMenuException {
		// TODO Auto-generated method stub
		BigDecimal total = new BigDecimal(0);
		
		
		Menu menu = new Menu("exampleMenu");
		
		LinkedList<MenuItem> item = new LinkedList<MenuItem>();
		
		item.add(menu.getItem("Americano"));
		total = total.add(menu.getItemCost("Americano"));
		item.add(menu.getItem("Americano"));
		total = total.add(menu.getItemCost("Americano"));
		item.add(menu.getItem("Blueberry Muffin"));
		total = total.add(menu.getItemCost("Blueberry Muffin"));
		
		ApplyDiscount d = new ApplyDiscount(item,total);
		Discount discount = d.checkForDiscounts();
		
		System.out.println("Starting Total: £" + total + "\nNew Total: £" + discount.getNewTotal());
		
	}

}
