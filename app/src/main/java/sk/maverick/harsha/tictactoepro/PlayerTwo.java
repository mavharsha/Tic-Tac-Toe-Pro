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
    public void playMove() {

    }

    public int getAssigned() {
        return assigned;
    }

    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    public String getName() {
        return name;
    }
}
