package sk.maverick.harsha.tictactoepro;

/**
 * Created by Harsha on 7/27/2015.
 */
public interface IPlayer {
    /*
     *  0 --> O
     *  1 --> X
     */

    int assigned = 0;
    void playMove();
    int getAssigned();
    void setAssigned(int assigned);
    String getName();
}
