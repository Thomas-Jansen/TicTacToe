package jansen.thomas.tictactoe;

import java.io.Serializable;

class CheckForWinner implements Serializable{
/*
Check every scenario, to see if there is a winner
e.g. Button 1 and 2 are identical, button 1 and 3 are identical and
button 3 is not Blank. Than check which player has won.
*/
static GameState checkForWinner(int movesPlayed) {

        for (int i = 0; i < 3; i++) {
            if ((Game.board[i][0] == Game.board[i][1]) && (Game.board[i][1] == Game.board[i][2]) && (Game.board[i][0] != Tile.BLANK)) {
                if (Game.board[i][0] == Tile.CROSS) {
                    Game.state[0] = GameState.PLAYER_ONE;
                }
                else if (Game.board[i][0] == Tile.CIRCLE) {
                    Game.state[0] = GameState.PLAYER_TWO;
                }
            }
            else if ((Game.board[0][i] == Game.board[1][i]) && (Game.board[1][i] == Game.board[2][i]) && (Game.board[0][i] != Tile.BLANK)) {
                if (Game.board[0][i] == Tile.CROSS) {
                    Game.state[0] = GameState.PLAYER_ONE;
                }
                else if (Game.board[0][i] == Tile.CIRCLE) {
                    Game.state[0] = GameState.PLAYER_TWO;
                }
            }
        }
        if ((Game.board[0][0] == Game.board[1][1]) && (Game.board[1][1] == Game.board[2][2]) && (Game.board[0][0] != Tile.BLANK)) {
            if (Game.board[0][0] == Tile.CROSS) {
                Game.state[0] = GameState.PLAYER_ONE;
            }
            else if (Game.board[0][0] == Tile.CIRCLE) {
                Game.state[0] = GameState.PLAYER_TWO;
            }
        }
        if ((Game.board[0][2] == Game.board[1][1]) && (Game.board[1][1] == Game.board[2][0]) && (Game.board[0][2] != Tile.BLANK)) {
            if (Game.board[0][2] == Tile.CROSS) {
                Game.state[0] = GameState.PLAYER_ONE;
            }
            else if (Game.board[0][2] == Tile.CIRCLE) {
                Game.state[0] = GameState.PLAYER_TWO;
            }
        }
//      If all buttons are pressed and no one has won, it's a draw
        else if (movesPlayed == 9) {
            Game.state[0] = GameState.DRAW;
        }
        return Game.state[0];
    }
}
