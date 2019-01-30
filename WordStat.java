import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordStat {
    public static void main(String[] args) {

        try {
            Scanner reader = new Scanner(new File("inputWordStat.txt"));
            while (reader.hasNext()) {
                System.out.println(reader.next().toLowerCase().replaceAll("\\p{Punct}", ""));
//-------------------------------------------------------

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
