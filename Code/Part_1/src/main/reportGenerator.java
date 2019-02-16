//import java.awt.List;
//import java.io.BufferedWriter;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.Writer;
//import java.lang.reflect.Array;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Map;
//
//public class reportGenerator {
//	
//	private ArrayList<String> reportList = new ArrayList<String>();
//	private Map<Integer,Order> orderList;
//	
//	
//	private String path;
//	
//	/**
//	 * Calls appropriate methods to fill and print an ArrayList to a txt file.
//	 * 
//	 * @param orders			OrdersList object used to store all orders
//	 */
//	reportGenerator(OrderList orders){	
//		
//		orderList = orders.getMap();
//		
//		printOrders();
//		printReport();
//		
//	}
//	
//	/**
//	 * Prints the report to a txt file.
//	 */
//	private void printReport() {
//		
//		Path file = Paths.get("Report.txt");
//		Files.write(file, reportList, Charset.forName("UTF-8"));
//				
//	}
//	
//	/**
//	 * Store the details of each order as a printable string inside ArrayList
//	 */
//	private void printOrders() {
//		
//		for(Map<Integer,Order> orders : orderList.entrySet()) {
//			reportList.add(orders.getDetails());
//		}
//	}
//	
//	private void itemCount() {
//		
//	}
//	
//	
//}
