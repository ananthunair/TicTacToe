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
        int row = (position -1)/3;
        int col = (position -1)%3;
        if (!isSelected(position)) {
            board[row][col] = (currentPlayer == 1) ? 'x' : 'o';
            return true;
        }
        return false;
    }

    private boolean isSelected(int position) {
        int row = (position -1)/3;
        int col = (position -1)%3;
        return (board[row][col] != Character.forDigit(position,10));
    }

    public boolean isValidPick(int pick) {
        return (pick >= 1 && pick <= 9 && !isSelected(pick));
    }
}
