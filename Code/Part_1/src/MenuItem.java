/*****
Class for holding data concerning menu items

Contains id String, float cost and description String.

*****/
public class MenuItem {

  private String id;
  private String category;
  private float cost;
  private String description;

  // 
  MenuItem(String id, String category, float cost, String description){
    this.id = id;
    this.cost = cost;
    this.description = description;

  }

  public String getID(){
    return id;
  }

  public float getCost(){
    return cost;
  }

  public String getDescription(){
    return description;
  }

}
