package com.projectChess.piece;

import com.projectChess.Board;
import com.projectChess.Color;
import com.projectChess.Coordinates;
import com.projectChess.piece.Piece;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        for (int fileShift = -1; fileShift <= 1; fileShift++) {
            for (int rankShift = -1; rankShift <= 1; rankShift++) {
                if ((fileShift == 0) && (rankShift == 0)) {
                    continue;
                }

                result.add(new CoordinatesShift(fileShift, rankShift));
            }
        }

        return result;
    }

    @Override
    protected boolean isSquareAvailebleForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailebleForMove(coordinates, board);

        if (result) {
            return !board.isSquareAttackedByColor(coordinates, color.opposite());
        }

        return false;
    }
}