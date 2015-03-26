package com.ticTacToe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    TicTacToe ticTacToe;
    Board board ;
    @Before
    public void setUp() throws Exception {
        this.board = new Board();
        this.ticTacToe = new TicTacToe(board);
        ticTacToe.init();
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameRow(){
        board.addMarker('1', 1);
        board.addMarker('2', 1);
        board.addMarker('3', 1);
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameColumn(){
        board.addMarker('1', 1);
        board.addMarker('4', 1);
        board.addMarker('7', 1);
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsFalseIfPlayerAddsMarkerOnDifferentColumn(){
        board.addMarker('2', 1);
        board.addMarker('4', 1);
        board.addMarker('7', 1);
        assertFalse(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameDiagonalCell(){
        board.addMarker('1', 1);
        board.addMarker('5', 1);
        board.addMarker('9', 1);
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnTheOppositeDiagonalCell(){
        board.addMarker('3', 1);
        board.addMarker('5', 1);
        board.addMarker('7', 1);
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testInitCreatesTheBoardAndSetsTheCurrentPlayerToPlayer1(){
        assertEquals(1,ticTacToe.getCurrentPlayer(),0.001);
    }

    @Test
    public void testSwitchPlayersSwitchesTheCurrentPlayer(){
        ticTacToe.switchPlayers();
        assertEquals(2, ticTacToe.getCurrentPlayer());
        ticTacToe.switchPlayers();
        assertEquals(1, ticTacToe.getCurrentPlayer());
    }
}