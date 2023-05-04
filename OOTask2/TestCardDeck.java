import java.util.ArrayList;

/**
 * The TestCardDeck class provides a way to test the thread safety of the
 * CardDeck class by creating multiple threads that each deal two cards from the
 * deck. The expected result is that the total number of cards dealt equals
 * twice the number of threads, and if this is not the case after running the
 * specified number of cycles, the CardDeck is deemed not thread safe.
 */
public class TestCardDeck {
    /**
     * Creates a new CardDeck object to be used in the test.
     * 
     * @return a new CardDeck object.
     */
    protected CardDeck createDeck() {
        return new CardDeck();
    }

    /**
     * Runs the test for a specified number of threads, and returns a boolean
     * indicating whether or not the CardDeck is thread safe.
     * 
     * @param threadCount the number of threads to use in the test.
     * @return a boolean indicating whether or not the CardDeck is thread safe.
     * @throws InterruptedException if any thread is interrupted.
     */
    public boolean runThreads(int threadCount) throws InterruptedException {
        CardDeck deck = createDeck();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                deck.dealCard();

                try {
                    Thread.sleep((long) Math.random() * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                deck.dealCard();
            });

            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return deck.sequenceNumber == threadCount * 2;
    }

    /**
     * Executes the test with the specified command-line arguments or default
     * values, and returns an integer indicating the number of times the test
     * failed.
     * 
     * @param args the command-line arguments, which should be integers indicating
     *             the number of threads and cycles to use in the test,
     *             respectiviely.
     * @return an integer indicating the number of times the test failed.
     * @throws InterruptedException if any thread is interrupted.
     */
    public int execute(String[] args) throws InterruptedException {
        // Default values for threadCount and cycleCount if no command-line arguments
        // are provided.
        int threadCount = 26;
        int cycleCount = 1000;
        int failedCount = 0;

        if (args.length == 2) {
            try {
                threadCount = Integer.parseInt(args[0]);
                cycleCount = Integer.parseInt(args[1]);

                if (threadCount < 1 || threadCount > 26) {
                    System.out.println("Thread count must be between 1 and 26!");
                    return -1;
                }

                if (cycleCount < 1) {
                    System.out.println("Cycle count must be at least 1!");
                    return -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Args invalid! Thread count and Cycle count must both be integers!");
                return -1;
            }
        }

        System.out.println("Number of Threads: " + threadCount);
        System.out.println("Number of Cycles: " + cycleCount + "\n");

        for (int i = 0; i < cycleCount; i++) {
            if (!runThreads(threadCount)) {
                failedCount++;
            }

            if ((i + 1) % Math.max(cycleCount / 100, 1) == 0) {
                System.out.print("\033[2K\r");
                System.out.print((int) Math.round(((double) (i + 1) / cycleCount) * 100) + "%");
            }
        }

        System.out.print("\033[2K\r");
        System.out.print("100%");

        return failedCount;
    }

    /**
     * The main method of the TestCardDeck class. Prints to the console if the test
     * failed and if so, how many times it has failed.
     * 
     * @param args the command-line arguments, which should be integers indicating
     *             the number of threads and cycles to use in the test,
     *             respectiviely.
     * @throws InterruptedException if any thread is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {
        int failedCount = new TestCardDeck().execute(args);

        if (failedCount == 0) {
            System.out.println("\n\nCardDeck appears to be thread safe.\n");
        } else if (failedCount > 0) {
            System.out.println("\n\nCardDeck appears to not be thread safe! Failed " + failedCount + " times!\n");
        }
    }
}
