import java.io.*;
import java.math.BigDecimal;
import java.text.*;
import java.util.*;


public class ReportGenerator {

  DateFormat dateFormat;


  ReportGenerator(){
// Set format for report date here. Possibly unnecessary
    dateFormat = new SimpleDateFormat("HH-mm-dd-MM-yy");
  }

  public void generateReport(Map<Integer, Order> ol, HashSet<MenuItem> menu){

    // Filewriter for writing to txt file
    DataOutputStream dos;
    
    try {
      
      BigDecimal total = BigDecimal.ZERO;
      
      // Specification states report should be 'all items in a menu, quantity sold and total earnings
      // So menu access required. As class only implements single method this may be better in coffee shop.'


      // Will need to create collection containing all menu items

      ArrayList<ItemSaleTracker> items = new ArrayList<ItemSaleTracker>();

      Iterator<MenuItem> menuIterator = menu.iterator();
      
      while(menuIterator.hasNext()){
        items.add(new ItemSaleTracker(menuIterator.next()));
      }

      for (Order o: ol.values()){
        // check items against menu and keep running total of earnings
        ListIterator<MenuItem> orderItems = o.getItemList().listIterator();
        while(orderItems.hasNext()){
        	int i;
        	boolean found = false;
        	
        	// Need to look through Pairs, find item corresponding to one in order
        	// then increment quantity
        	for (i = 0; found != true; i++) {
        		ItemSaleTracker itemST = items.get(i);
        		if (orderItems.next() == itemST.getItem()) {
        			items.get(i).incByOne();
        			found = true;
        		}
        	}
        	total = total.add(o.getOrderTotal);
        }
      }

      // Final section that writes to file
      // build filename in format log-HH-mm-dd-MM-yy.txt
      String dateString = dateFormat.format( new Date() );
      String fileName = String.format( "log-%s.txt", dateString );
      File logFile = new File(fileName);
      
      dos = new DataOutputStream( new FileOutputStream( logFile ) );
      
      // Title for file
      dos.writeUTF( String.format( "Log File for %s", dateString ) );
      
      
      Iterator<ItemSaleTracker> allItemPairs = items.listIterator();
      while (allItemPairs.hasNext()) {
    	  // Write item ID, description and quantity ordered to file
    	  ItemSaleTracker thisItemPair = allItemPairs.next();
    	  dos.writeUTF(String.format("%s1 %s2 %d", thisItemPair.getItem().getID(), 
    			  thisItemPair.getItem().getDescription(), thisItemPair.getQuantity()));
      }
      // List total income
      
      dos.writeUTF(String.format("Total Daily Earnings: %s", total.toString()));
      
      // close dataStream
      dos.close();
      
    } catch (IOException e){
    	System.out.println("Exception");
    }
  }

  public class ItemSaleTracker{
    MenuItem item;
    int quantity;

    public ItemSaleTracker(MenuItem item) {
      this.item = item;
      quantity = 0;
    }

    public void setItem(MenuItem item){
      this.item = item;
    }

    public void setQuantity(int quantity){
      this.quantity = quantity;
    }
    
    public void incByOne() {
    	quantity += 1;
    }

    public MenuItem getItem(){
      return item;
    }

    public int getQuantity(){
      return quantity;
    }

  }


}
