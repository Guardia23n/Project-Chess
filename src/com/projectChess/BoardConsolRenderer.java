package com.projectChess;
import com.projectChess.piece.Piece;

import java.util.Set;

import static java.util.Collections.emptySet;


public class BoardConsolRenderer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board, Piece pieceToMove){
        Set<Coordinates> availableMoveSquares = emptySet();
        if(pieceToMove != null){
            availableMoveSquares = pieceToMove.getAvailableMoveSquares(board);
        }

        for(int rank = 8; rank >= 1; rank--){
            String line = "";
            for (File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                boolean isHighlight = availableMoveSquares.contains(coordinates);

                if (board.isSquareEmpty(coordinates)){
                    line += getSpringForEmptySquere(coordinates, isHighlight);
                } else {
                    line += getPieceSprite(board.getPiece(coordinates), isHighlight);
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    public void render(Board board){
        render(board, null);
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSqureDark, boolean isHighLighted){
        String result = sprite;

        if(pieceColor == Color.WHITE){
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }
        if(isHighLighted){
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        }else if (isSqureDark){
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result + ANSI_RESET;
    }

    private String getSpringForEmptySquere(Coordinates coordinates, boolean isHightlight){
        return colorizeSprite("   ", Color.WHITE, Board.isSquereDark(coordinates), isHightlight);
    }

    private String selectUnicodeSpriteForPiece(Piece piece){
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "P"; //♟

            case "Knight":
                return "T"; // ♞

            case "Bishop":
                return "B"; // ♝

            case "Rock":
                return "R"; // ♜

            case "Queen":
                return "Q"; // ♛

            case "King":
                return "K"; // ♚
        }

        return "";
    }

    private String getPieceSprite (Piece piece, boolean isHightlight){
        return colorizeSprite(
                " " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSquereDark(piece.coordinates ),
                isHightlight
        );
    }
}
