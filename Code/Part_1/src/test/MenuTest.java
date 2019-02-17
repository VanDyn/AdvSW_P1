package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		String target = "Americano;2.60;Coffee;COF101";
		
		assertTrue("Returned Item Details", testMenu.newItemDetails(test).equals(target));
		
	}
	
	@Test
	public void shouldReturnArrayOfDetailsofCategory() {
		String testCategory = "Coffee";
		String targetString = "Americano;2.60;Coffee;COF101";
		ArrayList<String> targetResult = new ArrayList<String>();
		targetResult.add("1");
		targetResult.add("1");
		targetResult.add("1");
		
		assertTrue("Returned ArrayList size of correct size", testMenu.getCategoryMembers(testCategory).size() == targetResult.size());
		assertTrue("Returned correct details", (testMenu.getCategoryDetails(testCategory).get(0)).equals(targetString));
		
	}
	
	@Test
	public void shouldReturnArrayOfItemsInCategory() {
		String testCategory = "Coffee";
		String targetString = "Americano;2.60;Coffee;COF101";
		ArrayList<String> targetResult = new ArrayList<String>();
		targetResult.add("1");
		targetResult.add("1");
		targetResult.add("1");
		
		//String a = testMenu.itemDetails((testMenu.getCategoryMembers(testCategory)).get(1));
		
		assertTrue("Returned ArrayList size of correct size", testMenu.getCategoryMembers(testCategory).size() == targetResult.size());
		assertTrue("Returned correct details", testMenu.itemDetails((testMenu.getCategoryMembers(testCategory)).get(1)).equals(targetString));
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


