

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel implements ActionListener {

    private JButton[][] buttons;
    private char[][] board;
    private char currentPlayer;
    private boolean vsComputer;
    private TicTacToeAI ai;
    private JLabel statusLabel; // Reference to the status label from the main frame

    public GameBoard(JLabel statusLabel) {
        this.statusLabel = statusLabel;
        setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        board = new char[3][3];
        ai = new TicTacToeAI();

        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].addActionListener(this);
                add(buttons[row][col]);
                board[row][col] = ' ';
            }
        }
        currentPlayer = 'X';
        vsComputer = false; // Default to one vs one
    }

    public void resetGame(boolean vsComputerMode) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
                board[row][col] = ' ';
            }
        }
        currentPlayer = 'X';
        vsComputer = vsComputerMode;
        statusLabel.setText("Player X's turn.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col] == clickedButton && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    clickedButton.setText(String.valueOf(currentPlayer));
                    clickedButton.setEnabled(false);

                    if (checkWin()) {
                        statusLabel.setText("Player " + currentPlayer + " wins!");
                        disableAllButtons();
                    } else if (checkDraw()) {
                        statusLabel.setText("It's a draw!");
                        disableAllButtons();
                    } else {
                        switchPlayer();
                        if (vsComputer && currentPlayer == 'O') {
                            statusLabel.setText("Computer's turn...");
                            SwingUtilities.invokeLater(this::makeComputerMove); // Delay for visual effect
                        } else {
                            statusLabel.setText("Player " + currentPlayer + "'s turn.");
                        }
                    }
                    return;
                }
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    private boolean checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false; // Still empty cells, not a draw yet
                }
            }
        }
        return true; // All cells filled, it's a draw
    }

    private void disableAllButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    private void makeComputerMove() {
        int[] move = ai.findBestMove(board);
        if (move != null) {
            int row = move[0];
            int col = move[1];
            board[row][col] = currentPlayer;
            buttons[row][col].setText(String.valueOf(currentPlayer));
            buttons[row][col].setEnabled(false);

            if (checkWin()) {
                statusLabel.setText("Computer wins!");
                disableAllButtons();
            } else if (checkDraw()) {
                statusLabel.setText("It's a draw!");
                disableAllButtons();
            } else {
                switchPlayer();
                statusLabel.setText("Player " + currentPlayer + "'s turn.");
            }
        }
    }
}