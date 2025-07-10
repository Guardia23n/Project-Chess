package com.projectChess;

import com.projectChess.board.Board;
import com.projectChess.board.Move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;

    private BoardConsolRenderer renderer = new BoardConsolRenderer();
    private InputCoordinates inputCoordinates = new InputCoordinates();
    private final List<GameStateChecker> checkers = List.of(new StalemateGameStateChecker());

    protected Game(Board board){
        this.board = board;
    }
    public void gameloop(){
        Color colorToMove = Color.WHITE;

        GameState state = determineGameState(board, colorToMove);

        while (state == GameState.ONGOING){
            renderer.render(board);

            if(colorToMove  == Color.WHITE){
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }
            //input

            Move move = InputCoordinates.inputMove(board, colorToMove, renderer);

            //make move
            board.makeMove(move);

            //pass move
            colorToMove = colorToMove.opposite();

            state = determineGameState(board, colorToMove);
        }
        renderer.render(board);
        System.out.println("Game ended with state = " + state);
    }

    private GameState determineGameState(Board board, Color color){
        for (GameStateChecker checker : checkers){
            GameState state = checker.check(board,color);

            if(state != GameState.ONGOING){
                return state;
            }
        }
        return GameState.ONGOING;
    }
}
