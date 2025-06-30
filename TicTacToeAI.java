// package jobapplications;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeAI {

    public int[] findBestMove(char[][] board) {
        // 1. Check for a winning move
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    board[row][col] = 'O'; // Try placing 'O'
                    if (checkWin(board, 'O')) {
                        board[row][col] = ' '; // Undo the move
                        return new int[]{row, col};
                    }
                    board[row][col] = ' '; // Undo the move
                }
            }
        }

        // 2. Check for a blocking move (block 'X' from winning)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    board[row][col] = 'X'; // Try placing 'X' to see if it wins
                    if (checkWin(board, 'X')) {
                        board[row][col] = ' '; // Undo the move
                        return new int[]{row, col}; // Block this move
                    }
                    board[row][col] = ' '; // Undo the move
                }
            }
        }

        // 3. Take the center if available
        if (board[1][1] == ' ') {
            return new int[]{1, 1};
        }

        // 4. Take a corner if available
        List<int[]> corners = new ArrayList<>();
        if (board[0][0] == ' ') corners.add(new int[]{0, 0});
        if (board[0][2] == ' ') corners.add(new int[]{0, 2});
        if (board[2][0] == ' ') corners.add(new int[]{2, 0});
        if (board[2][2] == ' ') corners.add(new int[]{2, 2});
        if (!corners.isEmpty()) {
            return corners.get(new Random().nextInt(corners.size()));
        }

        // 5. Take any available side
        List<int[]> sides = new ArrayList<>();
        if (board[0][1] == ' ') sides.add(new int[]{0, 1});
        if (board[1][0] == ' ') sides.add(new int[]{1, 0});
        if (board[1][2] == ' ') sides.add(new int[]{1, 2});
        if (board[2][1] == ' ') sides.add(new int[]{2, 1});
        if (!sides.isEmpty()) {
            return sides.get(new Random().nextInt(sides.size()));
        }

        return null; // Should not happen in a valid game
    }

    private boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }
}