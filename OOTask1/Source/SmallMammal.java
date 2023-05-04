/**
 * The SmallMammal class represents a generic small mammal pet. It is an
 * abstract
 * class that extends the Pet class and implements the abstract canFly method
 * by always returning false.
 */
public abstract class SmallMammal extends Pet {
    /**
     * Implements the abstract canFly method declared in the Pet class to
     * indicate that all SmallMammal objects cannot fly.
     * 
     * @return false, since all SmallMammal objects of the SmallMammal class
     *         cannot fly.
     */
    public boolean canFly() {
        return false;
    }
}
