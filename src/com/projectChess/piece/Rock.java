package com.projectChess.piece;

import com.projectChess.Board;
import com.projectChess.BoardUtils;
import com.projectChess.Color;
import com.projectChess.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rock extends Piece{
    public Rock(Color color, Coordinates coordinates){super(color,coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        //left to right
        for (int i = -7; i <= 7; i++){
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, 0));
        }

        //bottom to top
        for (int i = -7; i <= 7; i++){
            if (i == 0) continue;

            result.add(new CoordinatesShift(0, i));
        }

        return result;

    }

    @Override
    protected boolean isSquareAvailebleForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailebleForMove(coordinates, board);

        if (result) {
            //get squares between current pos and target pos
            //check that square is free
            List<Coordinates> coordinatesBetween;

            if(this.coordinates.file == coordinates.file){
                coordinatesBetween = BoardUtils.getVerticalCoordinatesBetween(this.coordinates,coordinates);
            } else {
                coordinatesBetween = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates,coordinates);
            }

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
