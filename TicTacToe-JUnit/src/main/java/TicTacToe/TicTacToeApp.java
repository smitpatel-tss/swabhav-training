package TicTacToe;

import java.util.Scanner;

import static utils.Validate.validateBoolean;

public class TicTacToeApp {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        GameCreator game = new GameCreator();

        boolean anotherGame = false;

        while (true) {

            if (!anotherGame) {
                game.startGame();
            }

            System.out.print("Want to play another Game? (true/false): ");
            anotherGame = validateBoolean();
            scanner.nextLine();

            if (anotherGame) {
                game.currentGame();
            } else {
                System.out.println("EXITING...");
                return;
            }
        }
    }
}