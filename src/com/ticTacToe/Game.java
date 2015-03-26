package com.ticTacToe;

public class Game {
    private Board board;

    private int currentPlayer;
    private int plays;

    public Game(Board board) {
        this.board = board;
    }

    public boolean winning() {
        char current = ' ';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board.getBoard()[i][j])) break;
                if (j == 0)
                    current = board.getBoard()[i][j];
                else if (current != board.getBoard()[i][j]) break;
                if (j == 2) return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board.getBoard()[j][i])) break;
                if (j == 0)
                    current = board.getBoard()[j][i];
                else if (current != board.getBoard()[j][i]) break;
                if (j == 2) return true;
            }
        }
        current = board.getBoard()[0][0];
        if(Character.isLetter(current) && current == board.getBoard()[1][1] && current == board.getBoard()[2][2])
            return true;
        current = board.getBoard()[0][2];
        if(Character.isLetter(current) && current == board.getBoard()[1][1] && current == board.getBoard()[2][0])
            return true;
        return false;
    }

    public void init() {
        this.currentPlayer = 1;
        this.plays = 0;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayers() {
        if(currentPlayer == 1)
            currentPlayer = 2;
        else
            currentPlayer = 1;
        plays++;
    }

    public int getPlays() {
        return plays;
    }
}
