import java.util.Scanner;

/**
 * The ImprovedGame class is a command-line game that prompts the user to choose
 * between playing a card game or a die game. The user input determines the type
 * of game that will be played.
 */
public class ImprovedGame {
    /**
     * The main method of the ImprovedGame class. Prompts the user for input and
     * uses the GameFactory class to create a PlayableGame object accordingly.
     * 
     * @param args The command-line arguments, which are unused in this method.
     */
    public static void main(String[] args) {
        System.out.print("Card (c) or Die (d) game? ");
        // Initialises the Scanner object to read user input in the main method, as well
        // as in the PlayableGame. Maintains ownership by encapsulating the PlayableGame
        // instantiation in a try-with block, which also auto-closes the Scanner.
        try (final Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();

            PlayableGame game = GameFactory.Create(input, scanner);

            if (game.play()) {
                System.out.println("You won!");
            } else {
                System.out.println("You lost!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
