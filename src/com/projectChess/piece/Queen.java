package com.projectChess.piece;

import com.projectChess.Color;
import com.projectChess.Coordinates;

import java.util.Set;


public class Queen extends Piece {
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
