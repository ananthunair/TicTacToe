package com.ticTacToe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {
    GameRunner gameRunner;
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        this.gameRunner = new GameRunner(board);
    }

    @Test
    public void testIsValidPickReturnsTrueIfNumberIsGiven(){
        assertTrue(gameRunner.board.isValidPick(1));
    }

    @Test
    public void testIsValidPickReturnsFalseIfNumberIs10(){
        assertFalse(gameRunner.board.isValidPick(10));
    }

    @Test
    public void testIsValidPickReturnsFalseIfNumberIs0(){
        assertFalse(gameRunner.board.isValidPick(0));
    }

    @Test
    public void testIsValidPickReturnsFalseIfNumberIsAlreadySelected(){
        board.addMarker(1,1);
        assertFalse(gameRunner.board.isValidPick(1));
    }
}