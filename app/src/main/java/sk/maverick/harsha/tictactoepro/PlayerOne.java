/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.util.Log;
import android.widget.ImageButton;


public class PlayerOne implements IPlayer {

    int assigned;
    String name = "Player One";
    public PlayerOne(int assigned) {
        this.assigned = assigned;
    }


    @Override
    public int playMove() { return GameActivity.selected; }
    @Override
    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    @Override
    public int getAssigned() { return assigned; }
    @Override
    public String getName() {
        return name;
    }
}
