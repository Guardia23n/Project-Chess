package com.projectChess;

import com.projectChess.piece.BoardConsolRenderer;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPositions();

        BoardConsolRenderer renderer = new BoardConsolRenderer();
        renderer.render(board);

        int a = 123; //debug, created for parameters control

    }
}