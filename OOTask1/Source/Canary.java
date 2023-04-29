public class Canary extends Bird { 
  protected String name; 

  public void setName(String aName) { name=aName; } 

  public String getName() { return name; } 

  public String classOfAnimal() { return("Canary"); } 
  
  public boolean canFly() { return true; }
}
