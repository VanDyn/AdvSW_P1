package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import main.Menu;


public class MenuTest {

	public Menu testMenu;

	
	
	@Before
	public void setup() {

		 testMenu =  new Menu("exampleMenu.txt");
		 assertTrue("Size equals 3",testMenu.getMenuSize() == 3);

	}
	
	
	@Test
	public void shouldReturnStringOfItemDetails() {
		testMenu = new Menu("exampleMenu.txt");
		
		String test = "Americano";
		String target = "Americano;2.6;Coffee;COF101";
		
		assertTrue("Returned Item Details", testMenu.newItemDetails(test).equals(target));
		
	}
	
	@Test
	public void shouldReturnArrayOfDetailsofCategory() {
		
	}
	
	@Test
	public void shouldReturnArrayOfItemsInCategory() {
		
	}
	
	@Test
	public void shouldReturnBoolIfItemInMenu() {
		
	}
	
	@Test
	public void shouldReturnAllDetailsOfSpecifiedItem() {
		
	}
	
	@Test
	public void shouldReturnCostOfItem() {
		
	}

}


