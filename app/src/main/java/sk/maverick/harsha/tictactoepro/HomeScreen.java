/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends ActionBarActivity {

    String opponent = "computer";                   // default the opponent is computer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }


    public void chooseOpponent(View view){

        Button button = (Button) view;
        opponent = (String) button.getTag();

        Log.v("Selected opponent", opponent);

          /*  if(opponent.equalsIgnoreCase("computer")){

                Dialog dialog = new Dialog(HomeScreen.this);
                dialog.setTitle("Choose Difficulty");
                dialog.setContentView(R.layout.difficult_level_layout);
                dialog.show();
            }else{*/

                 // Intent to game screen
                Intent intent = new Intent(HomeScreen.this, GameActivity.class);
                intent.putExtra("player-type", opponent);
                startActivity(intent);
          //  }
    }

    public void levelSelected(View view){

        switch (view.getId()){

            case R.id.difficulty_level_lame :  Log.v("Difficulty level","Lame selected");
                                                break;
            case R.id.difficulty_level_serious : Log.v("Difficulty level","Serious selected");
                                                break;
            default: break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
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
