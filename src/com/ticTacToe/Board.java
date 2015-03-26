package com.ticTacToe;

public class Board {
    public char[][] board;

    public Board() {
        this.board = new char[3][3];
        createBoard();
    }

    public char[][] getBoard() {
        return this.board;
    }

    public void createBoard() {
        int number = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Character.forDigit(++number, 10);
            }
        }
    }

    public String drawBoard() {
        StringBuilder builder = new StringBuilder("Game board:" + System.lineSeparator());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                builder.append(" [" + board[i][j] + "]");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    protected boolean addMarker(int position, int currentPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Character.forDigit(position,10)) {
                    board[i][j] = (currentPlayer == 1) ? 'x' : 'o';
                    return true;
                }
            }
        }
        return false;
    }
}