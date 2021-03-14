//A simple game of Tic-tac-toe.
//Play by entering the coordinates "x y",
//where both x and y are integers between 1 and 3 (inclusive).
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //scanner object
        Scanner scanner = new Scanner(System.in);
        //initialization of the tic-tac-toe board with empty cells
        char[][] ticTacToe = new char[3][3];
        for (char[] rows : ticTacToe) {
            Arrays.fill(rows, ' ');
        }
        //winner's symbol (X | O)
            char winner = ' ';
        //the game
        game:
        for (int round = 0; round < 10; round++) {
            //drawing the board
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(ticTacToe[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            //seeing if the game has ended or not
            switch (winner) {
                case 'X':
                    System.out.println("X wins");
                    break game;
                case 'O':
                    System.out.println("O wins");
                    break game;
            }
            if (round == 9) {
                System.out.println("Draw");
                break;
            }
            //making a move
            while (true) {
                System.out.print("Enter the coordinates: ");
                String n = scanner.next();
                String m = scanner.next();
                try {
                    int x = Integer.parseInt(n);
                    int y = Integer.parseInt(m);
                    if (x > 3 || y > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        continue;
                    }
                    if (ticTacToe[x-1][y-1] == ' ') {
                        if (round % 2 == 0) {
                            ticTacToe[x-1][y-1] = 'X';
                        } else {
                            ticTacToe[x-1][y-1] = 'O';
                        }
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                }
            }
            //evaluating the game
            //checking for winning rows
            int win = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    win += ticTacToe[i][j];
                }
                if (win == 264) {
                    winner = 'X';
                } else if (win == 237) {
                    winner = 'O';
                }
                win = 0;
            }
            //checking for winning columns
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    win += ticTacToe[j][i];
                }
                if (win == 264) {
                    winner = 'X';
                } else if (win == 237) {
                    winner = 'O';
                }
                win = 0;
            }
            //checking diagonals
            win = ticTacToe[0][0] + ticTacToe[1][1] + ticTacToe[2][2];
            if (win == 264) {
                winner = 'X';
            } else if (win == 237) {
                winner = 'O';
            }
            win = ticTacToe[0][2] + ticTacToe[1][1] + ticTacToe[2][0];
            if (win == 264) {
                winner = 'X';
            } else if (win == 237) {
                winner = 'O';
            }
        }
    }
}