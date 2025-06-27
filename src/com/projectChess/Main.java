package com.projectChess;

import com.projectChess.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPositions();

        BoardConsolRenderer renderer = new BoardConsolRenderer();
        renderer.render(board);

        Piece piece = board.getPiece(new Coordinates(File.B,1));
        Set<Coordinates> avaiblableMoveSquares = piece.getAvailableMoveSquares(board);

        int a = 123;

    }
}