package com.projectChess;

import com.projectChess.Color;
import com.projectChess.Coordinates;
import com.projectChess.piece.*;

public class PieceFactory {
    public Piece fromFenChar(char fenChar, Coordinates coordinates){
        switch (fenChar){
            case 'p':
                return new Pawn(Color.BLACK, coordinates);
            case 'P':
                return new Pawn(Color.WHITE, coordinates);

            case 'r':
                return new Rock(Color.BLACK, coordinates);
            case 'R':
                return new Rock(Color.WHITE, coordinates);

            case 'n':
                return new Knight(Color.BLACK, coordinates);
            case 'N':
                return new Knight(Color.WHITE, coordinates);

            case 'b':
                return new Bishop(Color.BLACK, coordinates);
            case 'B':
                return new Bishop(Color.WHITE, coordinates);

            case 'q':
                return new Queen(Color.BLACK, coordinates);
            case 'Q':
                return new Queen(Color.WHITE, coordinates);

            case 'k':
                return new King(Color.BLACK, coordinates);
            case 'K':
                return new King(Color.WHITE, coordinates);

            default:
                throw new RuntimeException("Unknown FEN char!");

        }
    }
}
