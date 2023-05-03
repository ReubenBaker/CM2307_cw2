import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CardGame {
    private ArrayList<String> deck;
    private RandomInterface r;
    private HashSet<String> cardsChosen;
    private final Scanner scanner;
    private final int numberOfShuffles = 100;

    public CardGame(Scanner scanner) {
        this.deck = new ArrayList<String>();
        this.r = new LinearCongruentialGenerator();
        this.cardsChosen = new HashSet<String>();
        this.scanner = scanner;
    }

    public Boolean play() {
        initialiseDeck();
        shuffleDeck();
        chooseCards();
        return declareWinner();
    }

    private void initialiseDeck() {
        String[] suits = { "Hearts", "Diamonds", "Spades", "Clubs" };
        String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }
    }

    private void shuffleDeck() {
        for (int i = 0; i < numberOfShuffles; i++) {
            int firstIndex = ((int) (r.next() * 52));
            int secondIndex = ((int) (r.next() * 52));
            String temp = deck.get(firstIndex);
            deck.set(firstIndex, deck.get(secondIndex));
            deck.set(secondIndex, temp);
        }

        System.out.println(deck);
    }

    private void chooseCards() {
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println("Hit <RETURN> to choose a card");
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            int cardChoice = (int) (r.next() * deck.size());
            System.out.println("You chose " + deck.get(cardChoice));
            cardsChosen.add(deck.remove(cardChoice));
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
