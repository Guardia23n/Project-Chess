package com.projectChess.piece;

import com.projectChess.Board;
import com.projectChess.BoardUtils;
import com.projectChess.Color;
import com.projectChess.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        //bottom-left to top-right
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, i));
        }

        //top-left to bottom-right
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, -i));
        }

        return result;

    }

    @Override
    protected boolean isSquareAvailebleForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailebleForMove(coordinates, board);

        if (result) {
            //get squares between current pos and target pos
            //check that square is free
            List<Coordinates> coordinatesBetween = BoardUtils.getDiagnalsCoordinatesBetween(this.coordinates, coordinates);

            for (Coordinates c : coordinatesBetween) {
                if (!board.isSquereEmpty(c)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
