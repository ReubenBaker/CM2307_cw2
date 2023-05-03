public class TestThreadSafeCardDeck extends TestCardDeck {
    @Override
    protected CardDeck createDeck() {
        return new ThreadSafeCardDeck();
    }

    public static void main(String[] args) throws InterruptedException {
        int failedCount = new TestThreadSafeCardDeck().execute(args);

        if (failedCount == 0) {
            System.out.println("\n\nThreadSafeCardDeck appears to be thread safe.");
        } else if (failedCount > 0) {
            System.out.println("\n\nThreadSafeCardDeck appears to not be thread safe! Failed " + failedCount + " times!");
        }
    }
}