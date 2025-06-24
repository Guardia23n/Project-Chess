package com.projectChess;

import com.projectChess.piece.Piece;

public class Knight extends Piece {
    Color color;
    Coordinates coordinates;
    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }
}
