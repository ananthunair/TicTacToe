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
                if (isDigit(row, col)) break;
                if (col == 0)
                    current = getBoardAt(row, col);
                else if (isCurrentUnavailable(current, row, col)) break;
                if (col == 2) return true;
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (isDigit(col, row)) break;
                if (col == 0)
                    current = getBoardAt(col, row);
                else if (isCurrentUnavailable(current, col, row)) break;
                if (col == 2) return true;
            }
        }
        return checkDiagonalsWinningCondition();
    }

    private char getBoardAt(int row, int col) {
        return board.getBoard()[row][col];
    }

    private boolean isCurrentUnavailable(char current, int row, int col) {
        return current != getBoardAt(row, col);
    }

    private boolean isDigit(int row, int col) {
        return Character.isDigit(getBoardAt(row, col));
    }

    private boolean checkDiagonalsWinningCondition() {
        char current;
        current = getBoardAt(0, 0);
        if(Character.isLetter(current) && current == getBoardAt(1, 1) && current == getBoardAt(2, 2))
            return true;
        current = getBoardAt(0, 2);
        return Character.isLetter(current) && current == getBoardAt(1, 1) && current == getBoardAt(2, 0);
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
