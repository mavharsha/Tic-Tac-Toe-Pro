/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.util.Log;
import android.widget.ImageButton;

public class Board {

    int board[] = new int[9];
    static Boolean ended = false;
    String winner = "";
    public Board() {

        ended = false;
        for(int i =0; i<9;i++){
            board[i]= 2;
        }
    }

    public void move(IPlayer player){
        int index = player.playMove();
        int resource = 0 == player.getAssigned() ? R.drawable.toe : R.drawable.cross;
        GameActivity.imageButton[index/3][index%3].setImageResource(resource);
        board[index] = player.getAssigned();
    }

    public void checkForWin(){


    }

    public String getWinner() {
        return winner;
    }


}
