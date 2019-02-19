import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordStatIndex {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();


        try {
            Scanner reader = new Scanner(new File("inputWordStat.txt"));
            int i = 0;

            while (reader.hasNext()) {
                i++;
                String text;
                text = reader.next().toLowerCase().replaceAll("\\p{Punct}", "");
                int index = arrayList.indexOf("\n" + text);
                if (arrayList.contains("\n" + text)) {
                    arrayList.set(1 + index, String.valueOf(Integer.parseInt(arrayList.get(index + 1)) + 1));
                    arrayList.set(index + 2, arrayList.get(index + 2) + " " + i);
                } else {
                    arrayList.add("\n" + text);
                    arrayList.add(String.valueOf(1));
                    arrayList.add(String.valueOf(i));
                }

            }

            PrintWriter out = new PrintWriter("outputWordStatIndex.txt");//args[1]);

            for (String item:arrayList) {
                out.print(item + " ");
            }

            reader.close();
            out.close();

            System.out.println(arrayList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
