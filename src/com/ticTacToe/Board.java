package com.ticTacToe;

public class Board {
    public char[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        createBoard();
    }

    public char[][] getBoard() {
        return this.board;
    }

    public void createBoard() {
        int number = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Character.forDigit(++number, 10);
            }
        }
    }

    public String stringRepresentationOfBoard() {
        StringBuilder builder = new StringBuilder("Game board:" + System.lineSeparator());
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)
                builder.append(" [").append(board[row][col]).append("]");
              builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    protected boolean addMarker(int position, int currentPlayer) {
        int row = (position - 1)/size;
        int col = (position - 1)%size;
        if (!isSelected(position)) {
            board[row][col] = (currentPlayer == 1) ? 'x' : 'o';
            return true;
        }
        return false;
    }

    private boolean isSelected(int position) {
        int row = (position - 1)/size;
        int col = (position - 1)%size;
        return (board[row][col] != Character.forDigit(position,10));
    }

    public boolean isValidPick(int pick) {
        return (pick >= 1 && pick <= 9 && !isSelected(pick));
    }

    public boolean areAllCellsFilled(int plays) {
        return plays == size*size;
    }
}
