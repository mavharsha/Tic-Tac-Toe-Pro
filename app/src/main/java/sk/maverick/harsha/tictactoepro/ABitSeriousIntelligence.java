/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import java.util.Random;

public class ABitSeriousIntelligence implements IStrategy {
    int index;
    boolean foundMove = false;
    @Override
    public int use(int assigned) {

        foundMove = false;
        if(Board.board[4] == 2){
            index = 4;
            foundMove = true;
        }

        index = move("attack", assigned);

        if(!foundMove){
            index = move("defense", assigned);
        }
        if(!foundMove){
                while (true) {
                    index = new Random().nextInt(9);
                    if (Board.board[index] == 2 ) {
                        break;
                    }
                }

        }
        return index;
    }

    private int move(String type,int assigned) {

        if(type.equalsIgnoreCase("defense"))
        { assigned  = assigned == 0 ? 1 : 0; }

        if(Board.board[0] == assigned & Board.board[1] == assigned & Board.board[2] == 2)
        {foundMove = true; return  2;}

        else if(Board.board[0] == assigned & Board.board[2] == assigned & Board.board[1] == 2)
        { foundMove = true; return 1; }

        else if(Board.board[1] == assigned & Board.board[2] == assigned & Board.board[0] == 2)
        { foundMove = true; return 0; }

       /*Defend second horizontal*/

        else if(Board.board[3] == assigned & Board.board[4] == assigned & Board.board[5] == 2)
        { foundMove = true; return 5; }

        else if(Board.board[3] == assigned & Board.board[5] == assigned & Board.board[4] == 2)
        { foundMove = true; return 4; }

        else if(Board.board[4] == assigned & Board.board[5] == assigned & Board.board[3] == 2)
        { foundMove = true; return 3; }

        /*Defend third horizontal*/

        else if(Board.board[6] == assigned & Board.board[7] == assigned & Board.board[8] == 2)
        { foundMove = true; return 8; }

        else if(Board.board[6] == assigned & Board.board[8] == assigned & Board.board[7] == 2 )
        { foundMove = true; return 7; }

        else if(Board.board[7] == assigned & Board.board[8] == assigned & Board.board[6] == 2)
        { foundMove = true; return 6; }


        /*Defend first vertical*/

        else if( Board.board[0] == assigned & Board.board[3] == assigned & Board.board[6] == 2 )
        { foundMove = true; return  6; }

        else if( Board.board[0] == assigned & Board.board[6] == assigned & Board.board[3] == 2 )
        { foundMove = true; return  3; }

        else if ( Board.board[3] == assigned & Board.board[6] == assigned & Board.board[0] == 2)
        { foundMove = true; return 0; }

       /*Defend second vertical*/

        else if ( Board.board[1] == assigned & Board.board[4] == assigned & Board.board[7] == 2 )
        { foundMove = true; return  7; }

        else if ( Board.board[1] == assigned & Board.board[7] == assigned & Board.board[4] == 2)
        { foundMove = true; return  4; }

        else if ( Board.board[4] == assigned & Board.board[7] == assigned & Board.board[1] == 2 )
        { foundMove = true; return  1; }

        /*Defend third vertical*/

        else if ( Board.board[2] == assigned & Board.board[5] == assigned & Board.board[8] == 2)
        { foundMove = true; return  8; }

        else if ( Board.board[2] == assigned & Board.board[8] == assigned & Board.board[5] == 2)
        { foundMove = true; return  5; }

        else if ( Board.board[5] == assigned & Board.board[8] == assigned & Board.board[2] == 2 )
        { foundMove = true; return  2; }


        /*Defend the right to left diagonal*/
        else if ( Board.board[0] == assigned & Board.board[4] == assigned & Board.board[8] == 2 )
        {   foundMove = true; return  8; }

        else if ( Board.board[0] == assigned & Board.board[8] == assigned & Board.board[4] == 2 )
        {    foundMove = true; return  4; }

        else if ( Board.board[4] == assigned & Board.board[8] == assigned & Board.board[0] == 2 )
        {    foundMove = true; return 0; }


        /*Defend the left to right diagonal*/

        else if ( Board.board[2] == assigned & Board.board[4] == assigned & Board.board[6] == 2)
        { foundMove = true; return  6; }

        else if ( Board.board[2] == assigned & Board.board[6] == assigned & Board.board[4] == 2 )
        { foundMove = true; return  4; }

        else if ( Board.board[4] == assigned & Board.board[6] == assigned & Board.board[2] == 2)
        { foundMove = true; return  2; }

        return 10;
    }

}
