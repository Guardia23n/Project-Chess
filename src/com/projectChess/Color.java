package com.projectChess;

public enum Color {
    WHITE,
    BLACK;

    public Color opposite(){
        return this == WHITE ? BLACK : WHITE;
    }
}
