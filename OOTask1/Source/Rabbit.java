/**
 * The Rabbit class represents a specific type of bird pet, namely a rabbit. It
 * extends the SmallMammal class and implements the abstract classOfAnimal
 * method by returning the name of the class as a String.
 */
public class Rabbit extends SmallMammal {
  /**
   * Implements the abstract classOfAnimal method declared in the Pet class to
   * return the name of the animal class as a String.
   * 
   * @return The name of the animal class as a String.
   */
  public String classOfAnimal() {
    return ("Rabbit");
  }
}
