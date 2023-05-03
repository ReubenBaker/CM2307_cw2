import java.util.HashSet;
import java.util.Scanner;

public class CardGame {
    private ThreadSafeCardDeck deck;
    private HashSet<String> cardsChosen;
    private final Scanner scanner;

    public CardGame(Scanner scanner) {
        this.deck = new ThreadSafeCardDeck();
        this.cardsChosen = new HashSet<String>();
        this.scanner = scanner;
    }

    public Boolean play() {
        chooseCards();
        return declareWinner();
    }

    private void chooseCards() {
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println("Hit <RETURN> to choose a card");
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            String cardChoice = deck.dealCard();
            System.out.println("You chose " + cardChoice);
            cardsChosen.add(cardChoice);
        }

        scanner.close();

        System.out.println("Cards chosen: " + cardsChosen);
        System.out.println("Remaining cards: " + deck);
    }

    private Boolean declareWinner() {
        System.out.println("Cards chosen: " + cardsChosen);
        String regex = "^A.*";

        for (String card : cardsChosen) {
            if (card.matches(regex)) {
                return true;
            }
        }

        return false;
    }
}
