import java.io.*;
import java.util.*;

public class SumFile {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        try {
            Scanner reader = new Scanner(new File(args[0]));
            while (reader.hasNext()) {
                sum += reader.nextInt();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1])))) {
            try {
                writer.write(String.valueOf(sum));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }

    }
}
