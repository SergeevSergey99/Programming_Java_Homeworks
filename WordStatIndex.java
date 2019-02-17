import java.io.File;
import java.io.FileNotFoundException;
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
                int index = arrayList.indexOf(text);
                if (arrayList.contains(text)) {
                    arrayList.set(1 + index, String.valueOf(Integer.parseInt(arrayList.get(index + 1)) + 1));
                    arrayList.set(index + 2, arrayList.get(index + 2) + " " + i);
                } else {
                    arrayList.add(text);
                    arrayList.add(String.valueOf(1));
                    arrayList.add(String.valueOf(i));
                }

            }

            reader.close();

            System.out.println(arrayList);
            /*
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
            out.close();*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
