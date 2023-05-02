public class ThreadSafeCardDeck extends CardDeck {
    @Override
    public synchronized String dealCard() {
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
            e.printStackTrace();
        }
        
        return lastCardChoice;
    }
}
