/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi S.K
 *
 */

package sk.maverick.harsha.tictactoepro;


import java.util.Random;

public class ArtificialIntelligence implements IPlayer{

    int assigned;
    final String name = "computer";
    public ArtificialIntelligence(int assigned) { this.assigned = assigned; }

    public void setIntelligence(IStrategy Strategy){}

    public int playMove() {
        int index;
        while (true) {
            index = new Random().nextInt(9);
            if (Board.board [index] == 2 ) {
                break;
            }
        }


        // Strategy.use

        return index; }

    @Override
    public int getAssigned() { return this.assigned; }

    @Override
    public void setAssigned(int index) { this.assigned = index; }

    @Override
    public String getName() { return this.name; }

}
