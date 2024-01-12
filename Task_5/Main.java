//Tic-Tac-Toe Game
package Task_5;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static char[][] board;
    private static char HumanPlayer;
    private static char ComputerPlayer;
    private static boolean isHumanTurn = true;

    public static void main(String arg[]) {
        start();
    }

    // Game Start
    private static void start() {

        System.out.println("\n\n!!!\t\t Tic Tac Toe Game Start \t\t!!!\n");

        int ch;

        do {
            System.out.println("1. Human VS Human");
            System.out.println("2. Human VS Computer");
            System.out.println("3. Exit");
            System.out.print("Enter your Choice : ");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    play(ch);
                    break;
                case 2:
                    play(ch);
                    break;
                case 3:
                    System.out.println("\n\t\tGoodbye! Thanks for playing Tic Tac Toe!");
                    break;
            }

        } while (ch != 3);

    }

    // Main Code
    private static void play(int ch) {

        if (ch == 1) {

            choosePlayer();

            board = new char[3][3];
            initializeBoard();
            do {
                printBoard();
                System.out.println("\nHuman player's " + HumanPlayer + " turn.");
                System.out.print("\nEnter the cell number (1-9): ");
                int cellNumber = scanner.nextInt();
                if (makeMove(cellNumber)) {
                    if (checkWin(HumanPlayer)) {
                        printBoard();
                        System.out.println("\n\t\tPlayer " + HumanPlayer + " wins!\n");
                        break;
                    } else if (isBoardFull()) {
                        printBoard();
                        System.out.println("\n\t\tIt's a tie!\n");
                        break;
                    }

                    HumanPlayer = (HumanPlayer == 'X') ? 'O' : 'X';
                }
            } while (true);
        } else if (ch == 2) {
            choosePlayer();
            board = new char[3][3];
            initializeBoard();
            do {
                printBoard();

                if (isHumanTurn) {
                    System.out.println("\nHuman player's " + HumanPlayer + " turn.");
                    System.out.print("\nEnter the cell number (1-9): ");
                    int cellNumber = scanner.nextInt();

                    if (makeMove(cellNumber)) {
                        if (checkWin(HumanPlayer)) {
                            printBoard();
                            System.out.println("\n\t\tHuman player wins!\n");
                            break;
                        } else if (isBoardFull()) {
                            printBoard();
                            System.out.println("\n\t\tIt's a tie!\n");
                            break;
                        }
                        isHumanTurn = false;
                    }
                } else {
                    ComputerPlayer = (HumanPlayer == 'X') ? 'O' : 'X';

                    System.out.println("\nComputer's " + ComputerPlayer + " turn.");
                    int computerMove = getComputerMove();

                    if (makeMove(computerMove)) {
                        if (checkWin(ComputerPlayer)) {
                            printBoard();
                            System.out.println("\n\t\tComputer wins!\n");
                            break;
                        } else if (isBoardFull()) {
                            printBoard();
                            System.out.println("\n\t\tIt's a tie!\n");
                            break;
                        }
                        isHumanTurn = true;
                    }
                }
            } while (true);

        }
    }

    // Board Initialize Code
    private static void initializeBoard() {
        char cellValue = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cellValue++;
            }
        }
    }

    // Board Printing Code
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Board Player Move Code
    private static boolean makeMove(int cellNumber) {
        if (cellNumber >= 1 && cellNumber <= 9) {
            int row = (cellNumber - 1) / 3;
            int col = (cellNumber - 1) % 3;

            if (board[row][col] >= '1' && board[row][col] <= '9') {
                board[row][col] = isHumanTurn ? HumanPlayer : ComputerPlayer;
                return true;
            } else {
                System.out.println("Invalid move. Try again.");
                return false;
            }
        } else {
            System.out.println("Invalid cell number. Try again.");
            return false;
        }
    }

    // Check Board Full Code
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check Winner Calculate Code
    private static boolean checkWin(char Player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == Player && board[i][1] == Player && board[i][2] == Player) ||
                    (board[0][i] == Player && board[1][i] == Player && board[2][i] == Player)) {
                return true;
            }
        }
        if ((board[0][0] == Player && board[1][1] == Player && board[2][2] == Player) ||
                (board[0][2] == Player && board[1][1] == Player && board[2][0] == Player)) {
            return true;
        }
        return false;
    }

    // Make Computer Move Code
    private static int getComputerMove() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    // Player Deciding Code
    private static void choosePlayer() {
        int choicePlayer;
        System.out.println("\nChoose Player 1 For X and 2 For O");
        System.out.println("\n1. X");
        System.out.println("2. O");
        System.out.print("Enter your Choice : ");

        choicePlayer = scanner.nextInt();

        if (choicePlayer == 1) {
            HumanPlayer = 'X';
        } else if (choicePlayer == 2) {
            HumanPlayer = 'O';
        } else {
            System.out.println("Invalid Choice");
            choosePlayer();
        }
    }

}
