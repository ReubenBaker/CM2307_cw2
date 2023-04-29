public class Client {
  public static void main(String[] args) {
    Chinchilla c = new Chinchilla();
    c.setName("Killa Chinchilla");
    System.out.print("The " + c.classOfAnimal() + "'s name is " + c.getName());
    if (c.canFly())
      System.out.println(" and it *can* fly");
    else
      System.out.println(" and it *cannot* fly");

    ZebraFinch z = new ZebraFinch();
    z.setName("Cheep and Cheerful");
    System.out.print("The " + z.classOfAnimal() + "'s name is " + z.getName());
    if (z.canFly())
      System.out.println(" and it *can* fly");
    else
      System.out.println(" and it *cannot* fly");


    Rabbit r = new Rabbit();
    r.setName("Bugs Bunny");
    System.out.print("The " + r.classOfAnimal() + "'s name is " + r.getName());
    if (r.canFly())
      System.out.println(" and it *can* fly");
    else
      System.out.println(" and it *cannot* fly");
      
    Canary ca = new Canary();
    ca.setName("Cheep and Tuneful");
    System.out.print("The " + ca.classOfAnimal() + "'s name is " + ca.getName());
    if (ca.canFly())
      System.out.println(" and it *can* fly");
    else
      System.out.println(" and it *cannot* fly");
  }
 
}
