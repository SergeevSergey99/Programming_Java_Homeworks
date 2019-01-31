import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordStat {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder();

        try {
            Scanner reader = new Scanner(new File("inputWordStat.txt"));
            while (reader.hasNext()) {
                text.append(reader.next().toLowerCase().replaceAll("\\p{Punct}", "")).append(" ");
//-------------------------------------------------------
                }
            reader.close();
            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
