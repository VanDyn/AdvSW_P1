package orderList;
/*****
Class for holding data concerning menu items
Contains id String, float cost and description String.
*****/
public class MenuItem {

  private String id;
  private double cost;
  private String description;
  private String category; 

  //id and category in all caps
  MenuItem(String id, double cost, String description, String category){
    this.id = id;
    this.cost = cost;
    this.description = description;
    this.category = category;
  }

  public String getID(){
    return id;
  }

  public double getCost(){
    return cost;
  }

  public String getDescription(){
    return description;
  }
  
  public String getCategory() {
	  return category;
  }

}