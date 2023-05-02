public class ThreadSafeCardDeck extends CardDeck {
    @Override
    public synchronized String dealCard() {
        // Various reasons why the code in the try{} block could fail, so
        // we catch any exception and
        // then carry on as if nothing had happened!
        String cardChoice = null;

        try {
            synchronized (cardList) {
                int cardChoiceIndex = (int) (Math.random() * cardList.size());
                cardChoice = cardList.get(cardChoiceIndex);
                cardList.remove(cardChoiceIndex);
            }

            synchronized (this) {
                lastCardChoice = cardChoice;
                sequenceNumber++;
            }
        } catch (Exception e) {
            // Don't do anything; pretend nothing happened!
        }
        return lastCardChoice;
    }
}
