package com.projectChess;

import com.projectChess.Color;
import com.projectChess.Coordinates;
import com.projectChess.piece.Pawn;
import com.projectChess.piece.Piece;
import com.projectChess.piece.Rock;

public class PieceFactory {
    Piece fromFenChar(char fenChar, Coordinates coordinates){
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
                return new Rock(Color.BLACK, coordinates);
            case 'N':
                return new Rock(Color.WHITE, coordinates);

            case 'b':
                return new Rock(Color.BLACK, coordinates);
            case 'B':
                return new Rock(Color.WHITE, coordinates);

            case 'q':
                return new Rock(Color.BLACK, coordinates);
            case 'Q':
                return new Rock(Color.WHITE, coordinates);

            case 'k':
                return new Rock(Color.BLACK, coordinates);
            case 'K':
                return new Rock(Color.WHITE, coordinates);

            default:
                throw new RuntimeException("Unknown FEN char!");

        }
    }
}
