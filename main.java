import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        int lines = 0;
        ArrayList<String> filePaths = new ArrayList<String>();
        filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/food.txt");
        filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/cities.txt");
        filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/compsci.txt");
        filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/countries.txt");
        filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/famouspeople.txt");
        filePaths.add("/Users/apple/IdeaProjects/Bonhomme Pendu/src/music.txt");
        System.out.println("Enter the number corresponding to the theme for the game");
        System.out.println("0 : Food \n1 : Cities \n2 : Computer Science \n3 : Countries \n4 : Famous People \n5 : Music");
        int index = - 1;
        while(index < 0 || index > 5) {
            System.out.println("Select the number");
            Scanner input = new Scanner(System.in);
            index = input.nextInt();
        }
        try {
            File file = new File(filePaths.get(index));
            Scanner fileName = new Scanner(file);
            while(fileName.hasNextLine()) {
                fileName.nextLine();
                lines++;
            }
            Random random = new Random();
            int randomInt = random.nextInt(lines);
            String line = Files.readAllLines(Paths.get(filePaths.get(index))).get(randomInt);
            System.out.println(line);
            fileName.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}


