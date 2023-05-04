/**
 * The TestThreadSafeCardDeck class extends the TestCardDeck class and tests the
 * ThreadSafeCardDeck class. It overrides the createDeck method to create a new
 * instance of ThreadSafeCardDeck and uses it to perform the tests inherited
 * from TestCardDeck.
 */
public class TestThreadSafeCardDeck extends TestCardDeck {
    /**
     * Creates a new ThreadSafeCardDeck object to be used in the test.
     * 
     * @return a new ThreadSafeCardDeck object.
     */
    @Override
    protected CardDeck createDeck() {
        return new ThreadSafeCardDeck();
    }

    /**
     * The main method of the TestThreadSafeCardDeck class. Prints to the console if
     * the test failed and if so, how many times it has failed.
     * 
     * @param args the command-line arguments, which should be integers indicating
     *             the number of threads and cycles to use in the test,
     *             respectiviely.
     * @throws InterruptedException if any thread is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {
        int failedCount = new TestThreadSafeCardDeck().execute(args);

        if (failedCount == 0) {
            System.out.println("\n\nThreadSafeCardDeck appears to be thread safe.");
        } else if (failedCount > 0) {
            System.out.println("\n\nThreadSafeCardDeck appears to not be thread safe! Failed " + failedCount + " times!");
        }
    }
}