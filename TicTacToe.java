import java.util.*;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        while (true) {
            printBoard();

            System.out.println("\nYour turn. Choose a row and column :");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (board[row][col] == ' ') {
                board[row][col] = 'X';
                if (isWin('X')) {
                    System.out.println("You win!");
                    break;
                } else if (isDraw()) {
                    System.out.println("It's a draw.");
                    break;
                }
                computerTurn();
//                printBoard();
                if (isWin('O')) {
                    printBoard();
                    System.out.println("Computer wins!");
                    break;
                } else if (isDraw()) {
                    printBoard();
                    System.out.println("It's a draw.");
                    break;
                }
            } else {
                System.out.println("That square is already occupied.");
            }
        }
    }

    static boolean isWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    static void printBoard() {
        System.out.println("    1   2   3");
        System.out.println("  _____________");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n  -------------");
        }
    }

    static int minimax(char player) {
        if (isWin('O')) {
            return 1;
        } else if (isWin('X')) {
            return -1;
        } else if (isDraw()) {
            return 0;
        }

        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int score;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = player;

                    if (player == 'O') {
                        score = minimax('X');
                        bestScore = Math.max(score, bestScore);
                    } else {
                        score = minimax('O');
                        bestScore = Math.min(score, bestScore);

                    }
                    board[i][j] = ' ';
                }
            }
        }
        return bestScore;
    }

    static void computerTurn() throws InterruptedException {
        System.out.println("\nComputer's turn ...");
        Thread.sleep(600);


        int bestScore = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int score = minimax('X');
                    if (score > bestScore) {
                        bestScore = score;
                        row = i;
                        col = j;
                    }
                    board[i][j] = ' ';
                }
            }
        }
        board[row][col] = 'O';

    }
}