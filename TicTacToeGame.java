// package jobapplications;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame {

    private GameBoard gameBoard;
    private JLabel statusLabel;

    public TicTacToeGame() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500); // Increased height for status label
        setLocationRelativeTo(null); // Center the window

        // Status Label
        statusLabel = new JLabel("Welcome to Tic-Tac-Toe! Choose a mode.", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(statusLabel, BorderLayout.NORTH);

        gameBoard = new GameBoard(statusLabel);
        add(gameBoard, BorderLayout.CENTER);

        createMenuBar();

        setResizable(false);
        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");

        JMenuItem oneVsOneItem = new JMenuItem("One vs One");
        oneVsOneItem.addActionListener(e -> {
            gameBoard.resetGame(false); // false for one vs one
            statusLabel.setText("Player X's turn.");
        });

        JMenuItem oneVsComputerItem = new JMenuItem("One vs Computer");
        oneVsComputerItem.addActionListener(e -> {
            gameBoard.resetGame(true); // true for one vs computer
            statusLabel.setText("Player X's turn.");
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        gameMenu.add(oneVsOneItem);
        gameMenu.add(oneVsComputerItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);

        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToeGame::new);
    }
}