package com.ticTacToe;

import com.sun.org.apache.xpath.internal.SourceTree;

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
            char input = scanner.next().charAt(0);
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
}
