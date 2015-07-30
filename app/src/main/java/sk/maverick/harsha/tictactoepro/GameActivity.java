/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.view.MenuItem;
import android.widget.ImageButton;

public class GameActivity extends ActionBarActivity {

    Board board = new Board();
    IPlayer player_one = new PlayerOne(0);
    IPlayer player_two;
    IPlayer currentPlayer = player_one  ;
    TextView playerOneScore, playerTwoScore, playerTurn;
    static int selected;
    int count = 0;
    String player_type ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        playerOneScore = (TextView) findViewById(R.id.gameScreen_p1_score);
        playerTwoScore = (TextView) findViewById(R.id.gameScreen_p2_score);
        playerTurn = (TextView) findViewById(R.id.gameScreen_player_turn);

        Intent intent = getIntent();
        player_type = intent.getStringExtra("player-type");

        playerTwoScore.setText(player_type);

        if(player_type.equalsIgnoreCase(new ArtificialIntelligence(1).getName()))
        {
            Log.v("Selected opponent", player_type);            // Human Vs Computer
            player_two = new ArtificialIntelligence(1);
        }
        else
        {
            Log.v("Selected opponent", player_type);
            player_two = new PlayerTwo(1);                     // Human Vs Human
        }

    }


    public void buttonClicked(View view){

        ImageButton image = (ImageButton) view;
        selected = Integer.parseInt((String) image.getTag());
        Log.v("Button clicked ","Button Clicked" + selected);
        count++;

      /*
        *  first check if its against computer or human
        * */
        if(!player_type.equalsIgnoreCase(new ArtificialIntelligence(1).getName()))
        {
            /* Human move */
           // board.move(currentPlayer);
        }
        else{

            /* Play humans move and call after_move function */


        }




            if(count%2 != 0 )
        {
            board.move(currentPlayer);
            changeAssignment();
            afterMove();
        }

    }

    private void afterMove() {

        board.checkForWin();

        if(currentPlayer.getName().equalsIgnoreCase("computer") && !board.ended){
            board.move(currentPlayer);
        }
    }


    // Still have to work on newGame
    // when its in computer mode and its computers turn
    public void newGame(){
        board = new Board();
        changeAssignment();
        updateScreen();

       // if(count%2 ==0)
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
