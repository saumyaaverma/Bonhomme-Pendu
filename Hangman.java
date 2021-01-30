import java.util.ArrayList;
public class Hangman {

    private String aWord;
    final private int aMaxTries = 5;
    private int aAttemptedTries;
    private ArrayList<Character> aLettersTried;

    public void newHangman(String word) {
        aAttemptedTries = 0;
        aWord = word;
        aLettersTried.clear();
    }

    private void tryLetter(Character c) {
        boolean temp = true;
        for (int i =0; i< aWord.length(); i++) {
            if (aWord.charAt(i) == c) {
                //Letter found, add it to gui
                temp = false;
            }
        }
        if (temp) {
            aLettersTried.add(c);
            aAttemptedTries++;

        }
    }
}

