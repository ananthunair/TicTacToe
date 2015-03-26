package com.ticTacToe;

import java.util.Scanner;

public class GameRunner {

    public void startGame() {
        Board board = new Board();
        Game game = new Game(board);
        game.init();
        Scanner scanner = new Scanner(System.in );
        while(!game.winning() && game.getPlays()<9){
            System.out.println(board.drawBoard());
            System.out.println("Enter Your Choice: ");
            String input = scanner.next();
//            board.addMarker(input, game.getCurrentPlayer());
            if(!game.winning())
                game.switchPlayers();
        }
        System.out.println(board.drawBoard());
        if(game.getPlays() == 9)
            System.out.println("Game Draw.");
        else
            System.out.println("Player "+game.getCurrentPlayer()+" Wins.");
    }

    public boolean isValidPick(String pick) {
        if (pick.length() == 1 && Character.isDigit(pick.toCharArray()[0]))
            return true;
        return false;
    }
}
