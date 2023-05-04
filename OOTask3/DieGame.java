import java.util.HashSet;
import java.util.Scanner;

/**
 * A playable game in which the player rolls two dice by pressing the return
 * key, and the winner is determined based on whether they have rolled a 1 or
 * not.
 */
public class DieGame implements PlayableGame {
    private RandomInterface r; // RandomInterface for retreiving the next random number
    private HashSet<Integer> numbersRolled;
    private final Scanner scanner;

    /**
     * Constructs a new instance of the DieGame.
     * 
     * @param scanner The scanner to use for user input.
     */
    public DieGame(Scanner scanner) {
        this.r = new LinearCongruentialGenerator();
        this.numbersRolled = new HashSet<Integer>();
        this.scanner = scanner;
    }

    /**
     * Plays the DieGame.
     * 
     * @return true if the player wins, false otherwise.
     */
    public Boolean play() {
        rollDice();
        return declareWinner();
    }

    /**
     * Allows the player to roll two dice by pressing the return key per roll. The
     * rolled number is added to the numbersRolled HashSet.
     */
    private void rollDice() {
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println("Hit <RETURN> to roll the die");
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            int dieRoll = (int) ((r.next() * 6) + 1);
            System.out.println("You rolled " + dieRoll);
            numbersRolled.add(Integer.valueOf(dieRoll));
        }

        System.out.println("Numbers rolled: " + numbersRolled);
    }

    /**
     * Determines if the player has won by checking if they have rolled a 1.
     * 
     * @return true if the player has rolled a 1, false otherwise.
     */
    private Boolean declareWinner() {
        if (numbersRolled.contains(Integer.valueOf(1))) {
            return true;
        }

        return false;
    }
}
