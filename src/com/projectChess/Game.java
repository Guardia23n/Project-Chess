package com.projectChess;

public class Game {
    private final Board board;

    private BoardConsolRenderer renderer = new BoardConsolRenderer();

    private Game(Board board){
        this.board = board;
    }
    public void gameloop(){
        boolean isWhiteToMove = true;

        while (true){
            renderer.render(board);
            isWhiteToMove =! isWhiteToMove;
        }
    }
}
