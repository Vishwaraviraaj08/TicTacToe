# TicTacToe
Implemented in java using minimax algorithm to play human vs computer 

This is a Java program that implements the classic game of Tic Tac Toe. The game is played between a human player and the computer, with the computer using the minimax algorithm to determine the best move to make.

The program initializes a 3x3 game board with empty cells represented by blank spaces. It then enters a while loop that continues until the game is won by either the human or the computer, or until the game is a draw.

In each iteration of the loop, the program prompts the human player to choose a row and column to place their 'X' on the board. The program then checks if the chosen cell is empty, and if it is, places the 'X' on the board. It then checks if the human player has won the game, or if the game is a draw. If neither of these conditions are met, it calls the computerTurn function.

The computerTurn function uses the minimax algorithm to determine the best move for the computer. It does this by iterating over every possible move the computer could make, and calculating the score of each move using the minimax function. It then selects the move with the highest score and places an 'O' on the corresponding cell on the board.

The minimax function is a recursive function that determines the score of a particular game state for a given player ('X' or 'O'). It does this by first checking if the current game state is a win for the given player, a win for the other player, or a draw. If any of these conditions are met, it returns a score of 1, -1, or 0 respectively. If none of these conditions are met, it iterates over every possible move the given player could make, calculates the score for each move using the minimax function, and selects the move with the best score.

The program continues to alternate between the human player and the computer until either the human wins, the computer wins, or the game is a draw. At the end of the game, the program prints a message indicating the outcome of the game.
