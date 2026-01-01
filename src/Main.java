import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> wordsList = new ArrayList<>();
        Scanner sc = new Scanner(new File("hangmanWordsList.txt"));
        Scanner keyboard = new Scanner(System.in);
        String word;
        System.out.println("1 or 2 players?");
        String playerCount = keyboard.nextLine();
        if (playerCount.equals("1")) {
            while (sc.hasNextLine()) {
                wordsList.add(sc.nextLine());
            }

            Random rand = new Random();
            word = wordsList.get(rand.nextInt(wordsList.size()));
            // System.out.println(word);   //printing the word

        } else {
            System.out.println("Player 1, choose your word!!");
            word = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ready for Player 2, Good luck!!");
            System.out.println("Ready for Player 2, Good luck!!");
        }


        List<Character> playerGuesses = new ArrayList<>();
        int wrongCount = 0;
        while (true) {
            printHangman(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!!!");
                System.out.println("The word was: " + word);
                break;
            }

            printWordState(word, playerGuesses);
            if(!getPlayerGuess(keyboard, playerGuesses, word)) {
                wrongCount++;
            }


            if(printWordState(word, playerGuesses)) {
                System.out.println("Congrats! You won!");
                break;
            }
            System.out.println("Please enter your guess for the word:");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("Congrats! You won!");
                break;
            } else {
                System.out.println("Nope! Try again.");
            }
        }

    }

    private static void printHangman(int wrongCount) {
        System.out.println(" ------- ");
        System.out.println(" |     | ");

        // Head
        if (wrongCount >= 1) {
            System.out.println(" O   ");
        }

        // Arms
        if (wrongCount >= 2) {
            System.out.print("\\"); // print (stay on line)
            if (wrongCount >= 3) {
                System.out.println(" /"); // println (move to next line)
            } else {
                System.out.println(); // <- A small fix: If only 1 arm, move to next line anyway
            }
        } else {
            System.out.println(); // Empty line for body space
        }

        // Body
        if (wrongCount >= 4) {
            System.out.println(" |   ");
        }

        // Legs
        if (wrongCount >= 5) {
            System.out.print("/"); // print (stay on line)
            if (wrongCount >= 6) {
                System.out.println(" \\"); // println (move to next line)
            } else {
                System.out.println(); // <- A small fix: If only 1 leg, move to next line!
            }
        } else {
            System.out.println(); // Empty line for leg space
        }
    }

    private static boolean getPlayerGuess(Scanner keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Please enter a letter: ");
        String letterGuess = keyboard.nextLine();

        // Take the first character just in case they type a whole word
        char guess = letterGuess.charAt(0);
        playerGuesses.add(guess);

        // Check if the word contains the character
        // -1 means "not found", so anything else means "found"
        return word.indexOf(guess) != -1;
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (correctCount == word.length());
    }
}
