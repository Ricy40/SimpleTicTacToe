package tictactoe;

public class GameBoard {
    static char[][] board = new char[3][3];

    public GameBoard() {
        for (int x = 0; x < 3; x++) {
            board[0][x] = ' ';
            board[1][x] = ' ';
            board[2][x] = ' ';
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }

    public static boolean checkWin(char player) {
        if (
            //Vertical
            (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
                    (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||
                    (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||

                    // Horizontal
                    (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
                    (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
                    (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||

                    // Diagonal
                    (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                    (board[0][2] == player && board[1][1] == player && board[2][0] == player)
        ) {
            return true;
        } else {
            return false;
        }
    }

    public static int checkNumber(char input) {
        int counter = 0;

        for (char[] arrType: board) {
            for (char type: arrType) {
                if (type == input) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean checkPossible() {
        if (checkNumber('X') + 1 < checkNumber('O') || checkNumber('X') > checkNumber('O') + 1) {
            System.out.println("Impossible");
            return false;
        } else if (checkWin('X') && checkWin('O')) {
            System.out.println("Impossible");
            return false;
        }
        return true;
    }

    public static boolean playMove(char player, int x, int y) {
        x--;
        y--;

        if (x < 3 && x > -1 && y < 3 && y > -1) {
            if (board[x][y] == ' ') {
                board[x][y] = player;
                return true;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
    }
    
    public static boolean boardState() {
        if (checkPossible()) {
            boolean finished = true;
            for (char[] coord: board) {
                for (char i: coord) {
                    if (i == ' ') {
                        finished = false;
                    }
                }
            }
            if (checkWin('X')) {
                System.out.println("X wins");
                return true;
            } else if (checkWin('O')) {
                System.out.println("O wins");
                return true;
            } else if (!finished) {
                return false;
            } else if (!checkWin('x') && !checkWin('O')) {
                System.out.println("Draw");
                return true;
            }
        }
        return false;
    }
}
