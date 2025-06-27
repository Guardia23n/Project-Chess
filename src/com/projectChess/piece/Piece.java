package com.projectChess.piece;

import com.projectChess.Board;
import com.projectChess.Color;
import com.projectChess.Coordinates;
import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }

   public Set<Coordinates> getAvailableMoveSquares (Board board){
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift shift: getPieceMoves()){
            if(coordinates.canShift(shift)){
                Coordinates newCoordinates = coordinates.shift(shift);

                if(isSquareAvailebleForMove(newCoordinates, board)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
   }

   private boolean isSquareAvailebleForMove(Coordinates coordinates, Board board){
        return board.isSquereEmpty(coordinates) || board.getPiece(coordinates).color !=color;
   }

    protected abstract Set<CoordinatesShift> getPieceMoves();
}
