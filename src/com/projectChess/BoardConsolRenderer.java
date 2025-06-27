package com.projectChess;
import com.projectChess.piece.Piece;


public class BoardConsolRenderer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board){
        for(int rank = 8; rank >= 1; rank--){
            String line = "";
            for (File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquereEmpty(coordinates)){
                    line += getSpringForEmptySquere(new Coordinates(file, rank));
                } else {
                    line += getPieceSprite(board.getPiece(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSqureDark){
        String result = sprite;

        if(pieceColor == Color.WHITE){
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if(isSqureDark){
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result + ANSI_RESET;
    }

    private String getSpringForEmptySquere(Coordinates coordinates){
        return colorizeSprite("   ", Color.WHITE, Board.isSquereDark(coordinates));
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

    private String getPieceSprite (Piece piece){
        return colorizeSprite(
                " " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSquereDark(piece.coordinates )
        );
    }
}
