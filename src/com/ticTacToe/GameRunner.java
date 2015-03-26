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
        Scanner scanner = new Scanner(System.in );
        gamePlay(scanner);
        displayResult();
    }

    private void displayResult() {
        System.out.println(board.drawBoard());
        if(game.getPlays() == 9)
            System.out.println("Game Draw.");
        else
            System.out.println("Player "+game.getCurrentPlayer()+" Wins.");
    }

    private void gamePlay(Scanner scanner) {
        while(!game.winning() && game.getPlays()<9){
            boolean isValid = false;
            System.out.println(board.drawBoard());
            int input = getPick(scanner, isValid);
            board.addMarker(input, game.getCurrentPlayer());
            if(!game.winning())
                game.switchPlayers();
        }
    }

    private int getPick(Scanner scanner, boolean isValid) {
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
        if (1 <= pick && pick <=9 && !board.isSelected(pick))
            return true;
        return false;
    }
}
