public class ThreadSafeCardDeck extends CardDeck {
    @Override
    public synchronized String dealCard() {
        String cardChoice = null;

        try {
            int cardChoiceIndex = (int) (Math.random() * cardList.size());
            cardChoice = cardList.get(cardChoiceIndex);
            cardList.remove(cardChoiceIndex);
            lastCardChoice = cardChoice;
            sequenceNumber++;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastCardChoice;
    }
}
