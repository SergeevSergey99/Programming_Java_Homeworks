import java.io.*;
import java.util.Scanner;

public class Md2Html {
    public static void main(String[] args) throws IOException {
    String inputFileName = "inputMd2Html.txt";//args[0];
    String outputFileName = "outputMd2Html.txt";//args[1];

    Scanner inputFile = new Scanner(new File(inputFileName));
    PrintWriter outputFile = new PrintWriter(new FileOutputStream(outputFileName));

    StringBuilder currentParagraph = new StringBuilder();
    while (inputFile.hasNext()){
        String nextLine = inputFile.nextLine();
        if (nextLine.equals("")){
            if (currentParagraph.toString().startsWith("#")){
                int count = 0;
                while (currentParagraph.toString().substring(count,count + 1).equals("#")) {
                        count++;
                }
                if (currentParagraph.toString().substring(count, count + 1).equals(" "))
                    currentParagraph.replace(0,count,"<h" + count + ">");
            }

            outputFile.println(currentParagraph);
            currentParagraph = new StringBuilder();
        }
        else
            currentParagraph.append(nextLine);
    }


    inputFile.close();
    outputFile.flush();
    outputFile.close();
    }
}
