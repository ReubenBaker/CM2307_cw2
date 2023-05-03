import java.util.Scanner;

public class ImprovedGame {
    public static void main(String[] args) {
        String input = "";
        Boolean result = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Card (c) or Die (d) game? ");

        try {
            input = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (input.equals("c")) {
            result = new CardGame(scanner).play();
        } else if (input.equals("d")) {
            result = new DieGame(scanner).play();
        } else {
            System.out.println("Input not understood");
        }

        if (result) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost!");
        }
    }
}
