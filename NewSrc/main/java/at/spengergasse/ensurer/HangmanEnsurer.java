package at.spengergasse.ensurer;
import at.spengergasse.game.Hangman;
import static at.spengergasse.ensurer.Ensurer.ensureNotNull;

public abstract class HangmanEnsurer {

    public static void ensureValidGameState(Hangman hangman) {

        ensureNotNull(hangman, "hangman");

        if (hangman.getGameState() != Hangman.GAME_STATE.KEEP_PLAYING)
            throw new IllegalStateException("Guessing a character only possible while playing");
        
    }
}
