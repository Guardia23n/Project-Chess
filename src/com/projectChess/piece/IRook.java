package com.projectChess.piece;

import java.util.HashSet;
import java.util.Set;

public interface IRook {
    default Set<CoordinatesShift> getRockMoves(){
        Set<CoordinatesShift> result = new HashSet<>();
        //left to right
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, 0));
        }

        //bottom to top
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(0, i));
        }

        return result;
    }

}
