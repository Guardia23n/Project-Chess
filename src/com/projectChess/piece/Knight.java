package com.projectChess.piece;

import com.projectChess.Color;
import com.projectChess.Coordinates;
import com.projectChess.piece.Piece;

public class Knight extends Piece {
    Color color;
    Coordinates coordinates;
    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }
}
