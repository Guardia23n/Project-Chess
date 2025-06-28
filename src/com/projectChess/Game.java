package com.projectChess;

import com.projectChess.piece.Piece;

import java.util.Set;

public class Game {
    private final Board board;

    private BoardConsolRenderer renderer = new BoardConsolRenderer();
    private InputCoordinates inputCoordinates = new InputCoordinates();

    protected Game(Board board){
        this.board = board;
    }
    public void gameloop(){
        boolean isWhiteToMove = true;

        while (true){
            renderer.render(board);

            if(isWhiteToMove){
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }
            //input
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor
                    (isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);

            //make move
            board.movePiece(sourceCoordinates, targetCoordinates);

            //pass move
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
