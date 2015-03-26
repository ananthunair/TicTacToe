package com.ticTacToe;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {
    @Test
    public void testIsValidPickReturnsFalseIfCharacterIsGiven(){
        assertFalse(new GameRunner().isValidPick("x"));
    }
    @Test
    public void testIsValidPickReturnsTrueIfNumberIsGiven(){
        assertTrue(new GameRunner().isValidPick("1"));
    }
    @Test
    public void testIsValidPickReturnsFalseIfNumberIs10(){
        assertFalse(new GameRunner().isValidPick("10"));
    }

}