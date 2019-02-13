
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

public class CafeGUI extends JFrame implements ActionListener{

	// This is where the info will be drawn from
	private Menu menu;
	private ArrayList<MenuItem> drinks;
		
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
	
	// booleans to act as checks
	private boolean customerCreated;
	private boolean totalled;
	private boolean cancelled;
	private boolean endOfDay;
		
	// for formatting
	private String format = "%1$10s %2$-60s";
	private String output;
		
	// linked list for order
	private LinkedList<MenuItem> currentOrder;
	
	// To keep track of totals
	private int buttonTotal;
	private int orderTotal;
	private int grandTotal;
	
	
	// Later will be public Cafe2(Menu menu)
	public CafeGUI(){
		
		// booleans
		customerCreated = false;
		totalled = false;
		cancelled = false;
		endOfDay = false;
				
		menu = new Menu();
		drinks = menu.getCategoryMembers("Coffee");
		buttonTotal = drinks.size();
		
		drinksButtons = new JButton[drinks.size()];
		
		// set up window title and ensure program ends on close, create a container and layout
        setTitle("Caffeine Addicts & Co");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container content = getContentPane();
		content.setLayout(new GridLayout(4,1));
		
		// Panel 1
		JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        
        welcome = new JLabel("Welcome to CA & Co");
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setFont(new Font (Font.MONOSPACED, Font.PLAIN,16));
        panel1.add(welcome);        
        newCustomer = new JButton("New Customer");
        panel1.add(newCustomer);
        content.add(panel1);
        
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));
        
        tillDisplay = new JTextArea(15,20);
        tillDisplay.setFont(new Font (Font.MONOSPACED, Font.PLAIN,16));
        tillDisplay.setLineWrap(true);                                    // possibly unnecessary
        tillDisplay.setEditable(false);
        scrollDisplay = new JScrollPane(tillDisplay);
        panel2.add(scrollDisplay);
        content.add(panel2);
        
        // Panel 3
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1,3));
              
        for(counter=0; counter<drinks.size(); counter++){
        	//System.out.println(drinks.get(counter).getDescription());
        	drinksButtons[counter] =  new JButton(drinks.get(counter).getDescription() + "  £" + drinks.get(counter).getCost());
        	drinksButtons[counter].addActionListener(this);
        	panel3.add(drinksButtons[counter]);
        }
        content.add(panel3);
        
        // Panel 4
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2,2));
              
        customerTotal = new JButton("Total");
        panel4.add(customerTotal);        
        cancel = new JButton("Cancel");  
        panel4.add(cancel);          
        dailyTotal = new JButton("Gross");
        panel4.add(dailyTotal);        
        confirm = new JButton("Confirm");  
        panel4.add(confirm);
        content.add(panel4);
        
        // add listeners to the buttons
        newCustomer.addActionListener(this);
        customerTotal.addActionListener(this);
        cancel.addActionListener(this);
        dailyTotal.addActionListener(this);
        confirm.addActionListener(this);
              
        //pack and set visible
        pack();
        setVisible(true);
        
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newCustomer){
			tillDisplay.setText(null);
			
			customerCreated = true;
			tillDisplay.append("        New Customer "+ "");
			currentOrder = new LinkedList<MenuItem>();
			// create a new customer ID and write this to the display
			// throws and error if a customer ID is in use and has not been completed
		}		
		else if (e.getSource() == customerTotal){
			
			totalled = true;
			tillDisplay.append("\n" + "Please confirm that you want to TOTAL this order!");
			// Show total on display
			// Close off the order
			// Throw an error if a new customer has not been created
			// Throw an error if no items have been selected
			
		}
		else if (e.getSource() == cancel){
			
			cancelled = true;
			tillDisplay.append("\n" + "Please confirm that you want to CANCEL this order!");
		}
		else if (e.getSource() == dailyTotal){
			
			endOfDay = true;
			tillDisplay.append("\n" + "Please confirm that you want to CLOSE FOR THE DAY!");
			// Show daily total on display
			// Throw an error if there are no orders 
			
		}
		else if (e.getSource() == confirm){
			
			if((customerCreated = true) && (totalled = true) && (orderTotal > 0)){
				
				tillDisplay.append("\n" + "Order total = " + orderTotal);
				grandTotal = grandTotal + orderTotal;
				orderTotal = 0;
				
				// Add in the create order method here!!
				
				customerCreated = false;
				totalled = false;
				cancelled = false;
				endOfDay = false;
				
			}
			else if((customerCreated = true) && (cancelled = true)){
				
				tillDisplay.append("\n" + "This order has benn Cancelled");
				currentOrder.clear();
				orderTotal = 0;
				
				customerCreated = false;
				totalled = false;
				cancelled = false;
				endOfDay = false;
			}
			else if((grandTotal > 0) && (endOfDay = true)){
				tillDisplay.setText(null);
				
				tillDisplay.setText("\n" + "Todays takings are  £" + grandTotal);
				
				customerCreated = false;
				totalled = false;
				cancelled = false;
				endOfDay = false;
			}
			// HAVING TROUBLE HERE. HOW DO I ITERATE THROUGH THESE DRINK BUTTONS AUTOMATICALLY?
			else{  
				
				for(counter=0; counter<=buttonTotal; counter++){
					if (e.getSource() == drinksButtons[counter]){
						
						output = String.format(format, drinks.get(counter).getDescription(), drinks.get(counter).getCost());
						tillDisplay.append("\n"+ output);
						currentOrder.add(drinks.get(counter));
					}
				}
				
			}
		}
		
		
	}

}

class TestGUI{
	
	public static void main(String[] args){
		
		CafeGUI test = new CafeGUI();
		
		test.setSize(600, 600);
		test.setVisible(true);
		
	}
}
