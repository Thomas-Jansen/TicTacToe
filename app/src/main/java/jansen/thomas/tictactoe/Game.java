package jansen.thomas.tictactoe;

//import android.service.quicksettings.Tile;


import java.io.Serializable;


public class Game implements java.io.Serializable {
    final private int BOARD_SIZE = 3;
    private static Tile[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public Tile draw(int row, int column) {
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

    public Tile getValue(int row, int column) {
        Tile checkingTile = board[row][column];
        System.out.println(checkingTile);
        return checkingTile;
    }
}
