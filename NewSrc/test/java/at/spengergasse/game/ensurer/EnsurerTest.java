package at.spengergasse.game.ensurer;
import at.spengergasse.game.Hangman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnsurerTest {
    @Test
    public void guessNextCharacters_shouldWorkIfUserSuppliesContainingCharacter() {
        // GIVEN: The user starts a hangman game with wanted word of "Spengergasse"
        Hangman game = new Hangman("Spengergasse");

        // WHEN: The user guesses 's' as a next character
        game.guessNextCharacter('S');
        
        // THEN: The 'faults' remain 0
        // AND: The 'corrects' increases by 3
        // AND: The 'guessedWord' is equal to s********ss*
        // AND: The 'guessedCharacters' is equal to 's'
        assertEquals(0, game.getFaults());
        assertEquals(3, game.getCorrects());
        assertEquals("s********ss*", game.getGuessedWord());
        assertEquals("s", game.getGuessedCharacters());
        


    }

    @Test
    public void guessNextCharacters_shouldWorkIfUserSuppliesNotContainingCharacter() {
        // GIVEN: The user starts a hangman game with wanted word of "Spengergasse"
        Hangman game = new Hangman("Spengergasse");

        // WHEN: Whe user guesses 'B' as a next character
        game.guessNextCharacter('B');

        // THEN: The faults are 1
        // AND: The corrects are 0
        // AND: The 'guessWords' is equal to ************
        // AND: The 'guessedCharacters'is equal to 'b'
        assertEquals(1, game.getFaults());
        assertEquals(0, game.getCorrects());
        assertEquals("************", game.getGuessedWord());
        assertEquals("b", game.getGuessedCharacters());
        
    }
}
