public class Rabbit extends SmallMammal { 
  protected String name; 

  public void setName(String aName) { name=aName; } 

  public String getName() { return name; } 

  public String classOfAnimal() { return("Rabbit"); } 
  
  public boolean canFly() { return false; }
}
