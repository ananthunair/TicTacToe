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
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                builder.append(" [" + board[row][col] + "]");
            builder.append(System.lineSeparator());
            }
        return builder.toString();
    }

    protected boolean addMarker(int position, int currentPlayer) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == Character.forDigit(position,10)) {
                    board[row][col] = (currentPlayer == 1) ? 'x' : 'o';
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSelected(int position) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                if (board[row][col] == Character.forDigit(position,10))
                    return false;
        }
        return true;
    }
}
