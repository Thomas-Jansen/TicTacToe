package jansen.thomas.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void tileClicked(View view) {

        int id = view.getId();
        String coordinates = (String) view.getTag();
        Button clickedButton = findViewById(id);

        int row = Character.getNumericValue(coordinates.charAt(0));
        int column = Character.getNumericValue(coordinates.charAt(1));
        Tile tile = game.draw(row, column);

        switch(tile) {
            case CROSS:
                clickedButton.setText("X");
                break;
            case CIRCLE:
                clickedButton.setText("O");
                break;
            case INVALID:                break;
        }
    }

    public void resetClicked(View view) {
        game = new Game();
        for (int i = 1; i < 10; i++) {
            int button_id = getResources().getIdentifier("button" + i, "id", getPackageName());
            Button button = findViewById(button_id);
            button.setText(" ");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("currentGame", game);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        game = (Game) savedInstanceState.getSerializable("currentGame");

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
        }
    }
}
