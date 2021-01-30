public class HangmanGUI {

    /*the hangman*/
    public static void addLimb(int i) {
        if (i == 0) System.out.println("________\n |     |\n |\n |\n |\n |\n |");

        if (i == 1) System.out.println("________\n |     |\n |     O\n |\n |\n |\n |");

        if (i == 2) System.out.println("________\n |     |\n |     O\n |     |\n |     |\n |     |\n |      \n |");

        if (i == 3) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|\n |     |\n |      \n |");

        if (i == 4) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|/\n |     |\n |      \n |");

        if (i == 5) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|/\n |     |\n |    /      \n |");

        if (i == 6) System.out.println("________\n |     |\n |     O\n |     |\n |    \\|/\n |     |\n |    / \\\n |");
    }

    /*printing the word*/
    public static void initialPrint(Character[] letters) {
        System.out.println();
        for (int i =0; i < letters.length; i++) {
            System.out.print(Character.toLowerCase(letters[i]));
        }
        System.out.println();
    }

}
