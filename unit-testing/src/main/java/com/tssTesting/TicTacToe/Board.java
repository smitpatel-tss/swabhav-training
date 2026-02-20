package com.tssTesting.TicTacToe;

public class Board {

    private int boardLength;
    private int[][] board;
    private int moves;

    public Board(int boardLength) {
        this.boardLength = boardLength;
        board = new int[boardLength][boardLength];
        boardReset();
    }

    public int getBoardLength() {
        return boardLength;
    }

    public void boardReset() {
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                board[i][j] = -1;
            }
        }
        moves = 0;
    }

    public boolean placeMove(int row, int col, int input) {
        if (board[row][col] == -1) {
            board[row][col] = input;
            moves++;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return moves == boardLength * boardLength;
    }

    public boolean winCheck(int num) {
        int count = 0;

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[i][j] == num) {
                    count++;
                }
            }
            if (count == boardLength) {
                return true;
            }
            count = 0;
        }

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[j][i] == num) {
                    count++;
                }
            }
            if (count == boardLength) {
                return true;
            }
            count = 0;
        }

        for (int i = 0; i < boardLength; i++) {
            if (board[i][i] == num) {
                count++;
            }
        }
        if (count == boardLength) {
            return true;
        }

        count = 0;

        for (int i = 0; i < boardLength; i++) {
            if (board[i][boardLength - i - 1] == num) {
                count++;
            }
        }

        return count == boardLength;
    }

    public void displayBoard() {

        System.out.println();

        // Width needed to print largest index (9 -> 1, 10 -> 2, 100 -> 3, etc.)
        int cellWidth = String.valueOf(boardLength).length();
        int cellInnerWidth = cellWidth + 2; // space + content + space

        // ---- Column header ----
        System.out.print(" ".repeat(cellWidth + 3));
        for (int i = 1; i <= boardLength; i++) {
            System.out.printf(" %" + cellWidth + "d ", i);
        }
        System.out.println();

        // ---- Top border ----
        System.out.print(" ".repeat(cellWidth + 1) + "┌");
        for (int i = 0; i < boardLength; i++) {
            for (int k = 0; k < cellInnerWidth; k++)
                System.out.print("─");
            if (i < boardLength - 1)
                System.out.print("┬");
        }
        System.out.println("┐");

        // ---- Board rows ----
        for (int i = 0; i < boardLength; i++) {

            // Row number
            System.out.printf("%" + cellWidth + "d │", i + 1);

            // Cells
            for (int j = 0; j < boardLength; j++) {

                char symbol = ' ';
                if (board[i][j] == 1) symbol = 'X';
                else if (board[i][j] == 0) symbol = 'O';

                System.out.printf(" %" + cellWidth + "s ", symbol);

                if (j < boardLength - 1)
                    System.out.print("│");
            }

            System.out.println("│");

            // Middle separator
            if (i < boardLength - 1) {
                System.out.print(" ".repeat(cellWidth + 1) + "├");
                for (int j = 0; j < boardLength; j++) {
                    for (int k = 0; k < cellInnerWidth; k++)
                        System.out.print("─");
                    if (j < boardLength - 1)
                        System.out.print("┼");
                }
                System.out.println("┤");
            }
        }

        // ---- Bottom border ----
        System.out.print(" ".repeat(cellWidth + 1) + "└");
        for (int i = 0; i < boardLength; i++) {
            for (int k = 0; k < cellInnerWidth; k++)
                System.out.print("─");
            if (i < boardLength - 1)
                System.out.print("┴");
        }
        System.out.println("┘");

        System.out.println();
    }


}