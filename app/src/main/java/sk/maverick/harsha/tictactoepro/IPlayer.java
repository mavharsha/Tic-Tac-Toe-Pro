/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

public interface IPlayer {
        /*
         *  0 --> O
         *  1 --> X
         *  2 --> Empty
         */
    int assigned = 0;
    int playMove();
    int getAssigned();
    void setAssigned(int index);
    String getName();
}
