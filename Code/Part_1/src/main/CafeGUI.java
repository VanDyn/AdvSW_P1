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
	private ArrayList<MenuItem> products;

	// Buttons and fields for Panel 1
	private JButton newCustomer;
	private JLabel welcome;

	// The main display, Panel 2
	private JTextArea tillDisplay;
	private JScrollPane scrollDisplay;

	// Buttons for the Panel 3
	private JButton[] productButtons;

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
	 * Constructor which will initialise the GUI container and populate both it
	 * and the JPanels with buttons and text areas.
	 * 
	 * @param foodlist
	 *            - a text file containing the items on the menu
	 * @throws NotOnMenuException
	 * 
	 */
	public CafeGUI(Menu foodlist) throws NotOnMenuException, CreateNewCustomerException {

		orderTotal = new BigDecimal(0);
		orderTotal.setScale(2, BigDecimal.ROUND_DOWN);
		grandTotal = new BigDecimal(0);
		grandTotal.setScale(2, BigDecimal.ROUND_DOWN);
		zero = new BigDecimal(0);
		zero.setScale(2, BigDecimal.ROUND_DOWN);
		// orderTotal.setScale(2,BigDecimal.ROUND_DOWN);
		// grandTotal.setScale(2,BigDecimal.ROUND_DOWN);

		// Booleans
		customerCreated = false;
		totalled = false;
		cancelled = false;
		endOfDay = false;

		menu = foodlist;
		products = menu.getCategoryMembers("Coffee");
		products.addAll(menu.getCategoryMembers("Tea"));
		products.addAll(menu.getCategoryMembers("Sandwich"));
		products.addAll(menu.getCategoryMembers("Bakery"));

		productButtons = new JButton[products.size()];

		// Set up window title and ensure program ends on close, create a
		// container and layout
		setTitle("Caffeine Addicts & Co");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container content = getContentPane();
		content.setLayout(new GridLayout(4, 1));

		// Panel 1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2));

		welcome = new JLabel("Caffeine Addicts & Co");
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
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
		panel3.setLayout(new GridLayout(4, 3));

		for (counter = 0; counter < products.size(); counter++) {

			productButtons[counter] = new JButton(products.get(counter).getDescription());
			productButtons[counter].addActionListener(this);
			panel3.add(productButtons[counter]);
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

		// System.out.println(e.getActionCommand());

		if (e.getSource() == newCustomer) {

			try {
				createNewCustomer();
			} catch (OrderNotClosedException e1) {

				e1.printStackTrace();
				tillDisplay.append("\n" + "Please close the current order first!");
			}

		} else if (e.getSource() == customerTotal) {

			try {
				setOrderTotalFlag();
			} catch (SelectProductException e1) {

				e1.printStackTrace();
				tillDisplay.append("\n" + "Please select a product first!");

			}

		} else if (e.getSource() == cancel) {

			try {
				setCancelOrderFlag();
			} catch (SelectProductException e1) {

				e1.printStackTrace();
				tillDisplay.append("\n" + "Please select a product first!");
			}

		} else if (e.getSource() == dailyTotal) {

			try {
				setGrandTotalFlag();
			} catch (NoOrdersPlacedException e1) {

				e1.printStackTrace();
				tillDisplay.setText("No orders have been placed today!");
			}

		} else if (e.getSource() == confirm) {
			try {
				confirmOrder(e);
			} catch (SelectFunctionException e1) {
				e1.printStackTrace();
				tillDisplay.append("\n" + "Please select a funtion first! Total, Cancel or Gross");
			}

		} else {
			try {
				selectProduct(e);
			} catch (CreateNewCustomerException e1) {
				e1.printStackTrace();
				tillDisplay.setText("Please create a new customer first!");
			}

		}

	}

	private void createNewCustomer() throws OrderNotClosedException {

		if (customerCreated == false) {
			tillDisplay.setText(null);
			customerCreated = true;
			tillDisplay.append("        New Customer " + "");
			currentOrder = new LinkedList<MenuItem>();
		} else {
			throw new OrderNotClosedException();
		}
	}

	private void setOrderTotalFlag() throws SelectProductException {

		if (orderTotal.compareTo(zero) > 0) {
			totalled = true;
			tillDisplay.append("\n" + "Please confirm that you want to TOTAL this order!");
		} else {
			throw new SelectProductException();
		}
	}

	private void setCancelOrderFlag() throws SelectProductException {
		if (orderTotal.compareTo(zero) > 0) {
			cancelled = true;
			tillDisplay.append("\n" + "Please confirm that you want to CANCEL this order!");
		} else {
			throw new SelectProductException();
		}

	}

	private void setGrandTotalFlag() throws NoOrdersPlacedException {
		if (grandTotal.compareTo(zero) > 0) {
			endOfDay = true;
			tillDisplay.append("\n" + "Please confirm that you want to CLOSE FOR THE DAY!");

		} else {
			throw new NoOrdersPlacedException();
		}

	}

	private void confirmOrder(ActionEvent e) throws SelectFunctionException {
		if (totalled == true || cancelled == true || endOfDay == true) {

			if ((customerCreated == true) && (totalled == true) && (orderTotal.compareTo(zero) > 0)) {

				tillDisplay.append("\n" + "Order total = �" + orderTotal);
				grandTotal = grandTotal.add(orderTotal);
				orderTotal = zero;

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

				tillDisplay.setText("\n" + "Todays takings are  �" + grandTotal);

				customerCreated = false;
				totalled = false;
				cancelled = false;
				endOfDay = false;
			}
		} else {
			throw new SelectFunctionException();
		}
	}

	private void selectProduct(ActionEvent e) throws CreateNewCustomerException {
		if (customerCreated == true) {
			try {
				output = String.format(format, e.getActionCommand(), menu.getItemCost(e.getActionCommand()));
				tillDisplay.append("\n" + output);
				currentOrder.add(menu.getItem(e.getActionCommand()));
				orderTotal = orderTotal.add(menu.getItemCost(e.getActionCommand()));
			} catch (NotOnMenuException e1) {

				e1.printStackTrace();
			}
		} else {
			throw new CreateNewCustomerException();
		}

	}

}
