/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import java.util.Random;

/**
 * Created by Harsha on 8/2/2015.
 */
public class LameIntelligence implements IStrategy {
    @Override
    public int use() {
        int index;

        while (true) {
            index = new Random().nextInt(9);
            if (Board.board [index] == 2 ) {
                break;
            }
        }
        return index;
    }
}
