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
    String winner = "";
    public Board() {

        ended = false;
        for(int i =0; i<9;i++){
            board[i]= 2;
        }
    }

    public void move(IPlayer player){
        int index = player.playMove();
        board[index] = player.getAssigned();
    }

    public void checkForWin(){


    }

    public String getWinner() {
        return winner;
    }
}
