package sk.maverick.harsha.tictactoepro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class GameActivity extends ActionBarActivity {

    Board board = new Board();
    IPlayer player_one = new PlayerOne(0);
    IPlayer player_two = new PlayerTwo(1);
    IPlayer currentPlayer = player_one  ;
    TextView playerOneScore, playerTwoScore, playerTurn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        playerOneScore = (TextView) findViewById(R.id.gameScreen_p1_score);
        playerTwoScore = (TextView) findViewById(R.id.gameScreen_p2_score);
        playerTurn = (TextView) findViewById(R.id.gameScreen_player_turn);

        updateScreen();
    }

    public void buttonClicked(View view){

        switch (view.getId()){

            case R.id.row_00 :    Log.d("GameActivity","Pressed one"); board.move(currentPlayer, 0, (ImageButton) view);
                                  setCurrentPlayer();
                                    updateScreen();
                                        break;

            case R.id.row_01 :    board.move(currentPlayer, 1, (ImageButton) view);
                                    setCurrentPlayer();
                                    updateScreen();
                                        break;

            case R.id.row_02 :    board.move(currentPlayer, 2, (ImageButton) view);
                                    setCurrentPlayer();
                                    updateScreen();
                                        break;

            case R.id.row_10 :    board.move(currentPlayer, 3, (ImageButton) view);
                                    setCurrentPlayer();
                                    updateScreen();
                                        break;

            case R.id.row_11 :    board.move(currentPlayer, 4, (ImageButton) view);
                                    setCurrentPlayer();
                                     updateScreen();
                                        break;

            case R.id.row_12 :    board.move(currentPlayer, 5, (ImageButton) view);
                                    setCurrentPlayer();
                                    updateScreen();
                                        break;

            case R.id.row_20 :    board.move(currentPlayer, 6, (ImageButton) view);
                                    setCurrentPlayer();
                                    updateScreen();
                                        break;

            case R.id.row_21 :    board.move(currentPlayer, 7, (ImageButton) view);
                                     setCurrentPlayer();
                                    updateScreen();
                                        break;

            case R.id.row_22 :    board.move(currentPlayer, 8, (ImageButton)     view);
                                     setCurrentPlayer();
                                    updateScreen();
                                        break;


            case R.id.gameScreen_newgame  :       changeAssignment();
                                            updateScreen();
                                          break;
        }

    }

    public void setCurrentPlayer(){
        currentPlayer = currentPlayer == player_one ? player_two : player_one;
        Log.d("GameActivity","Current player is " + currentPlayer.getName());
    }

    // Change Assignment is called is called when new game is created.
    public void changeAssignment(){

        Log.d("GameActivity", "Changing assignment");
        int temp = player_one.getAssigned();
        player_one.setAssigned(player_two.getAssigned());
        player_two.setAssigned(temp);
        updateScreen();
    }

    public void updateScreen(){

        /*
         *  0 --> O
         *  1 --> X
         */

        char c1 = 0 == player_one.getAssigned()? 'O': 'X';
        playerOneScore.setText("Player One: " + c1);
        char c2 = 0 == player_two.getAssigned()? 'O': 'X';
        playerTwoScore.setText("Player Two: " + c2);

        playerTurn.setText(currentPlayer.getName() + "'s Turn!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
