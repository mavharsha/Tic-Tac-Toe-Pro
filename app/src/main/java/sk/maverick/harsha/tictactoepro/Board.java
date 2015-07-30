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
    Boolean ended;
    public Board() {

        ended = false;
        for(int i =0; i<9;i++){
            board[i]= 2;
        }
    }

    public int move(IPlayer player){
        int index = player.playMove();
        board[index] = player.getAssigned();
        return index;
    }

    public void checkForWin(){

    }


}
