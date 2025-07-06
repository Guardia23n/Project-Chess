package com.projectChess;

import com.projectChess.board.Board;
import com.projectChess.board.Move;

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

            Move move = InputCoordinates.inputMove(board, isWhiteToMove ? Color.WHITE : Color.BLACK, renderer);

            //make move
            board.makeMove(move);

            //pass move
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
