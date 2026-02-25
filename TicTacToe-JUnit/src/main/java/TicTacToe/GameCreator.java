package TicTacToe;

import java.util.Scanner;

public class GameCreator {

    private Scanner scanner;
    private Board board;
    private Player player1;
    private Player player2;

    public GameCreator() {
        scanner = new Scanner(System.in);
        board = new Board(3);
    }

    public void startGame() {

        System.out.print("Enter Name of Player1 (X) : ");
        String name1 = scanner.nextLine();

        System.out.print("Enter Name of Player 2 (O) : ");
        String name2 = scanner.nextLine();

        player1 = new Player(name1, 1);
        player2 = new Player(name2, 0);

        currentGame();
    }

    public void currentGame() {

        board.boardReset();

        while (true) {

            board.displayBoard();

            System.out.println("Turn for " + player1.getName() + " (X) : ");
            while (!enterInput(player1.getSymbol())) {
                System.out.println("Choose Valid Box!");
            }

            if (board.winCheck(player1.getSymbol())) {
                board.displayBoard();
                System.out.println(player1.getName() + " Winner....");
                return;
            }

            if (board.isFull()) {
                board.displayBoard();
                System.out.println("DRAW - Game Over!");
                return;
            }

            board.displayBoard();

            System.out.println("Turn for " + player2.getName() + " (O) : ");
            while (!enterInput(player2.getSymbol())) {
                System.out.println("Choose Valid Box!");
            }

            if (board.winCheck(player2.getSymbol())) {
                board.displayBoard();
                System.out.println(player2.getName() + " Winner....");
                return;
            }

            if (board.isFull()) {
                board.displayBoard();
                System.out.println("DRAW - Game Over!");
                return;
            }
        }
    }

    private boolean enterInput(int input) {

        System.out.print("Enter row: ");
        int row = inputValidator();
        while (row > board.getBoardLength() || row <= 0) {
            System.out.print("Enter Valid Row Value: ");
            row = inputValidator();
        }

        System.out.print("Enter column: ");
        int col = inputValidator();
        while (col > board.getBoardLength() || col <= 0) {
            System.out.print("Enter Valid Col Value: ");
            col = inputValidator();
        }

        return board.placeMove(row - 1, col - 1, input);
    }

    private int inputValidator() {

        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("Enter Valid Input, Integer Only!");
                scanner.next();
                continue;
            }

            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Enter Positive Non Zero Integers Only!");
            } else {
                return n;
            }
        }
    }
}