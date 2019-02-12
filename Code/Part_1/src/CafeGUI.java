
// Import all Java GUI classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CafeGUI extends JFrame implements ActionListener{

	// This is where the info will be drawn from
	private Menu menu;
	
	// Buttons and fields for the top panel
	JButton newCustomer, search;
	JTextField searchCustomer;
	
	// The main display (middle panel)
	JTextArea tillDisplay;
	JScrollPane scrollDisplay;
	
	// Buttons for the bottom panel
	JButton espresso, americano, cappuccino, latte, customerTotal, dailyTotal;
	
	// to be used to assign customer number.
	int counter;
	// boolean to make sure that a new customer has been created for each order.
	private boolean customerCreated;
	
	// Later will be public CafeGUI(Menu menu)
	public CafeGUI(){
		
		this.menu = menu;
		customerCreated = false;
		
		// set up window title and ensure program ends on close
        setTitle("Caffeine Addicts & Co");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create a container
		Container content = getContentPane();
		
		// Set the layout
		content.setLayout(new BorderLayout());
		
		
		// TOP PANEL contains button, button, text field
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,3));
        topPanel.setBackground(Color.blue);
        
        newCustomer = new JButton("New Customer");
        topPanel.add(newCustomer);
        
        searchCustomer = new JTextField(20);
        topPanel.add(searchCustomer);   
        
        search = new JButton("Search");  
        topPanel.add(search);  
             
        // add listeners to the buttons
        newCustomer.addActionListener(this) ;
        search.addActionListener(this) ;
		  
        // add topPanel to the content pane      
        content.add(topPanel, BorderLayout.NORTH);
        
        
        // MAIN DISPLAY contains JTextArea
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(1,1));
        middlePanel.setBackground(Color.green);
        
        tillDisplay = new JTextArea(15,20);
        tillDisplay.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
        tillDisplay.setLineWrap(true);
        tillDisplay.setEditable(false);
        scrollDisplay = new JScrollPane(tillDisplay);
        middlePanel.add(scrollDisplay);
        
        content.add(middlePanel, BorderLayout.CENTER);
        
        
        // BOTTOM PANEL contains button, button, text field
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,3));
        bottomPanel.setBackground(Color.yellow);
        
        espresso = new JButton("Espresso");
        bottomPanel.add(espresso);
        
        americano = new JButton("Americano");  
        bottomPanel.add(americano);  
        
        cappuccino = new JButton("Cappuccino");
        bottomPanel.add(cappuccino);
        
        latte = new JButton("Latte");  
        bottomPanel.add(latte);  
        
        customerTotal = new JButton("Total");
        bottomPanel.add(customerTotal);
        
        dailyTotal = new JButton("Gross");  
        bottomPanel.add(dailyTotal);  
                
        // add listeners to the buttons
        espresso.addActionListener(this);
        americano.addActionListener(this);
        cappuccino.addActionListener(this);
        latte.addActionListener(this);
        customerTotal.addActionListener(this);
        dailyTotal.addActionListener(this);
        
        // add bottomPanle to the content pane      
        content.add(bottomPanel, BorderLayout.SOUTH);
        
        
        //pack and set visible
        pack();
        setVisible(true);
        
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newCustomer){
			
			tillDisplay.append("        New Customer "+ "");
			// create a new customer ID and write this to the display
			// throws and error if a customer ID is in use and has not been completed
		}
		else if (e.getSource() == search){
			
			// look up a customer number and write their order to the display
			// throws an error if 
			
		}
		else if (e.getSource() == espresso){
			
			tillDisplay.append("\n" + "   Espresso");
			// add an espresso to the customers order
			// throw an error if no customer is selected
			// throw and error if it is a customer whose order has already been totalled
			
		}
		else if (e.getSource() == americano){
			
			tillDisplay.append("\n"+"   Americano");
			// as above
			
		}
		else if (e.getSource() == cappuccino){
			
			tillDisplay.append("\n"+"   Cappuccino");
			// as above
			
		}
		else if (e.getSource() == latte){
			
			tillDisplay.append("\n"+"   Latte");
			// as above
			
		}
		else if (e.getSource() == customerTotal){
			
			// Show total on display
			// Close off the order
			// Throw an error if a new customer has not been created
			// Throw an error if no items have been selected
			
		}
		else if (e.getSource() == dailyTotal){
			
			// Show daily total on display
			// Throw an error if there are no orders 
			
		}
		
		
	}

	//System.out.println("Hello");
}

class TestGUI{
	
	public static void main(String[] args){
		
		CafeGUI test = new CafeGUI();
		
		test.setSize(600, 600);
		test.setVisible(true);
		
	}
}
