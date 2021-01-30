import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;

public class main {
    public static void main(String[] args) {
        int lines = 0;
        try {
            File file = new File("/Users/apple/IdeaProjects/Bonhomme Pendu/src/food.txt");
            Scanner fileName = new Scanner(file);
            while(fileName.hasNextLine()) {
                fileName.nextLine();
                lines++;
            }
            Random random = new Random();
            int randomInt = random.nextInt(lines);
            String line = Files.readAllLines(Paths.get("/Users/apple/IdeaProjects/Bonhomme Pendu/src/food.txt")).get(randomInt);
            System.out.println(line);
            fileName.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}


