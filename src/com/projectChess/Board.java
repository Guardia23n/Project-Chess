package com.projectChess;

import com.projectChess.piece.Pawn;
import com.projectChess.piece.Piece;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPieces(Coordinates coordinates, Piece piece){
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    public boolean isSquereEmpty(Coordinates coordinates){
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates){
        return pieces.get(coordinates);
    }

    public void setupDefaultPiecesPositions(){
        for (File file: File.values()){
            setPieces(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPieces(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));
        }
    }
    public static boolean isSquereDark(Coordinates coordinates){
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }
}
