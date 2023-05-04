/**
 * The DiningPhilosophers class simulates the dining philosophers problem with a
 * given problem size.
 */
public class DiningPhilosophers {

    /**
     * The main method of the DiningPhilosophers class. It creates the required
     * number of forks and philosophers and starts the threads for each philosopher
     * to simulate the dining philosophers problem.
     * 
     * @param args The command-line arguments, which are unused in this method.
     * @throws Exception if any exception occurs while executing the code.
     */
    public static void main(String[] args) throws Exception {

        final int problemSize = 5;
        Fork leftFork;
        Fork rightFork;

        Philosopher[] philosophers = new Philosopher[problemSize];
        Fork[] forks = new Fork[problemSize];

        // Creates the required number of forks
        for (int i = 0; i < problemSize; i++) {
            forks[i] = new Fork();
        }

        // Creates the required number of philosophers and starts the threads for each
        // philosopher
        for (int i = 0; i < problemSize; i++) {
            leftFork = forks[i];
            rightFork = forks[(i + 1) % problemSize];

            // The first philosopher should pick up the right fork first to avoid deadlock
            if (i == 0) {
                philosophers[i] = new Philosopher(rightFork, leftFork, i + 1);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork, i + 1);
            }

            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}
