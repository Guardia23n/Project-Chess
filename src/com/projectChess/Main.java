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
                //"4k3/8/p5n1/5B2/R7/3P4/P7/4K3 w - - 0 1"
                //"4k3/8/6r1/8/1P2Q3/8/4r1B1/3K4 b - - 0 1"
                //"qn1rbkrb/ppp3pp/5p2/2n1p3/3P1P2/2P5/PP4PP/QNNRBKRB b - f3 0 1"
                //"1k6/6p1/5p2/4N3/2n1B1b1/3P2P1/2P5/6K1 w - - 0 1"
                //"8/8/4p3/8/4K3/8/4k3/8 w - - 0 1"
                //"k7/8/4n3/8/4K3/8/8/8 w - - 0 1"
                "k7/8/1b6/2R5/4K3/8/8/8 b - - 0 1"
                //"k4r2/2Q5/8/r7/4KN2/2q1N3/8/8 b - - 0 1"
                //"k7/8/4p3/8/4K3/8/8/8 b - - 0 1"

        ));

        //BoardConsolRenderer renderer = new BoardConsolRenderer();
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