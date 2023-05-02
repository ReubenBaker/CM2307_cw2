public class TestThreadSafeCardDeck extends TestCardDeck {
    @Override
    protected CardDeck createDeck() {
        return new ThreadSafeCardDeck();
    }
}