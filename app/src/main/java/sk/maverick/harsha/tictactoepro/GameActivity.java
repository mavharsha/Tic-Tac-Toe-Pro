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
import android.widget.Toast;

public class GameActivity extends ActionBarActivity {

    Board board = new Board();
    IPlayer player_one = new PlayerOne(1);
    IPlayer player_two;
    IPlayer currentPlayer = player_one  ;
    TextView playerOneScore, playerTwoScore, playerTurn;
    static int selected;
    int count = 0;
    String player_type = "";
    static final ImageButton imageButton[][] = new ImageButton[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        initialize();                                           // Initializing the ui elements

        Intent intent = getIntent();
        player_type = intent.getStringExtra("player-type");
        Log.v("Selected opponent", player_type);


        if(player_type.equalsIgnoreCase("computer"))
        {
                        // Human Vs Computer
            player_two = new ArtificialIntelligence(0);
            Log.v("Selected opponent", player_two.getName());
        }
        else
        {
            player_two = new PlayerTwo(0);                     // Human Vs Human
            Log.v("Selected opponent", player_two.getName());
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
        if(!player_type.equalsIgnoreCase("computer"))
        {
            /* Human move */
            board.move(currentPlayer);
            changeCurrentPlayer();
            afterMove();
        }else
        {
            board.move(currentPlayer);
            changeCurrentPlayer();
            afterMove();
        }

    }

    private void afterMove() {

        board.checkForWin();

        if(currentPlayer.getName().equalsIgnoreCase("computer") & !Board.ended & Board.occupied < 9){
            board.move(currentPlayer);
            changeCurrentPlayer();
            afterMove();
        }

        if(Board.ended){
           // board.getWinner();
            int winner = board.getWinner();
            IPlayer winnerPlayer = winner == player_one.getAssigned() ? player_one : player_two;
            Toast.makeText(getApplicationContext(), "WInner is "+ winnerPlayer.getName(), Toast.LENGTH_SHORT).show();

            Log.v("Game Activity", "Game Ended and the winner is " + winnerPlayer.getName());
        }
        if(Board.occupied == 9){
            Toast.makeText(getApplicationContext(), "Tie", Toast.LENGTH_SHORT).show();
        }

    }

    public void newGameClicked(View view){

        board = new Board();
        changeAssignment();
        updateScreen();

        if(currentPlayer.getName().equalsIgnoreCase("computer")){
            currentPlayer.playMove();
            changeCurrentPlayer();
        }
    }


    public void changeCurrentPlayer(){
        currentPlayer = currentPlayer == player_one ? player_two : player_one;
        Log.d("GameActivity", "Current player is " + currentPlayer.getName());
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


    public void initialize(){

        imageButton[0][0] = (ImageButton) findViewById(R.id.row_00);
        imageButton[0][1] = (ImageButton) findViewById(R.id.row_01);
        imageButton[0][2] = (ImageButton) findViewById(R.id.row_02);

        imageButton[1][0] = (ImageButton) findViewById(R.id.row_10);
        imageButton[1][1] = (ImageButton) findViewById(R.id.row_11);
        imageButton[1][2] = (ImageButton) findViewById(R.id.row_12);

        imageButton[2][0] = (ImageButton) findViewById(R.id.row_20);
        imageButton[2][1] = (ImageButton) findViewById(R.id.row_21);
        imageButton[2][2] = (ImageButton) findViewById(R.id.row_22);

        playerOneScore = (TextView) findViewById(R.id.gameScreen_p1_score);
        playerTwoScore = (TextView) findViewById(R.id.gameScreen_p2_score);
        playerTurn = (TextView) findViewById(R.id.gameScreen_player_turn);

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
