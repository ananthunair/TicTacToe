package com.ticTacToe;

import java.util.Scanner;

public class GameRunner {
    private Board board;
    private Game game;

    public GameRunner(Board board) {
        this.board = board;
        this.game = new Game(board);
    }

    public void startGame() {
        game.init();
        Scanner scanner = new Scanner(System.in);
        gamePlay(scanner);
        displayResult();
    }

    private void displayResult() {
        System.out.println(board.drawBoard());
        if(game.getPlays() == 9)
            declareGameDraw();
        else
            declareWinner();
    }

    private void declareGameDraw() {
        System.out.println("Game Over - Draw.");
    }

    private void declareWinner() {
        System.out.println("Game Over - Player "+game.getCurrentPlayer()+" Wins.");
    }

    private void gamePlay(Scanner scanner) {
        while(!game.winning() && game.getPlays()<9){
            System.out.println(board.drawBoard());
            int input = getPick(scanner);
            board.addMarker(input, game.getCurrentPlayer());
            if(!game.winning())
                game.switchPlayers();
        }
    }

    private int getPick(Scanner scanner) {
        boolean isValid = false;
        int input = 0;
        while(!isValid){
            System.out.println("Enter Your Choice: ");
            input = scanner.nextInt();
            isValid = isValidPick(input);
            if(!isValid)
                System.out.println("Invalid Pick!");
        }
        return input;
    }

    public boolean isValidPick(int pick) {
        return (pick >= 1 && pick <= 9 && !board.isSelected(pick));
    }
}