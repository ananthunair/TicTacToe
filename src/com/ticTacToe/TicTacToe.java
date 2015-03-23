package com.ticTacToe;

public class TicTacToe {
    private char[][] board;

    public TicTacToe() {
        this.board = new char[3][3];
        board[0][0] = 1;
        board[0][1] = 2;
        board[0][2] = 3;
        board[1][0] = 4;
        board[1][1] = 5;
        board[1][2] = 6;
        board[2][0] = 7;
        board[2][1] = 8;
        board[2][2] = 9;
    }

    public void addMarker(int position) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == position)
                    board[i][j] = 'x';
            }
        }
    }

    public char[][] getBoard() {
        return this.board;
    }

    public boolean winning() {
        char current = ' ';
        //row
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board[i][j])) break;
                if (j == 0)
                    current = board[i][j];
                else if (current != board[i][j]) break;
                if (j == 2) return true;
            }
        }
        //column
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board[i][j])) break;
                if (j == 0)
                    current = board[i][j];
                else if (current != board[j][i]) break;
                if (j == 2) return true;
            }
        }
        return false;
    }
}
