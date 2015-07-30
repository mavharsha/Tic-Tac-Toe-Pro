/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi S.K
 *
 */

package sk.maverick.harsha.tictactoepro;


public class ArtificialIntelligence implements IPlayer{

    int assigned;
    final String name = "computer";
    public ArtificialIntelligence(int assigned) { this.assigned = assigned; }

    public int playMove() { return GameActivity.selected; }

    @Override
    public int getAssigned() { return this.assigned; }

    @Override
    public void setAssigned(int index) { this.assigned = index; }

    @Override
    public String getName() { return this.name; }

}
