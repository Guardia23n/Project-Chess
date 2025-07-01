package com.projectChess;

import com.projectChess.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Board board = new Board();
        //board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory().fromFEN(
                //"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0  1"
                //"r3kb1r/7p/8/2p2p1n/1P2PP2/1N4N1/P1B5/R2Q4 b KQkq - 0 1"
                //"4k3/8/5n2/2N5/3B4/8/8/4K3 b KQkq - 0 1"
                "4k3/8/p7/8/R7/8/P7/4K3 b KQkq - 0 1"

        ));

        BoardConsolRenderer renderer = new BoardConsolRenderer();
        //renderer.render(board);
/*


        Piece piece = board.getPiece(new Coordinates(File.B,1));
        Set<Coordinates> avaiblableMoveSquares = piece.getAvailableMoveSquares(board);

        int a = 123;

 */
        Game game = new Game(board);
        game.gameloop();

    }
}