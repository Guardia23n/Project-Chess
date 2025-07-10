package com.projectChess;

import com.projectChess.board.Board;
import com.projectChess.piece.Piece;

import java.util.List;
import java.util.Set;

public class StalemateGameStateChecker extends GameStateChecker{
    @Override
    public GameState check(Board board, Color color){
        List<Piece> pieces = board.getPiecesByColor(color);

        for(Piece piece : pieces){
            Set<Coordinates> availebleMoveSquares = piece.getAvailableMoveSquares(board);

            if (availebleMoveSquares.size() > 0){
                return GameState.ONGOING;
            }
        }
        return GameState.STALEMATE;
    }
}
