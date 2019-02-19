package main;
// Import all Java GUI classes
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

/**
 * Class which will implement the GUI for the coffee shop.
 * 
 * @author ShayneShaw
 *
 */

public class CafeGUI extends JFrame implements ActionListener {

	// This is where the info will be drawn from
	private Menu menu;
	private ArrayList<MenuItem> drinks;
	// ADD MORE ARRAYS HERE

	// Buttons and fields for Panel 1
	private JButton newCustomer;
	private JLabel welcome;

	// The main display, Panel 2
	private JTextArea tillDisplay;
	private JScrollPane scrollDisplay;

	// Buttons for the Panel 3
	private JButton[] drinksButtons;

	// Admin buttons for Panel 4
	JButton customerTotal, cancel, confirm, dailyTotal;

	// to be used to assign customer number.
	int counter;

	// Booleans to act as checks
	private boolean customerCreated;
	private boolean totalled;
	private boolean cancelled;
	private boolean endOfDay;

	// For formatting
	private String format = "%1$10s %2$-60s";
	private String output;

	// Linked list for order
	private LinkedList<MenuItem> currentOrder;

	// To keep track of totals
	private BigDecimal orderTotal;
	private BigDecimal grandTotal;
	private BigDecimal zero;

	/**
	 * Constructor which will initialise the GUI container and populate both it and the JPanels
	 * with buttons and text areas.
	 * 
	 * @param foodlist - a text file containing the items on the menu
	 * 
	 */
	public CafeGUI(Menu foodlist) {
		
		orderTotal = new BigDecimal(0);
		orderTotal.setScale(2,BigDecimal.ROUND_DOWN);
		grandTotal = new BigDecimal(0);
		grandTotal.setScale(2,BigDecimal.ROUND_DOWN);
		zero = new BigDecimal(0);
		zero.setScale(2,BigDecimal.ROUND_DOWN);
		//orderTotal.setScale(2,BigDecimal.ROUND_DOWN);
		//grandTotal.setScale(2,BigDecimal.ROUND_DOWN);
		
		// Booleans
		customerCreated = false;
		totalled = false;
		cancelled = false;
		endOfDay = false;

		menu = foodlist;
		drinks = menu.getCategoryMembers("Coffee");
		// ADD MORE ARRAYS HERE

		drinksButtons = new JButton[drinks.size()];

		// Set up window title and ensure program ends on close, create a
		// container and layout
		setTitle("Caffeine Addicts & Co");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container content = getContentPane();
		content.setLayout(new GridLayout(4, 1));

		// Panel 1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2));

		welcome = new JLabel("Welcome to CA & Co");
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		panel1.add(welcome);
		newCustomer = new JButton("New Customer");
		panel1.add(newCustomer);
		content.add(panel1);

		// Panel 2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 1));

		tillDisplay = new JTextArea(15, 20);
		tillDisplay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		tillDisplay.setLineWrap(true); // possibly unnecessary
		tillDisplay.setEditable(false);
		scrollDisplay = new JScrollPane(tillDisplay);
		panel2.add(scrollDisplay);
		content.add(panel2);

		// Panel 3
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 3));

		for (counter = 0; counter < drinks.size(); counter++) {
			
			drinksButtons[counter] = new JButton(drinks.get(counter).getDescription()); 																																																																																								
			drinksButtons[counter].addActionListener(this);
			panel3.add(drinksButtons[counter]);
		}
		content.add(panel3);

		// Panel 4
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(2, 2));

		customerTotal = new JButton("Total");
		panel4.add(customerTotal);
		cancel = new JButton("Cancel");
		panel4.add(cancel);
		dailyTotal = new JButton("Gross");
		panel4.add(dailyTotal);
		confirm = new JButton("Confirm");
		panel4.add(confirm);
		content.add(panel4);

		// Add listeners to the buttons
		newCustomer.addActionListener(this);
		customerTotal.addActionListener(this);
		cancel.addActionListener(this);
		dailyTotal.addActionListener(this);
		confirm.addActionListener(this);

		// Pack and set visible
		pack();
		setVisible(true);

	}

	/**
	 * Determines the appropriate action for the GUI when any button is pressed.
	 *  
	 * @param ActionEvent
	 * 
	 */
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getActionCommand());

		if (e.getSource() == newCustomer) {
			tillDisplay.setText(null);

			customerCreated = true;
			tillDisplay.append("        New Customer " + "");
			currentOrder = new LinkedList<MenuItem>();
			
		} else if (e.getSource() == customerTotal) {

			totalled = true;
			tillDisplay.append("\n" + "Please confirm that you want to TOTAL this order!");
			

		} else if (e.getSource() == cancel) {

			cancelled = true;
			tillDisplay.append("\n" + "Please confirm that you want to CANCEL this order!");

		} else if (e.getSource() == dailyTotal) {

			endOfDay = true;
			tillDisplay.append("\n" + "Please confirm that you want to CLOSE FOR THE DAY!");
			

		} else if (e.getSource() == confirm) {

			if ((customerCreated == true) && (totalled == true) && (orderTotal.compareTo(zero) > 0)) {

				tillDisplay.append("\n" + "Order total = £" + orderTotal);
				grandTotal = grandTotal.add(orderTotal);
				orderTotal = zero;

				// ADD THE ORDER METHOD HERE!!
				CoffeeShop.createOrder(currentOrder);
				
				currentOrder.clear();       
				customerCreated = false;
				totalled = false;
				cancelled = false;
				endOfDay = false;

			} else if ((customerCreated == true) && (cancelled == true)) {

				tillDisplay.append("\n" + "This order has benn Cancelled");
				currentOrder.clear();
				orderTotal = zero;

				customerCreated = false;
				totalled = false;
				cancelled = false;
				endOfDay = false;
				
				
			} else if ((grandTotal.compareTo(zero) > 0) && (endOfDay == true)) {
				tillDisplay.setText(null);

				tillDisplay.setText("\n" + "Todays takings are  £" + grandTotal);

				customerCreated = false;
				totalled = false;
				cancelled = false;
				endOfDay = false;
			}
			
		} else {
			
			output = String.format(format, e.getActionCommand(), menu.getItemCost(e.getActionCommand()));
			tillDisplay.append("\n" + output);
			currentOrder.add(menu.getItem(e.getActionCommand()));
			orderTotal = orderTotal.add(menu.getItemCost(e.getActionCommand()));
			System.out.println(orderTotal);

		}

	}

}
