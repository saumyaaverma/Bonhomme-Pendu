public class HangmanGUI {


    public void printBird() {
        System.out.println();
    }


    public static void addLimb(int i) {
        if (i == 0) System.out.println("________\n |     |\n |\n |\n |\n |\n |");

        if (i == 1) System.out.println("________\n |     |\n |     O\n |\n |\n |\n |");

        if (i == 2) System.out.println("________\n |     |\n |     O\n |     |\n |     |\n |     |\n |      \n |");

        if (i == 3) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|\n |     |\n |      \n |");

        if (i == 4) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|/\n |     |\n |      \n |");

        if (i == 5) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|/\n |     |\n |    /      \n |");

        if (i == 6) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|/\n |     |\n |    / \\\n |");
    }


    public static void letterDisplay(char[] word) {

        for (int i = 0; i < word.length; i++) {
            System.out.print(" ");
        }


    }



    public static void main(String[] args) {
        addLimb(0);
        addLimb(1);
        addLimb(2);
        addLimb(3);
        addLimb(4);
        addLimb(5);
        addLimb(6);


        char[] words = {'h', 'a', 'n', 'g', 'm', 'a', 'n'};
        letterDisplay(words);
    }

}
