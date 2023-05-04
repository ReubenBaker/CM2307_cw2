import java.util.Scanner;
import java.security.InvalidParameterException;

/**
 * The GameFactory class is a factory class for creating instances of
 * PlayableGame based on user input.
 */
public final class GameFactory {
    /**
     * Creates an instance of PlayableGame based on user input.
     * 
     * @param input The user input to determine which game to create.
     * @param scanner The scanner to use for user input during the game.
     * @return A new instance of the PlayableGame object.
     * @throws InvalidParameterException if the user input is not understood.
     */
    public static PlayableGame Create(String input, Scanner scanner) throws InvalidParameterException {
        if (input.equals("c")) {
            return new CardGame(scanner);
        }

        if (input.equals("d")) {
            return new DieGame(scanner);
        }

        throw new InvalidParameterException("Input not understood");
    }
}
