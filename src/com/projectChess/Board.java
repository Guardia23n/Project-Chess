package com.projectChess;

import com.projectChess.piece.*;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPieces(Coordinates coordinates, Piece piece){
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    public void removePieace(Coordinates coordinates){
        pieces.remove(coordinates);
    }
    public void  movePiece(Coordinates from, Coordinates to){
        Piece piece = getPiece(from);

        removePieace(from);
        setPieces(to, piece);
    }

    public boolean isSquereEmpty(Coordinates coordinates){
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates){
        return pieces.get(coordinates);
    }

    public void setupDefaultPiecesPositions(){
        // set pawns
        for (File file: File.values()){
            setPieces(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPieces(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));

        }

        // set rock
        setPieces(new Coordinates(File.A,1),new Rock(Color.WHITE, new Coordinates(File.A,1)));
        setPieces(new Coordinates(File.H,1),new Rock(Color.WHITE, new Coordinates(File.H,1)));
        setPieces(new Coordinates(File.A,8),new Rock(Color.BLACK, new Coordinates(File.A,8)));
        setPieces(new Coordinates(File.H,8),new Rock(Color.BLACK, new Coordinates(File.H,8)));

        // set Knight
        setPieces(new Coordinates(File.B,1),new Knight(Color.WHITE, new Coordinates(File.B,1)));
        setPieces(new Coordinates(File.G,1),new Knight(Color.WHITE, new Coordinates(File.G,1)));
        setPieces(new Coordinates(File.B,8),new Knight(Color.BLACK, new Coordinates(File.B,8)));
        setPieces(new Coordinates(File.G,8),new Knight(Color.BLACK, new Coordinates(File.G,8)));

        // set Bishop
        setPieces(new Coordinates(File.C,1),new Bishop(Color.WHITE, new Coordinates(File.C,1)));
        setPieces(new Coordinates(File.F,1),new Bishop(Color.WHITE, new Coordinates(File.F,1)));
        setPieces(new Coordinates(File.C,8),new Bishop(Color.BLACK, new Coordinates(File.C,8)));
        setPieces(new Coordinates(File.F,8),new Bishop(Color.BLACK, new Coordinates(File.F,8)));

        // set Queen
        setPieces(new Coordinates(File.D,1),new Queen(Color.WHITE, new Coordinates(File.D,1)));
        setPieces(new Coordinates(File.D,8),new Queen(Color.BLACK, new Coordinates(File.D,8)));

        // set King
        setPieces(new Coordinates(File.E,1),new King(Color.WHITE, new Coordinates(File.E,1)));
        setPieces(new Coordinates(File.E,8),new King(Color.BLACK, new Coordinates(File.E,8)));
    }

    public static boolean isSquereDark(Coordinates coordinates){
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }
}
