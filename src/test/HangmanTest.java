package test;

import main.Hangman;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HangmanTest {
    private Hangman hangman;
    @Before
    public void setUp(){
        hangman = new Hangman();
        hangman.start("APPLE");
    }
    @Test
    public void should_start_game() {
        assertEquals(12, hangman.tries());
        assertEquals(5, hangman.length());
        assertEquals("AEIOU", hangman.used());
        assertEquals("A___E", hangman.problem());
    }
    @Test
    public void should_able_try_correct_char() {
        boolean matched = hangman.tryChar('P');
        assertTrue(matched);
        assertEquals(12, hangman.tries());
        assertEquals(5, hangman.length());
        assertEquals("AEIOUP", hangman.used());
        assertEquals("APP_E", hangman.problem());
    }
    @Test
    public void should_able_try_wrong_char() {
        boolean matched = hangman.tryChar('K');
        assertFalse(matched);
        assertEquals(11, hangman.tries());
        assertEquals("AEIOUK", hangman.used());
        assertEquals("A___E", hangman.problem());
    }
    @Test
    public void should_win_game() {
        hangman.tryChar('P');
        hangman.tryChar('L');
        assertTrue(hangman.hasWon());
    }
    @Test
    public void should_lose_game() {
        for (int i = 0; i < 12; i++) {
            hangman.tryChar('K');
        }
        assertTrue(hangman.gameOver());

    }

}
