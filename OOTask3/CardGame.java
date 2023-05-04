import java.util.HashSet;
import java.util.Scanner;

/**
 * A playable game in which the player selects two random cards from a shuffled
 * ThreadSafeCardDeck by pressing the return key, and the winner is determined
 * based on if they have drawn an Ace card or not.
 */
public class CardGame implements PlayableGame {
    private ThreadSafeCardDeck deck; // ThreadSafeCardDeck from OOTask2 package.
    private HashSet<String> cardsChosen;
    private final Scanner scanner;

    /**
     * Constructs a new instance of the CardGame.
     * 
     * @param scanner The scanner to use for user input.
     */
    public CardGame(Scanner scanner) {
        this.deck = new ThreadSafeCardDeck();
        this.cardsChosen = new HashSet<String>();
        this.scanner = scanner;
    }

    /**
     * Plays the CardGame.
     * 
     * @return true if the player wins, false otherwise.
     */
    public Boolean play() {
        chooseCards();
        return declareWinner();
    }

    /**
     * Allows the player to choose 2 random cards from a shuffled ThreadSafeCardDeck
     * by pressing the return key per draw.
     */
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

        System.out.println("Cards chosen: " + cardsChosen);
        System.out.println("Remaining cards: " + deck.cardList);
    }

    /**
     * Determines if the player has won by checking if they have drawn an Ace card
     * or not.
     * 
     * @return true if the player has drawn an Ace card, false otherwise.
     */
    private Boolean declareWinner() {
        System.out.println("Cards chosen: " + cardsChosen);
        String regex = "^A.*"; // Regex for checking if the card begins with "A" (any Ace card).

        for (String card : cardsChosen) {
            if (card.matches(regex)) {
                return true;
            }
        }

        return false;
    }
}
