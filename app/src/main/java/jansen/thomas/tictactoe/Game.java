package jansen.thomas.tictactoe;

//import android.service.quicksettings.Tile;


/**
 * Created by thomm on 12-2-2018.
 */

public class Game {
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
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
}
