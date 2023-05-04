/**
 * The Bird class represents a generic bird pet. It is an abstract class
 * that extends the Pet class and implements the abstract canFly method
 * by always returning true.
 */
public abstract class Bird extends Pet {
    /**
     * Implements the abstract canFly method declared in the Pet class to
     * indicate that all Bird objects can fly.
     * 
     * @return true, since all Bird objects of the Bird class can fly.
     */
    public boolean canFly() {
        return true;
    }
}
