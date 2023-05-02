public class TestThreadSafeCardDeck extends TestCardDeck {
    @Override
    protected CardDeck createDeck() {
        return new ThreadSafeCardDeck();
    }

    public static void main(String[] args) throws InterruptedException {
        new TestThreadSafeCardDeck().execute(args);
    }
}