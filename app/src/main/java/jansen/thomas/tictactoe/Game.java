package jansen.thomas.tictactoe;

import android.util.Log;

import java.io.Serializable;

class Game implements Serializable {
    final private int BOARD_SIZE = 3;
    static Tile[][] board;
    static GameState[] state;
    Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    int movesPlayed;
    Boolean gameOver;


    Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;
        state = new GameState[1];
        state[0] = GameState.IN_PROGRESS;
        playerOneTurn = true;
        gameOver = false;
    }

    Tile draw(int row, int column) {
        Tile clickedTile = board[row][column];

        if (clickedTile ==  Tile.BLANK) {
            movesPlayed++;
            if (playerOneTurn) {
                clickedTile = Tile.CROSS;
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
            } else {
                clickedTile = Tile.CIRCLE;
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
            }
        }
        else {
            clickedTile = Tile.INVALID;
        }
    return clickedTile;
    }

    Tile getValue(int row, int column) {
        return board[row][column];
    }
}
