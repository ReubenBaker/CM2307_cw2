/**
 * The abstract Pet class represents a generic pet.
 */
public abstract class Pet {
    private String name;

    /**
     * Sets the name of the pet.
     * 
     * @param aName The name to set for the pet.
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Gets the name of the pet.
     * 
     * @return The name of the pet.
     */
    public String getName() {
        return name;
    }

    /**
     * Determines if the pet can fly.
     * 
     * @return true if the pet can fly, otherwise false.
     */
    public abstract boolean canFly();

    /**
     * Gets the class of animal that the pet belongs to.
     * 
     * @return The class of animal as a String.
     */
    public abstract String classOfAnimal();
}
