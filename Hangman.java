import java.util.ArrayList;
public class Hangman {
    
    /* declaring the attributes*/
    private String aWord;
    final private int aMaxTries = 6;
    private int aAttemptedTries;
    private ArrayList<Character> aLettersTried;
    private Character[] aWordFound;

    
    /*the constructor*/
    public Hangman(String word) {
        aAttemptedTries = 0;
        aWord = word;
        aLettersTried = new ArrayList<Character>();
        aWordFound= new Character[word.length()];
        for (int i =0; i< word.length(); i++) {
            if (aWord.charAt(i) == ' ') {
                aWordFound[i] = (' ');
            }
            else{
                aWordFound[i] = ('_');
            }
        }
    }
    
    /* Checks if the letter is present in the word*/
    public void tryLetter(Character c) {
    	boolean tried = false;
    	for (int i=0; i< aLettersTried.size(); i++) {
    		if (Character.toLowerCase(aLettersTried.get(i)) == Character.toLowerCase(c)) {
    			System.out.println("Letter was already tried, guess again ");
    			tried = true;
    		}
    	}
    	if (!tried) {
    		boolean temp = true;
    		for (int i =0; i< aWord.length(); i++) {
    			if (Character.toLowerCase(aWord.charAt(i)) == Character.toLowerCase(c)) {
    				//Letter found, add it to gui
    				aWordFound[i] = c;
    				temp = false;
    			}
    		}
    		if (temp) {
    			aLettersTried.add(c);
    			aAttemptedTries++;

    		}
    	}
    }
    
    public int getAttemptedTries() {
        return aAttemptedTries;
    }

    public int getMaxTries() {
        return aMaxTries;
    }

    /*checks if word is correctly guessed*/
    public boolean wordIsFound() {
        boolean ans = true;
        for (int i=0; i < aWord.length(); i++) {
            if (!(Character.toLowerCase(aWord.charAt(i)) == Character.toLowerCase(aWordFound[i]))) {
                ans = false;
            }
        }

        return ans;
    }

    public Character[] getWordFound(){
        return aWordFound;
    }

}
