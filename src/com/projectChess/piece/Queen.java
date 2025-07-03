package com.projectChess.piece;

import com.projectChess.Color;
import com.projectChess.Coordinates;

import java.util.Set;


public class Queen extends LongRangePiece implements IBishop, IRook {
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> moves = getBishopMoves();
        moves.addAll(getRockMoves());

        return moves;
    }
}
