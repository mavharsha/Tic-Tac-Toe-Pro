/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.util.Log;

public class Board {

    static int board[] = new int[9], occupied;
    static Boolean ended = false;
    int winner;
    public Board() {
        ended = false;
        occupied=0;
        for(int i =0; i<9;i++){
            board[i]= 2;
        }
    }

    public void move(IPlayer player){
        int index = player.playMove();
        int resource = 0 == player.getAssigned() ? R.drawable.toe : R.drawable.cross;
        GameActivity.imageButton[index/3][index%3].setImageResource(resource);
        board[index] = player.getAssigned();
        GameActivity.imageButton[index/3][index%3].setClickable(false);
        ++occupied;
        Log.v("Board occupied","" + board[0] + board[1] + board[2] + board[3] + board[4]+ board[5]+ board[6]+ board[7]+ board[8]);
    }

    public void checkForWin(){

        Log.v("Board"," Checked for win");
        if (board[0] == 1 & board[1] == 1 & board[2] == 1) {
            winner = 1;
            ended = true;
        }
        if (board[0] == 0 & board[1] == 0 & board[2] == 0) {
            winner = 0;
            ended = true;
        }

        if (board[3] == 1 & board[4] == 1 & board[5] == 1) {
            winner = 1;
            ended = true;
        }
        if (board[3] == 0 & board[4] == 0 & board[5] == 0) {
            winner = 0;
            ended = true;
        }

        if (board[6] == 1 & board[7] == 1 & board[8] == 1) {
            winner = 1;
            ended = true;
        }
        if (board[6] == 0 & board[7] == 0 & board[8] == 0) {
            winner = 0;
            ended = true;
        }


        if (board[0] == 1 & board[3] == 1 & board[6] == 1) {
            winner = 1;
            ended = true;

        }
        if (board[0] == 0 & board[3] == 0 & board[6] == 0) {
            winner = 0;
            ended = true;

        }

        if (board[1] == 1 & board[4] == 1 & board[7] == 1) {
            winner = 1;
            ended = true;
        }

        if (board[1] == 0 & board[4] == 0 & board[7] == 0) {
            winner = 0;
            ended = true;
        }


        if (board[2] == 1 & board[5] == 1 & board[8] == 1) {
            winner = 1;
            ended = true;
        }
        if (board[2] == 0 & board[5] == 0 & board[8] == 0) {
            winner = 0;
            ended = true;
        }

        //Diagonal check
        if (board[0] == 0 & board[4] == 0 & board[8] == 0) {
            winner = 0;
            ended = true;
        }
        if (board[2] == 0 & board[4] == 0 & board[6] == 0) {
            winner = 0;
            ended = true;
        }

        if (board[0] == 1 & board[4] == 1 & board[8] == 1) {
            winner = 1;
            ended = true;
        }
        if (board[2] == 1 & board[4] == 1 & board[6] == 1) {
            winner = 1;
            ended = true;
        }

    }

    public int getWinner() {
        return winner;
    }


}
