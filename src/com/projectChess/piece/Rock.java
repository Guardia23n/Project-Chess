package com.projectChess.piece;

import com.projectChess.Color;
import com.projectChess.Coordinates;

import java.util.Set;

public class Rock extends Piece{
    public Rock(Color color, Coordinates coordinates){super(color,coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
