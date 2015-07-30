/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.util.Log;


public class PlayerTwo implements IPlayer {

    int assigned;
    String name = "Player Two";


    public PlayerTwo(int assigned) {
        this.assigned = assigned;
    }
    @Override
    public int playMove() { return GameActivity.selected; }
    @Override
    public int getAssigned() {
        return assigned;
    }
    @Override
    public void setAssigned(int assigned) { this.assigned = assigned; }
    @Override
    public String getName() { return name; }
}
