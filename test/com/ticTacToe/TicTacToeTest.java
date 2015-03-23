package com.ticTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    @Test
    public void testAddMarkerAddsTheMarkOnTheBoard(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.addMarker(1);
        assertEquals('x',ticTacToe.getBoard()[0][0]);
    }
    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameRow(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.addMarker(1);
        ticTacToe.addMarker(2);
        ticTacToe.addMarker(3);
        assertTrue(ticTacToe.winning());
    }
    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameColumn(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.addMarker(1);
        ticTacToe.addMarker(4);
        ticTacToe.addMarker(7);
        assertTrue(ticTacToe.winning());
    }
}