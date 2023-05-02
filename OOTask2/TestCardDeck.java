import java.util.ArrayList;

public class TestCardDeck {
    protected CardDeck createDeck() {
        return new CardDeck();
    }

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

    public void execute(String[] args) throws InterruptedException {
        int threadCount = 26;
        int cycleCount = 10000;
        int failedCount = 0;

        if (args.length == 2) {
            try {
                threadCount = Integer.parseInt(args[0]);
                cycleCount = Integer.parseInt(args[1]);

                if (threadCount < 1 || threadCount > 26) {
                    System.out.println("Thread count must be between 1 and 26!");
                    return;
                }

                if (cycleCount < 1) {
                    System.out.println("Cycle count must be at least 1!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Args invalid! Thread count and Cycle count must both be integers!");
                return;
            }
        }

        System.out.println("Number of Threads: " + threadCount);
        System.out.println("Number of Cycles: " + cycleCount + "\n");

        for (int i = 0; i < cycleCount; i++) {
            if (!runThreads(threadCount)) {
                failedCount++;
            }

            if ((i + 1) % (cycleCount / 100) == 0) {
                System.out.print("\033[2K\r");
                System.out.print((int) Math.round(((double) (i + 1) / cycleCount) * 100) + "%");
            }
        }

        System.out.print("\033[2K\r");
        System.out.print("100%");

        if (failedCount > 0) {
            System.out.println("\n\nCardDeck appears to not be thread safe! Failed " + failedCount + " times!\n");
        } else {
            System.out.println("\n\nCardDeck appears to be thread safe.\n");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new TestCardDeck().execute(args);
    }
}
