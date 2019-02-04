import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordStatIndex {
    public static void main(String[] args) {

        String text;

        try {
            Scanner reader = new Scanner(new File(args[0]));
            StringBuilder textBuilder = new StringBuilder();
            while (reader.hasNext()) {
                textBuilder.append(reader.next().toLowerCase().replaceAll("\\p{Punct}", "")).append(" ");
//-------------------------------------------------------
            }
            text = textBuilder.toString();
            reader.close();
            System.out.println(text);
            String[] textArray = text.split(" ");
            Integer[] textCount = new Integer[textArray.length];

            PrintWriter out = new PrintWriter(args[1]);

            for (int i = 0; i < textArray.length; i++) {
                if (textArray[i].equals(" ")) continue;
                textCount[i] = 1;
                out.print(textArray[i] + " ");
                for (int j = i + 1; j < textArray.length; j++) {
                    if (textArray[j].equals(textArray[i])) {
                        textCount[i]++;
                        textArray[j] = " ";
                    }
                }
                out.println(textCount[i]);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
