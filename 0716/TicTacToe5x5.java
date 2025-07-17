import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static final char EMPTY = '.';
    static char[][] board = new char[SIZE][SIZE];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initBoard();
        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        char currentPlayer = 'X';
        while (true) {
            System.out.print("玩家 " + currentPlayer + " 請輸入 row col：");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // 檢查輸入是否合法
            if (!isValidMove(row, col)) {
                System.out.println("輸入錯誤或位置已被佔用，請重新輸入！");
                continue;
            }

            board[row][col] = currentPlayer;
            System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            } else if (isDraw()) {
                System.out.println("平手！");
                break;
            }

            // 換人
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = EMPTY;
    }

    static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    static boolean checkWin(char player) {
        // 橫向 & 直向
        for (int i = 0; i < SIZE; i++) {
            if (checkLine(player, i, 0, 0, 1)) return true; // 橫向
            if (checkLine(player, 0, i, 1, 0)) return true; // 直向
        }

        // 對角線（左上到右下）
        for (int i = 0; i <= SIZE - 5; i++) {
            for (int j = 0; j <= SIZE - 5; j++) {
                if (checkLine(player, i, j, 1, 1)) return true;
            }
        }

        // 反對角線（右上到左下）
        for (int i = 0; i <= SIZE - 5; i++) {
            for (int j = 4; j < SIZE; j++) {
                if (checkLine(player, i, j, 1, -1)) return true;
            }
        }

        return false;
    }

    static boolean checkLine(char player, int startRow, int startCol, int dRow, int dCol) {
        for (int i = 0; i <= SIZE - 5; i++) {
            boolean win = true;
            for (int j = 0; j < 5; j++) {
                int r = startRow + i * dRow + j * dRow;
                int c = startCol + i * dCol + j * dCol;
                if (r >= SIZE || c >= SIZE || r < 0 || c < 0 || board[r][c] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY)
                    return false;
        return true;
    }
}

