import java.util.Scanner;
import java.security.InvalidParameterException;

public final class GameFactory {
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
