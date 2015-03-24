package com.ticTacToe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    TicTacToe ticTacToe;

    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
        ticTacToe.createBoard();
    }

    @Test
    public void testCreateBoardInitialisesTheGameBoard() {
        assertEquals('1', ticTacToe.getBoard()[0][0]);
        assertEquals('2', ticTacToe.getBoard()[0][1]);
        assertEquals('3', ticTacToe.getBoard()[0][2]);
        assertEquals('4', ticTacToe.getBoard()[1][0]);
    }

    @Test
    public void testAddMarkerAddsTheMarkOnTheBoard(){
        ticTacToe.addMarker('1');
        assertEquals('x', ticTacToe.getBoard()[0][0]);
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameRow(){
        ticTacToe.addMarker('1');
        ticTacToe.addMarker('2');
        ticTacToe.addMarker('3');
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameColumn(){
        ticTacToe.addMarker('1');
        ticTacToe.addMarker('4');
        ticTacToe.addMarker('7');
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsFalseIfPlayerAddsMarkerOnDifferentColumn(){
        ticTacToe.addMarker('2');
        ticTacToe.addMarker('4');
        ticTacToe.addMarker('7');
        assertFalse(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnSameDiagonalCell(){
        ticTacToe.addMarker('1');
        ticTacToe.addMarker('5');
        ticTacToe.addMarker('9');
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testWinningReturnsTrueIfPlayerAddsMarkerOnTheOppositeDiagonalCell(){
        ticTacToe.addMarker('3');
        ticTacToe.addMarker('5');
        ticTacToe.addMarker('7');
        assertTrue(ticTacToe.winning());
    }

    @Test
    public void testInitCreatesTheBoardAndSetsTheCurrentPlayerToPlayer1(){
        ticTacToe.init();
        assertEquals(1,ticTacToe.getCurrentPlayer(),0.001);
    }
    @Test
    public void testSwitchPlayersSwitchesTheCurrentPlayer(){
        ticTacToe.init();
        ticTacToe.switchPlayers();
        assertEquals(2, ticTacToe.getCurrentPlayer());
        ticTacToe.switchPlayers();
        assertEquals(1, ticTacToe.getCurrentPlayer());
    }
    @Test
    public void testDrawBoardDraws3By3Board(){
        String expected = "Game board:"+System.lineSeparator()
                +" [1] [2] [3]"+System.lineSeparator()
                +" [4] [5] [6]"+System.lineSeparator()
                +" [7] [8] [9]"+System.lineSeparator();
        assertEquals(expected,ticTacToe.drawBoard());
    }
}