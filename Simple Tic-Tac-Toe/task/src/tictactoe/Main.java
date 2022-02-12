package tictactoe;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    static GameBoard board = new GameBoard();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean notEnd = true;
        char player= 'X';
        int turn = 1;

        board.printBoard();

        while (notEnd) {
            if (turn > 10) {
                System.out.println("Something went wrong");
                break;
            } else if (turn % 2 == 0) {
                player = 'O';
            } else {
                player = 'X';
            }
            takeTurn(player);
            board.printBoard();
            notEnd = !board.boardState();
            turn++;
        }
    }

    public static void takeTurn(char player) {
        Scanner scanner = new Scanner(System.in);
        boolean notValid = true;
        while (notValid) {
            System.out.print("Enter the coordinates: ");
            String coords = scanner.nextLine();

            if (Pattern.matches("[0-9]+", String.valueOf(coords.charAt(0)))
                    && Pattern.matches("[0-9]+", String.valueOf(coords.charAt(2)))
                    && coords.charAt(1) == ' ') {

                int y = Integer.parseInt(String.valueOf(coords.charAt(0)));
                int x = Integer.parseInt(String.valueOf(coords.charAt(2)));

                if (board.playMove(player, y, x)) {
                    notValid = false;
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
