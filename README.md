# Tic-Tac-Toe Game

A classic Tic-Tac-Toe game implemented in Java with a Swing-based Graphical User Interface (GUI). Play against a friend in "One vs One" mode or challenge a simple AI in "One vs Computer" mode\!

-----

## Features

  * **Two Game Modes:**
      * **One vs One:** Play against another human player.
      * **One vs Computer:** Test your skills against a basic AI opponent.
  * **Intuitive GUI:** A clean and easy-to-use graphical interface built with Java Swing.
  * **Game Status Display:** A status bar at the top of the board indicates the current player's turn, game outcomes (win/draw), and computer's turn.
  * **Win/Draw Detection:** Automatically detects when a player wins or if the game ends in a draw.
  * **Simple AI:** The computer opponent uses a basic strategy to make its moves.

-----

## How to Play

1.  **Launch the Game:**
      * Run the `TicTacToeGame.java` file (see "How to Run" below).
2.  **Select Game Mode:**
      * Once the game window appears, click on the "**Game**" menu in the top-left corner.
      * Choose either "**One vs One**" or "**One vs Computer**".
3.  **Start Playing:**
      * **Player X** always starts first.
      * Click on any empty square on the 3x3 grid to make your move.
4.  **Game End:**
      * The game ends when one player gets three of their marks in a row (horizontally, vertically, or diagonally), or when all squares are filled (a draw).
      * The status bar will display the result.
5.  **New Game:**
      * To play another round, simply select a game mode again from the "Game" menu.

-----

## How to Run

To compile and run this Java Tic-Tac-Toe game, follow these steps:

1.  **Prerequisites:**

      * Ensure you have the **Java Development Kit (JDK)** installed on your system. You can download it from the [Oracle website](https://www.oracle.com/java/technologies/downloads/).

2.  **Download/Clone the Code:**

      * Save all three Java files (`TicTacToeGame.java`, `GameBoard.java`, `TicTacToeAI.java`) into the **same directory** on your computer.

3.  **Compile the Code:**

      * Open your **terminal** or **command prompt**.
      * Navigate to the directory where you saved the `.java` files using the `cd` command (e.g., `cd path/to/your/tic-tac-toe-folder`).
      * Compile all Java files using the Java compiler:
        ```bash
        javac TicTacToeGame.java GameBoard.java TicTacToeAI.java
        ```
        This command will create `.class` files for each of your Java source files.

4.  **Run the Game:**

      * From the same terminal/command prompt, run the main application:
        ```bash
        java TicTacToeGame
        ```
      * A Tic-Tac-Toe game window should pop up\!

---
## Sample Video

Here's a quick demonstration of the game in action:

[*Click here to watch a short video demonstration.*](https://drive.google.com/file/d/1Z3WdpeEc20Qz6nwUjyRq9Mcgtrgz_oJK/view?usp=sharing)

-----
