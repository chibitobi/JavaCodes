import java.util.Scanner;
import java.io.File;

public class WordCounts {

    public static void main(String [] args) throws Exception{
        System.out.println("Word Counts program");

        File fp = new File("text.txt");
        Scanner scanner = new Scanner(fp);
        Integer words = 0;
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            words += line.split(" ").length;
        }
        System.out.println("This file contains " + words + " words");
    }

}
