package com.ticTacToe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {
    Game game;
    Board board ;
    @Before
    public void setUp() throws Exception {
        this.board = new Board();
        this.game = new Game(board);
        game.init();
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameRow(){
        board.addMarker(1, 1);
        board.addMarker(2, 1);
        board.addMarker(3, 1);
        assertTrue(game.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameColumn(){
        board.addMarker(1, 1);
        board.addMarker(4, 1);
        board.addMarker(7, 1);
        assertTrue(game.winning());
    }

    @Test
    public void testWinningReturnsFalseIfPlayerAddsMarkerOnDifferentColumn(){
        board.addMarker(2, 1);
        board.addMarker(4, 1);
        board.addMarker(7, 1);
        assertFalse(game.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameDiagonalCell(){
        board.addMarker(1, 1);
        board.addMarker(5, 1);
        board.addMarker(9, 1);
        assertTrue(game.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnTheOppositeDiagonalCell(){
        board.addMarker(3, 1);
        board.addMarker(5, 1);
        board.addMarker(7, 1);
        assertTrue(game.winning());
    }

    @Test
    public void testInitCreatesTheBoardAndSetsTheCurrentPlayerToPlayer1(){
        assertEquals(1, game.getCurrentPlayer(),0.001);
    }

    @Test
    public void testSwitchPlayersSwitchesTheCurrentPlayer(){
        game.switchPlayers();
        assertEquals(2, game.getCurrentPlayer());
        game.switchPlayers();
        assertEquals(1, game.getCurrentPlayer());
    }
}