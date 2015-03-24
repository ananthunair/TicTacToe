package com.ticTacToe;

public class TicTacToe {
    private final int player1;
    private final int player2;
    private char[][] board;
    private int currentPlayer;

    public TicTacToe() {
        this.player1 = 1;
        this.player2 = 2;
    }

    public void addMarker(char position) {
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board[i][j])) break;
                if (j == 0)
                    current = board[i][j];
                else if (current != board[i][j]) break;
                if (j == 2) return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board[j][i])) break;
                if (j == 0)
                    current = board[j][i];
                else if (current != board[j][i]) break;
                if (j == 2) return true;
            }
        }
        current = board[0][0];
        if(Character.isLetter(current) && current == board[1][1] && current == board[2][2])
            return true;
        current = board[0][2];
        if(Character.isLetter(current) && current == board[1][1] && current == board[2][0])
            return true;
        return false;
    }

    public void createBoard() {
        this.board = new char[3][3];
        int number = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Character.forDigit(++number, 10);
            }
        }
    }

    public void init() {
        this.createBoard();
        this.currentPlayer = 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayers() {
        if(currentPlayer == 1)
            currentPlayer = 2;
        else
            currentPlayer = 1;
    }
}
