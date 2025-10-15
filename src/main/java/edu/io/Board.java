package edu.io;

public class Board {

    public final int size = 10;

    private Token[][] pola;

    private void czyszczenie() {

        Token puste = new Token("・");

        for (int wiersz = 0; wiersz < size; wiersz++) {
            for (int kolumna = 0; kolumna < size; kolumna++) {
                pola[wiersz][kolumna] = puste;
            }
        }
    }



    private boolean wlasciwa_pozycja(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }


    public Board() {
        pola = new Token[size][size];

        czyszczenie();
    }




    public void placeToken(int x, int y, Token token) {

        if (wlasciwa_pozycja(x, y)) {
            pola[y][x] = token;
        }
    }


    public Token square(int x, int y) {
        if (wlasciwa_pozycja(x, y)) {
            return pola[y][x];
        }
        return null;
    }




    public void clean() {
        czyszczenie();
    }


    public void display() {

        for (int wiersz = 0; wiersz < size; wiersz++) {


            for (int kolumna = 0; kolumna < size; kolumna++) {
                System.out.print(pola[wiersz][kolumna].label + " ");
            }


            System.out.println();
        }
    }






}