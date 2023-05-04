import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The Philosopher class represents a philosopher in the dining philosophers
 * problem. Each philosopher has a left fork and a right fork, and a unique
 * number assigned to them. Implements the Runnable interface to enable
 * multithreading.
 */
public class Philosopher implements Runnable {
    // The forks on either side of this Philosopher and his/her philosopher number
    private Fork leftFork;
    private Fork rightFork;
    private int philosopherNumber;
    private static Lock forksLock = new ReentrantLock(); // A static Lock object used to ensure synchronized access to
                                                         // forks

    /**
     * Constructs a new Philosopher object with the given left and right forks and
     * philosopher number.
     * 
     * @param left       The fork to the left of this philosopher.
     * @param right      The fork to the right of this philosopher.
     * @param philNumber The unique number assigned to this philosopher.
     */
    public Philosopher(Fork left, Fork right, int philNumber) {
        leftFork = left;
        rightFork = right;
        philosopherNumber = philNumber;
    }

    /**
     * Executes a given action and prints it along with the philosopher number and
     * the time at which the action occurred. Also pauses the thread for a random
     * amount of time (up to 100ms).
     * 
     * @param action The action to be executed by the philosopher.
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    private void doAction(String action) throws InterruptedException {
        System.out.println("Philosopher number " + philosopherNumber + " time: " + System.nanoTime() + ": " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    /**
     * Continuously runs the philosopher thread. While running the philosopher will
     * alternate between thinking and eating.
     * 
     * This implementation prevents deadlocking by using a static Lock object to
     * synchronize access to the forks. When a philosopher wants to pick up both
     * forks, it first acquires the lock. It then checks if both forks are
     * available, and if so, picks them both up. After the philosopher is done
     * eating, it puts down both forks and releases the lock.
     */
    public void run() {
        try {
            while (true) {
                // Thinking
                doAction("Thinking");

                synchronized (forksLock) {
                    // If either fork is in use, return and release the lock
                    if (leftFork.inUse || rightFork.inUse) {
                        return;
                    }

                    doAction("Picking up both forks");
                    leftFork.inUse = rightFork.inUse = true;
                }

                // Eating
                doAction("Eating");

                /*
                 * Synchronized so a philosopher can't execute the first lock inbetween leftFork
                 * being set to false and rightFork being set to false. Although not explicitly
                 * mentioned in the pro-forma, not locking this assignment could lead to a
                 * philospher acquiring the first lock when only one fork has been put down by
                 * the philosopher instead of both.
                 */
                synchronized (forksLock) {
                    // Back to thinking
                    doAction("Putting down both forks");
                    leftFork.inUse = rightFork.inUse = false;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
