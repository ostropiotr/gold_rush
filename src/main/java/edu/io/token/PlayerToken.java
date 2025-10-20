package edu.io.token;

import edu.io.Board;

public class PlayerToken extends Token {
    public enum Move {
        NONE, LEFT, RIGHT, UP, DOWN
    }

    private final Board board;
    private int col;
    private int row;

    public PlayerToken(Board board) {
        this.board = board;

        this.col = board.size() / 2;
        this.row = board.size() / 2;
        board.placeToken(col, row, this);
    }

    @Override
    public String label() {
        return Label.PLAYER_TOKEN_LABEL;
    }

    public void move(Move direction) {
        int newCol = col;
        int newRow = row;

        switch (direction) {
            case LEFT: newCol--; break;
            case RIGHT: newCol++; break;
            case UP: newRow--; break;
            case DOWN: newRow++; break;
            case NONE: return;
        }


        if (newCol < 0 || newCol >= board.size() || newRow < 0 || newRow >= board.size()) {
            throw new IllegalArgumentException("Nie mozna wyjsc poza krawedzie planszy");
        }


        board.placeToken(col, row, new EmptyToken());


        col = newCol;
        row = newRow;


        board.placeToken(col, row, this);
    }

    public Board.Coords pos() {
        return new Board.Coords(col, row);
    }
}
