/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

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
    static int selected;
    ImageButton image[][] = new ImageButton[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        playerOneScore = (TextView) findViewById(R.id.gameScreen_p1_score);
        playerTwoScore = (TextView) findViewById(R.id.gameScreen_p2_score);
        playerTurn = (TextView) findViewById(R.id.gameScreen_player_turn);

        initialize();

        updateScreen();
        start();
    }


    public void start(){
        int index;
        while (!board.ended){
            index =  board.move(currentPlayer);

            try{

                int resource = 0 == currentPlayer.getAssigned() ? R.drawable.toe : R.drawable.cross;
                image[index/3][index%3].setImageResource(resource);

            }catch (Exception e)
            {
                e.printStackTrace();
            }



        }
    }

    public void buttonClicked(ImageButton view){

        switch (view.getId()){

            case R.id.row_00 : selected = 0;
                break;

            case R.id.row_01 : selected = 1;
                break;

            case R.id.row_02 : selected = 2;
                break;

            case R.id.row_10 : selected = 3;
                break;

            case R.id.row_11 : selected = 4;
                break;

            case R.id.row_12 : selected = 5;
                break;

            case R.id.row_20 : selected = 6;
                break;

            case R.id.row_21 : selected = 7;
                break;

            case R.id.row_22 : selected = 8;
                break;


            case R.id.gameScreen_newgame  :       newGame();
                break;
        }

    }


    public void newGame(){
        board = new Board();
        changeAssignment();
        updateScreen();
    }

    private void initialize() {

        image[0][0] = (ImageButton) findViewById(R.id.row_00);
        image[0][1] = (ImageButton) findViewById(R.id.row_01);
        image[0][2] = (ImageButton) findViewById(R.id.row_02);

        image[1][0] = (ImageButton) findViewById(R.id.row_10);
        image[1][1] = (ImageButton) findViewById(R.id.row_11);
        image[1][2] = (ImageButton) findViewById(R.id.row_12);

        image[2][0] = (ImageButton) findViewById(R.id.row_20);
        image[2][1] = (ImageButton) findViewById(R.id.row_21);
        image[2][2] = (ImageButton) findViewById(R.id.row_22);
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
         *  2 --> Empty
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
