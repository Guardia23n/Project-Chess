package com.projectChess.piece;

import com.projectChess.Color;
import com.projectChess.Coordinates;
import com.projectChess.piece.Piece;

import java.util.Set;

public class King extends Piece {
    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
