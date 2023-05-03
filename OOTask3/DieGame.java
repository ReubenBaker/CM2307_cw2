import java.util.HashSet;
import java.util.Scanner;

public class DieGame {
    private HashSet<Integer> numbersRolled;
    private RandomInterface r;
    private final Scanner scanner;

    public DieGame(Scanner scanner) {
        this.numbersRolled = new HashSet<Integer>();
        this.r = new LinearCongruentialGenerator();
        this.scanner = scanner;
    }

    public Boolean play() {
        rollDice();
        return declareWinner();
    }

    private void rollDice() {
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println("Hit <RETURN> to roll the die");
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            int dieRoll = (int) (r.next() * 6) + 1;
            System.out.println("You rolled " + dieRoll);
            numbersRolled.add(Integer.valueOf(dieRoll));
        }

        scanner.close();

        System.out.println("Numbers rolled: " + numbersRolled);
    }

    private Boolean declareWinner() {
        if (numbersRolled.contains(Integer.valueOf(1))) {
            return true;
        }

        return false;
    }
}
