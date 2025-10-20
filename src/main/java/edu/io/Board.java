package edu.io;

import edu.io.token.EmptyToken;
import edu.io.token.Token;

public class Board {
    public static record Coords(int col, int row) {}

    private final int size = 10;
    private final Token[][] pola;

    public Board() {
        pola = new Token[size][size];
        czyszczenie();
    }

    private void czyszczenie() {
        for (int wiersz = 0; wiersz < size; wiersz++) {
            for (int kolumna = 0; kolumna < size; kolumna++) {
                pola[wiersz][kolumna] = new EmptyToken();
            }
        }
    }

    public void placeToken(int x, int y, Token token) {
        if (wlasciwa_pozycja(x, y)) {
            pola[y][x] = token;
        }
    }

    public Token peekToken(int x, int y) {
        if (wlasciwa_pozycja(x, y)) {
            return pola[y][x];
        }
        return null;
    }


    public Token square(int x, int y) {
        return peekToken(x, y);
    }

    public void clean() {
        czyszczenie();
    }

    public void display() {
        for (int wiersz = 0; wiersz < size; wiersz++) {
            for (int kolumna = 0; kolumna < size; kolumna++) {
                System.out.print(pola[wiersz][kolumna].label() + " ");
            }
            System.out.println();
        }
    }

    public int size() {
        return size;
    }

    private boolean wlasciwa_pozycja(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}