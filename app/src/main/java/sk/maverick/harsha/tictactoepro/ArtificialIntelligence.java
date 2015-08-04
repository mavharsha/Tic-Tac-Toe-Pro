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
    static IStrategy strategy;
    /*Assigining X or O*/
    public ArtificialIntelligence(int assigned) { this.assigned = assigned; }

    /*Difficulty level*/
    static public void setIntelligence(IStrategy NewStrategy){ strategy = NewStrategy;}

    /*Player Move*/
    public int playMove() {
        int index;
        index = strategy.use(this.getAssigned());
        return index; }

    @Override
    public int getAssigned() { return this.assigned; }

    @Override
    public void setAssigned(int index) { this.assigned = index; }

    @Override
    public String getName() { return this.name; }

}
