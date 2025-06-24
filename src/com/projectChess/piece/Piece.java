package com.projectChess.piece;

import com.projectChess.Color;
import com.projectChess.Coordinates;

public class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }
}
