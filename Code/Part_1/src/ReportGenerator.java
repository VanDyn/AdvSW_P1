import java.io.*;
import java.util.Date;


public class ReportGenerator {

  DateFormat dateFormat;


  ReportGenerator(){
// Set format for report date here. Possibly unnecessary
    dateFormat = new SimpleDateFormat("HH-mm-dd-MM-yy");
  }

  public void generateReport(Map<Integer, Order> ol, Set<String, MenuItem> menu){

    // Filewriter for writing to txt file
    FileOutputStream fos;

    try {
      // build filename in format reportHH-mm-dd-MM-yy.txt
      String fileName = String.format("report%s.txt", dateFormat.format( new Date() ));

      fos = new FileOutputStream(fileName);
      // Specification states report should be 'all items in a menu, quantity sold and total earnings
      // So menu access required. As class only implements single method this may be better in coffee shop.'


      for (MenuItem m: menu.values()){

      }

      // Will need to create collection containing all menu items

      for (Order o: ol.values()){
        // check items against menu and keep running total of earnings

      }

      // Final section that writes to file

    } catch (IOException e){

    }
  }

}
