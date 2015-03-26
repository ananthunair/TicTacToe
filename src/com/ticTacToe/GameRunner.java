package com.ticTacToe;

import java.util.Scanner;

public class GameRunner {
    Board board;

    public GameRunner(Board board) {
        this.board = board;
    }

    public void startGame() {
        Game game = new Game(board);
        game.init();
        Scanner scanner = new Scanner(System.in );
        int input = 0;
        while(!game.winning() && game.getPlays()<9){
            boolean isValid = false;
            System.out.println(board.drawBoard());
            while(!isValid){
                System.out.println("Enter Your Choice: ");
                input = scanner.nextInt();
                isValid = isValidPick(input) ? true : false;
                if(!isValid)
                    System.out.println("Invalid Pick!");
            }
            board.addMarker(input, game.getCurrentPlayer());
            if(!game.winning())
                game.switchPlayers();
        }
        System.out.println(board.drawBoard());
        if(game.getPlays() == 9)
            System.out.println("Game Draw.");
        else
            System.out.println("Player "+game.getCurrentPlayer()+" Wins.");
    }

    public boolean isValidPick(int pick) {
        if (1 <= pick && pick <=9 && !board.isSelected(pick))
            return true;
        return false;
    }
}
