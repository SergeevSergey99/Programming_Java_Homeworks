import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SumFile {
    public static void main(String[] args)
    {
        int sum = 0;
        try {
            Scanner reader = new Scanner(new File("input.txt"));
            while (reader.hasNext()) {
                sum += reader.nextInt();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print(sum);

    }
}
