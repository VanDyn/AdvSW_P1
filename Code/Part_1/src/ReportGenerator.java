import java.io.*;
import java.util.Date;


public class ReportGenerator {

  DateFormat dateFormat;


  ReportGenerator(){
// Set format for report date here. Possibly unnecessary
    dateFormat = new SimpleDateFormat("HH-mm-dd-MM-yy");
  }

  public void generateReport(Map<Integer, Order> ol){

    // Filewriter for writing to txt file
    Filewriter fw

    try {
      // build filename in format reportHH-mm-dd-MM-yy.txt
      String fileName = String.format("report%s.txt", dateFormat.format( new Date() ));

      // Specification states report should be 'all items in a menu, quantity sold and total earnings
      // So menu access required. As class only implements single method this may be better in coffee shop.'
      // Menu m = CoffeeShop.getMenu()
      Object placeholderMenu();
      


      for (Order o: ol.values()){
        // check items against menu and keep running total of earnings

    }
  }
  }

}
