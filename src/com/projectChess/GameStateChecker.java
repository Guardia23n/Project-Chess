package com.projectChess;

import com.projectChess.board.Board;

public abstract class GameStateChecker {
    public abstract GameState check(Board board, Color color);
}
