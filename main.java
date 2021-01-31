import java.io.Console;
import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String line;
        System.out.println("Choose game mode");
        System.out.println("0: Single player");
        System.out.println("1: Multiplayer");
        int version = -1;

        while (version < 0 || version > 1) {
            System.out.println("Select correct number");
            Scanner type = new Scanner(System.in);
            version = type.nextInt();
        }
        if (version == 1) {

            Console console = System.console();
            char[] hiddenWord = console.readPassword("Player 1 enter your word: ");
            line = "";

            for (int i = 0; i < hiddenWord.length; i++) {
                line += hiddenWord[i];
            }

            int numberOfTries = gameHelper(line);

            Console console1 = System.console();
            char[] hiddenWord1 = console1.readPassword("Player 2 enter your word: ");
            line = "";

            for (int i = 0; i < hiddenWord1.length; i++) {
                line += hiddenWord1[i];
            }

            int numberOfTries1 = gameHelper(line);

            if( numberOfTries <  numberOfTries1){
                System.out.println("Player 2 is the winner with only " + numberOfTries + " mistake(s)");
            }
            else if(numberOfTries >  numberOfTries1){
                System.out.println("Player 1 is the winner with only " + numberOfTries1 + " mistake(s)");
            }
            else{
                System.out.println("It's a tie since both players used " + numberOfTries1 + " mistake(s)");
            }
        } else {
            int lines = 0;
            /*file addresses*/
            ArrayList<String> filePaths = new ArrayList<String>();
            filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/food.txt");
            filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/cities.txt");
            filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/compsci.txt");
            filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/countries.txt");
            filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/famouspeople.txt");
            filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/music.txt");
            System.out.println("Enter the number corresponding to the theme for the game");
            System.out.println("0 : Food \n1 : Cities \n2 : Computer Science \n3 : Countries \n4 : Famous People \n5 : Music");

            /*ask for the theme*/
            int index = -1;
            while (index < 0 || index > 5) {
                System.out.println("Select the number");
                Scanner input = new Scanner(System.in);
                index = input.nextInt();
            }
            try {
                /*count the number of lines in the file selected*/
                File file = new File(filePaths.get(index));
                Scanner fileName = new Scanner(file);
                while (fileName.hasNextLine()) {
                    fileName.nextLine();
                    lines++;
                }
                /*select a random line which corresponds to a random word*/
                Random random = new Random();
                int randomInt = random.nextInt(lines);
                line = Files.readAllLines(Paths.get(filePaths.get(index))).get(randomInt);
                fileName.close();
            } catch (Exception e) {
                line = "";
                e.getStackTrace();
            }
            gameHelper(line);
        }


    }

    public static int gameHelper(String line) {
        Hangman hangman = new Hangman(line);
        System.out.println("Enter your guess");

        /*check if word is guessed*/
        /*make Hangman and GUI objects*/
        while (hangman.getAttemptedTries() < hangman.getMaxTries() && !(hangman.wordIsFound())) {
            HangmanGUI.addLimb(hangman.getAttemptedTries());
            HangmanGUI.initialPrint(hangman.getWordFound());
            Scanner letter = new Scanner(System.in);
            String str = letter.next();
            char character = str.charAt(0);
            hangman.tryLetter(character);
        }
        if (hangman.wordIsFound()) {
            HangmanGUI.addLimb(hangman.getAttemptedTries());
            HangmanGUI.initialPrint(hangman.getWordFound());
            System.out.println("You guessed it!");
        } else {
            HangmanGUI.addLimb(6);
            HangmanGUI.initialPrint(hangman.getWordFound());
            System.out.println("You didn't guess it! The word was " + line.toLowerCase());

        }
        return hangman.getAttemptedTries();
    }
}

