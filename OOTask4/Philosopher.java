import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
    // The forks on either side of this Philosopher and his/her philosopher number
    private Fork leftFork;
    private Fork rightFork;
    private int philosopherNumber;
    private static Lock forksLock = new ReentrantLock();

    public Philosopher(Fork left, Fork right, int philNumber) {
        leftFork = left;
        rightFork = right;
        philosopherNumber = philNumber;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println("Philosopher number " + philosopherNumber + " time: " + System.nanoTime() + ": " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public void run() {
        try {
            while (true) {
                // thinking
                doAction("Thinking");

                synchronized (forksLock) {
                    if (leftFork.inUse || rightFork.inUse) {
                        return;
                    }

                    doAction("Picking up both forks");
                    leftFork.inUse = rightFork.inUse = true;
                }

                // eating
                doAction("Eating");

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
