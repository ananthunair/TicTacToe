package com.ticTacToe;

public class Game {
    private Board board;
    private int currentPlayer;
    private int plays;

    public Game(Board board) {
        this.board = board;
    }

    public void init() {
        this.currentPlayer = 1;
        this.plays = 0;
    }

    public boolean winning() {
        char current = ' ';
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 0)
                    current = board.getBoard()[row][col];
                else if (isCurrentUnavailable(current, row, col)) break;
                if (col == 2) return true;
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 0)
                    current = board.getBoard()[col][row];
                else if (isCurrentUnavailable(current, col, row)) break;
                if (col == 2) return true;
            }
        }
        return checkDiagonalsWinningCondition();
    }

    private boolean isCurrentUnavailable(char current, int row, int col) {
        return current != board.getBoard()[row][col];
    }

    private boolean checkDiagonalsWinningCondition() {
        char current;
        current = board.getBoard()[0][0];
        if(Character.isLetter(current) && current == board.getBoard()[1][1] && current == board.getBoard()[2][2])
            return true;
        current = board.getBoard()[0][2];
        return Character.isLetter(current) && current == board.getBoard()[1][1] && current == board.getBoard()[2][0];
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayers() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
        plays++;
    }

    public int getPlays() {
        return plays;
    }

}

// winning condition should be checked after 5 chances because 5 chances are essential