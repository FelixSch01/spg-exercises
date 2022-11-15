package FAA2022_23.Hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        /*
            health (int)
            list of guesses (char)
            secret (String)
            word (StringBuilder)
            counter (int)
         */
        int health = 7;
        StringBuilder guessedChars = new StringBuilder();
        String secret = "lttstoredotcom";
        StringBuilder currentWord = new StringBuilder("_".repeat(secret.length()));
        int counter = 0;

        while(true) {
            System.out.println(currentWord);

            Scanner cmdLine = new Scanner(System.in);
            char guess = cmdLine.nextLine().toLowerCase().charAt(0);

            if(guessedChars.toString().contains(String.valueOf(guess))) {
                System.out.println("Sry. You already used that one.");
                continue;
            }
            else {
                guessedChars.append(guess);
                if(secret.contains(String.valueOf(guess))) {
                    for(int i = 0; i < secret.length(); i++) {
                        if(secret.charAt(i) == guess) {
                            currentWord.setCharAt(i, guess);
                        }
                    }
                }
                else {
                    health--;
                    System.out.println("You are fucking wrong!!");

                }
            }
        }
    }
}
