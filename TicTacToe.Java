import java.util.Scanner;

public class TicTacToe {
    // 2D Array representing the 3x3 board
    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Welcome to Java Console Tic-Tac-Toe!");
        printBoard();

        while (gameRunning) {
            System.out.println("Player " + currentPlayer + "'s turn.");
            int row, col;

            // Loop until the player enters a valid, empty position
            while (true) {
                System.out.print("Enter row (0, 1, or 2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0, 1, or 2): ");
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("This move is invalid or the slot is already taken. Try again!");
                }
            }

            printBoard();

            // Check if someone won or if it's a tie
            if (checkWin()) {
                System.out.println("Congratulations! Player " + currentPlayer + " wins!");
                gameRunning = false;
            } else if (isBoardFull()) {
                System.out.println("It's a tie game!");
                gameRunning = false;
            } else {
                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        scanner.close();
    }

    // Prints the formatted grid to the console
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Checks all possible rows, columns, and diagonals for a win
    private static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;

        return false;
    }

    // Checks if the grid is entirely full (Draw scenario)
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
