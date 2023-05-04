/**
 * The ThreadSafeCardDeck class represents a thread safe version of the CardDeck
 * class. It extends the CardDeck class and overrides the dealCard method to
 * ensure that is is synchronized and thread-safe.
 */
public class ThreadSafeCardDeck extends CardDeck {
    /**
     * Overrides the dealCard method in the CardDeck class to ensure that it is
     * synchronized and thread safe. It also updates the last card choice and
     * sequence number after dealing a card.
     * 
     * @return The last card choice as a String.
     */
    @Override
    public synchronized String dealCard() {
        String cardChoice = null;

        try {
            // Choose a random card and remove it from the deck in a synchronized block.
            synchronized (cardList) {
                int cardChoiceIndex = (int) (Math.random() * cardList.size());
                cardChoice = cardList.get(cardChoiceIndex);
                cardList.remove(cardChoiceIndex);
            }

            // Update the last card choice and sequence number in a synchronized block.
            synchronized (this) {
                lastCardChoice = cardChoice;
                sequenceNumber++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastCardChoice;
    }
}
