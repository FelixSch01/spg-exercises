package FAA2022_23.Hangman;

import java.util.Scanner;

public class Hangman {
    private static int health;
    private static StringBuilder guessedChars;
    private static String secret;
    private static StringBuilder currentWord;
    private static int counter;

    public static void main(String[] args) {
        /*
            health (int)
            list of guesses (char)
            secret (String)
            word (StringBuilder)
            counter (int)
         */
        health = 7;
        guessedChars = new StringBuilder();
        secret = "lttstoredotcom";
        currentWord = new StringBuilder("_".repeat(secret.length()));
        counter = 0;

        System.out.println("Welcome to Hangman. If you lose you will hang, man.");

        while(!isGameOver()) {
            printHangman();
            System.out.println(currentWord);
            if(!guessedChars.toString().equals("")) {
                System.out.printf("You already used following characters: %s%n", guessedChars);
            }

            Scanner cmdLine = new Scanner(System.in);
            System.out.print("Guess a letter: ");
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
        if(health == 0) {
            printHangman();
        }
        else {
            System.out.println("""
                    db    db  .d88b.  db    db   db   d8b   db  .d88b.  d8b   db   db   db   db 
                    `8b  d8' .8P  Y8. 88    88   88   I8I   88 .8P  Y8. 888o  88   88   88   88 
                     `8bd8'  88    88 88    88   88   I8I   88 88    88 88V8o 88   YP   YP   YP 
                       88    88    88 88    88   Y8   I8I   88 88    88 88 V8o88                
                       88    `8b  d8' 88b  d88   `8b d8'8b d8' `8b  d8' 88  V888   db   db   db 
                       YP     `Y88P'  ~Y8888P'    `8b8' `8d8'   `Y88P'  VP   V8P   YP   YP   YP """);
        }
    }

    public static boolean isGameOver() {
        return (health == 0 || currentWord.toString().equals(secret));
    }

    public static void printHangman() {
        switch (health) {
            case 6:
                System.out.println("""
                                    88                                                                            
                                    88         
                                    88         
                                    88,dPPYba, 
                                    88P'    "8a
                                    88       88
                                    88       88
                                    88       88
                                    
                                    """);
                break;
            case 5:
                System.out.println("""
                                   88
                                   88
                                   88,dPPYba,  ,adPPYYba, 
                                   88P'    "8a ""     `Y8 
                                   88       88 ,adPPPPP88 
                                   88       88 88,    ,88 
                                   88       88 `"8bbdP"Y8 
                                                         
                                                         """);
                break;
            case 4:
                System.out.println("""
                                    88
                                    88
                                    88,dPPYba,  ,adPPYYba, 8b,dPPYba, 
                                    88P'    "8a ""     `Y8 88P'   `"8a
                                    88       88 ,adPPPPP88 88       88
                                    88       88 88,    ,88 88       88
                                    88       88 `"8bbdP"Y8 88       88
                                    
                                    """);
                break;
            case 3:
                System.out.println("""
                                    88
                                    88
                                    88,dPPYba,  ,adPPYYba, 8b,dPPYba,   ,adPPYb,d8
                                    88P'    "8a ""     `Y8 88P'   `"8a a8"    `Y88
                                    88       88 ,adPPPPP88 88       88 8b       88
                                    88       88 88,    ,88 88       88 "8a,   ,d88
                                    88       88 `"8bbdP"Y8 88       88  `"YbbdP"Y8
                                                                        aa,    ,88
                                                                         "Y8bbdP" """);
                break;
            case 2:
                System.out.println("""
                                    88
                                    88
                                    88,dPPYba,  ,adPPYYba, 8b,dPPYba,   ,adPPYb,d8 88,dPYba,,adPYba, 
                                    88P'    "8a ""     `Y8 88P'   `"8a a8"    `Y88 88P'   "88"    "8a
                                    88       88 ,adPPPPP88 88       88 8b       88 88      88      88
                                    88       88 88,    ,88 88       88 "8a,   ,d88 88      88      88
                                    88       88 `"8bbdP"Y8 88       88  `"YbbdP"Y8 88      88      88
                                                                        aa,    ,88
                                                                         "Y8bbdP" """);
                break;
            case 1:
                System.out.println("""
                                    88
                                    88
                                    88,dPPYba,  ,adPPYYba, 8b,dPPYba,   ,adPPYb,d8 88,dPYba,,adPYba,  ,adPPYYba,
                                    88P'    "8a ""     `Y8 88P'   `"8a a8"    `Y88 88P'   "88"    "8a ""     `Y8
                                    88       88 ,adPPPPP88 88       88 8b       88 88      88      88 ,adPPPPP88
                                    88       88 88,    ,88 88       88 "8a,   ,d88 88      88      88 88,    ,88
                                    88       88 `"8bbdP"Y8 88       88  `"YbbdP"Y8 88      88      88 `"8bbdP"Y8
                                                                        aa,    ,88
                                                                         "Y8bbdP" """);
                break;
            case 0:
                System.out.println("""
                                    88
                                    88
                                    88,dPPYba,  ,adPPYYba, 8b,dPPYba,   ,adPPYb,d8 88,dPYba,,adPYba,  ,adPPYYba, 8b,dPPYba, 
                                    88P'    "8a ""     `Y8 88P'   `"8a a8"    `Y88 88P'   "88"    "8a ""     `Y8 88P'   `"8a
                                    88       88 ,adPPPPP88 88       88 8b       88 88      88      88 ,adPPPPP88 88       88
                                    88       88 88,    ,88 88       88 "8a,   ,d88 88      88      88 88,    ,88 88       88
                                    88       88 `"8bbdP"Y8 88       88  `"YbbdP"Y8 88      88      88 `"8bbdP"Y8 88       88
                                                                        aa,    ,88
                                                                         "Y8bbdP" """);
                break;
            default:
                System.out.println("""
                        
                        
                        
                        
                        
                        
                        
                        
                        """);
                break;
        }
    }
}
