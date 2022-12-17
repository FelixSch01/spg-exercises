package at.spengergasse.game;

import at.spengergasse.ensurer.Ensurer;
import at.spengergasse.ensurer.HangmanEnsurer;

public class Hangman
{
    // attributes
    // wanted word          "spengergasse"
    // guessed word         "***********"
    // guessed characters   "s"
    // faults               1
    // MAX FAULT            7

    // private String wordList = "Starwars Spengergasse ..."

    public static final String DEFAULT = "spengergasse";

    private String wantedWord;
    private StringBuilder guessedWord;
    private StringBuilder guessedCharacters;
    private int faults;
    private int corrects;

    private final int MAX_FAULTS = 7;

    public enum GAME_STATE
    {
        WON, LOST, KEEP_PLAYING
    }

    public Hangman(String wantedWord)
    {
        String stars = "*".repeat(wantedWord.length());

        this.wantedWord = Ensurer.ensureNotNullNotBlank(wantedWord.toLowerCase(), DEFAULT);
        this.guessedWord = new StringBuilder(stars);
        this.guessedCharacters = new StringBuilder();
        this.faults = 0;
        this.corrects = 0;
    }

    // ---- getter ------
    public String getGuessedWord() {
        return guessedWord.toString();
    }

    public String getGuessedCharacters() {
        return guessedCharacters.toString();
    }

    public int getFaults() {
        return faults;
    }

    public int getCorrects() {
        return corrects;
    }

    public GAME_STATE getGameState()
    {
        if (faults >= MAX_FAULTS)
            return GAME_STATE.LOST;

        // if (wantedWord.equals(guessedWord.toString()))
        if (corrects == wantedWord.length())
            return GAME_STATE.WON;

        return GAME_STATE.KEEP_PLAYING;
    }

    public void guessNextCharacter(char nextCharacter)
    {
        char nextCharacterLower = Character.toLowerCase(nextCharacter);

        HangmanEnsurer.ensureValidGameState(this);

        if (! containsInGuessed(nextCharacterLower))
        {
            updateGameState(nextCharacterLower);
        }
        else {
            System.out.printf("Fehler: Das gleiche Zeichen wurde schon eingegeben (%c)", nextCharacter);
        }

    }

    public boolean containsInGuessed(char nextCharacter)
    {
        return guessedCharacters.indexOf(String.valueOf(nextCharacter)) >= 0;
    }

    private void updateGameState(char nextCharacter)
    {
        guessedCharacters.append(nextCharacter);

        int oldCorrects = corrects;

        // for each character
        for (int i = 0; i < wantedWord.length(); i++)
        {
            // matched wanted[i] with nextCharacter?
            if (wantedWord.charAt(i) == nextCharacter)
            {
                guessedWord.setCharAt(i, nextCharacter);
                corrects++;
            }
        }

       if (oldCorrects == corrects)
           faults++;
    }

    public String toString()
    {

         // Guessed Word: s*****ss*
         // Guessed Characters:
         // Tries left: 2
         // Draw Hangman

        return """
            Guessed Word: %s
            Guessed Characters: %s
            Tries Left: %d
            %s
            """.formatted(guessedWord, guessedCharacters,
            MAX_FAULTS - faults, getHangman());
    }

    private String getHangman()
    {
        // Java 14 switch expression
        return switch (faults)
            {
                case 0 -> "";
                case 1 -> hangman1();
                case 2 -> hangman2();
                case 3 -> hangman3();
                case 4 -> hangman4();
                case 5 -> hangman5();
                case 6 -> hangman6();
                default -> hangman7();
            };
    }

    private String hangman1()
    {
        return """
              +---+
              |   |
                  |
                  |
                  |
                  |
            =========
                  """;
    }

    private String hangman2()
    {
        return """
              +---+
              |   |
              O   |
                  |
                  |
                  |
            =========
                  """;
    }

    private String hangman3()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|   |
                  |
            =========
                  """;
    }

    private String hangman4()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
                  |
            =========
                  """;
    }

    private String hangman5()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
                  |
            =========
                  """;
    }

    private String hangman6()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
             /    |
            =========
                  """;
    }

    private String hangman7()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
             / \\  |
            =========
                  """;
    }
}
