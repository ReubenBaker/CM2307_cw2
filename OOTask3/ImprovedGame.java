import java.util.Scanner;

public class ImprovedGame {
    public static void main(String[] args) {
        System.out.print("Card (c) or Die (d) game? ");
        try (Scanner scanner = new Scanner(System.in)) {
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
