import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = false;

        do {

            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\nRolling dice...");
            System.out.printf("You rolled: %d + %d = %d%n", die1, die2, sum);

            boolean gameOver = false;
            int point = sum;

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
                gameOver = true;
            } else {
                System.out.println("the point is now: " + point);

            }
            while (!gameOver) {
                die1 = rnd.nextInt(6) + 1;
                die2 = rnd.nextInt(6) + 1;
                sum = die1 + die2;

                System.out.println("\nRolling dice...");
                System.out.printf("You rolled: %d + %d = %d%n", die1, die2, sum);

                if (sum == point) {
                    System.out.println("You made the point! You win!");
                    gameOver = true;

                } else if (sum == 7) {
                    System.out.println("You rolled a 7. You lose.");
                    gameOver = true;

                } else {
                    System.out.println("Still trying for point...");
                }
            }

            playAgain = getYNConfirm(in, "Do you want to play again?");
        }while (playAgain);

        System.out.println("Thanks for playing!");
        in.close();

    }


        public static boolean getYNConfirm(Scanner pipe, String prompt) {
            String userInput;
            boolean validInput = false;
            boolean response = false;

            while (!validInput) {
                System.out.print(prompt + " (Y/N): ");
                userInput = pipe.nextLine().trim();

                if (userInput.equalsIgnoreCase("Y")) {
                    response = true;
                    validInput = true;
                } else if (userInput.equalsIgnoreCase("N")) {
                    response = false;
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter Y for Yes or N for No.");
                }
            }

            return response;
        }
}
