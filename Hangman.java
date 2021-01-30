import java.util.ArrayList;
public class Hangman {

    private String aWord;
    final private int aMaxTries = 6;
    private int aAttemptedTries;
    private ArrayList<Character> aLettersTried;
    private ArrayList<Character> aWordFound;

    public Hangman(String word) {
        aAttemptedTries = 0;
        aWord = word;
        aLettersTried = new ArrayList<Character>();
        aWordFound= new ArrayList<Character>(word.length());
        for (int i =0; i< word.length(); i++) {
    		if (aWord.charAt(i) == ' ') {
    			aWordFound.set(i, ' ');
    		}
    	}
    }

    public void tryLetter(Character c) {
        boolean temp = true;
        for (int i =0; i< aWord.length(); i++) {
            if (aWord.charAt(i) == c) {
                //Letter found, add it to gui
                aWordFound.set(i, c);
                temp = false;
            }
        }
        if (temp) {
            aLettersTried.add(c);
            aAttemptedTries++;
            if (aAttemptedTries >= aMaxTries) {
                //Print the gui, quit the game, maybe print the answer
            }

        }
    }
}
