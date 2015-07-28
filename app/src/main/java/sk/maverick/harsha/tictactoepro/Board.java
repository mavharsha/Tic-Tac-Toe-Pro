package sk.maverick.harsha.tictactoepro;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Harsha on 7/27/2015.
 */
public class Board {


    public void move(IPlayer player, int index, ImageButton view){

        Log.d("Board Class","Player assigned " + player.getAssigned() +" at "+ index);

        int resource = 0 == player.getAssigned() ? R.drawable.toe : R.drawable.cross;
        view.setImageResource(resource);
    }
}
