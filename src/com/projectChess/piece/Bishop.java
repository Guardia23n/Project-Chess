package com.projectChess.piece;

import com.projectChess.Board;
import com.projectChess.BoardUtils;
import com.projectChess.Color;
import com.projectChess.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
    }
}
