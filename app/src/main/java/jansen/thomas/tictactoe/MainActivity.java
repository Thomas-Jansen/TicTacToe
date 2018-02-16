package jansen.thomas.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Game game;

//  When game is started, check for saved game
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            game = (Game) savedInstanceState.getSerializable("currentGame");
//          Check for a winner within saved game
            GameState gameState = CheckForWinner.checkForWinner(game.movesPlayed);
            TextView winnerText = findViewById(R.id.textView_winner);
            switch(gameState) {
                case PLAYER_ONE:
                    winnerText.setText("Player one has won!");
                    game.gameOver = true;
                    break;
                case PLAYER_TWO:
                    winnerText.setText("Player two has won!");
                    game.gameOver = true;
                    break;
                case DRAW:
                    winnerText.setText("No one has won!");
                    game.gameOver = true;
                    break;
                case IN_PROGRESS:
                    winnerText.setText(" ");
                    game.gameOver = false;
                    break;
            }
//          Reset all buttons to their saved state
            for (int i = 1; i < 10; i++) {
                int button_id = getResources().getIdentifier("button" + i, "id", getPackageName());
                Button button = findViewById(button_id);
                String coordinates = (String) button.getTag();
                int row = Character.getNumericValue(coordinates.charAt(0));
                int column = Character.getNumericValue(coordinates.charAt(1));
                Tile tile = game.getValue(row, column);

                switch (tile) {
                    case CROSS:
                        button.setText("X");
                        break;
                    case CIRCLE:
                        button.setText("O");
                        break;
                    case BLANK:
                        button.setText(" ");
                        break;
                    case INVALID:
                        break;
                }
                if (game.gameOver) {
                    button.setClickable(false);
                }
            }
        }
//      If no saved game is found, create a new one
        else
            game = new Game();
    }

//  onClickListener for buttons
    public void tileClicked(View view) {

        int id = view.getId();
        String coordinates = (String) view.getTag();
        Button clickedButton = findViewById(id);
//      Get button coordinates stored in tag
        int row = Character.getNumericValue(coordinates.charAt(0));
        int column = Character.getNumericValue(coordinates.charAt(1));
//      Change the button text
        Tile tile = game.draw(row, column);

        switch(tile) {
            case CROSS:
                clickedButton.setText("X");
                break;
            case CIRCLE:
                clickedButton.setText("O");
                break;
            case INVALID:
                break;
        }
//      Check for a winner
        GameState gameState = CheckForWinner.checkForWinner(game.movesPlayed);
        TextView winnerText = findViewById(R.id.textView_winner);
//      Output winner text
        switch(gameState) {
            case PLAYER_ONE:
                winnerText.setText("Player one has won!");
                game.gameOver = true;
                break;
            case PLAYER_TWO:
                winnerText.setText("Player two has won!");
                game.gameOver = true;
                break;
            case DRAW:
                winnerText.setText("No one has won!");
                game.gameOver = true;
                break;
            case IN_PROGRESS:
                winnerText.setText(" ");
                game.gameOver = false;
                break;
        }
//      If there is a winner, make the buttons unclickable
        if (game.gameOver) {
            for (int i = 1; i < 10; i++) {
                int button_id = getResources().getIdentifier("button" + i, "id", getPackageName());
                Button button = findViewById(button_id);
                button.setClickable(false);
            }
        }
    }
//  Create a new game when reset button is pressed and set all text to normal
    public void resetClicked(View view) {
        game = new Game();
        for (int i = 1; i < 10; i++) {
            int button_id = getResources().getIdentifier("button" + i, "id", getPackageName());
            Button button = findViewById(button_id);
            button.setText(" ");
            button.setClickable(true);
            TextView winnerText = findViewById(R.id.textView_winner);
            winnerText.setText(" ");
        }
    }
//  When app is closed or phone rotated, save current game
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("currentGame", game);
    }
}
