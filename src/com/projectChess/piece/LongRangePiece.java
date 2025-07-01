package com.projectChess.piece;

import com.projectChess.Board;
import com.projectChess.BoardUtils;
import com.projectChess.Coordinates;
import com.projectChess.Color;

import java.util.List;

public abstract class LongRangePiece extends Piece {
    public LongRangePiece (Color color, Coordinates coordinates){
        super(color,coordinates);
    }

    @Override
    protected boolean isSquareAvailebleForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailebleForMove(coordinates, board);

        if (result) {
            List<Coordinates> coordinatesBetween;

            if(this.coordinates.file == coordinates.file){
                coordinatesBetween = BoardUtils.getVerticalCoordinatesBetween(this.coordinates,coordinates);
            } else if(this.coordinates.rank.equals(coordinates.rank)) {
                coordinatesBetween = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates,coordinates);
            } else {
                coordinatesBetween = BoardUtils.getDiagnalsCoordinatesBetween(this.coordinates, coordinates);
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
