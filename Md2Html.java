import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Md2Html {
    public static void main(String[] args) throws IOException {
        String inputFileName = "inputMd2Html.txt";//args[0];
        String outputFileName = "outputMd2Html.txt";//args[1];

        Scanner inputFile = new Scanner(new File(inputFileName));
        PrintWriter outputFile = new PrintWriter(new FileOutputStream(outputFileName));
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("<strong>");
        stringArrayList.add("<s>");
        stringArrayList.add("<em>");
        stringArrayList.add("<code>");
        ArrayList<String> stringArrayListDop = new ArrayList<>();
        stringArrayListDop.add("</strong>");
        stringArrayListDop.add("</s>");
        stringArrayListDop.add("</em>");
        stringArrayListDop.add("</code>");

        StringBuilder currentParagraph = new StringBuilder();
        while (inputFile.hasNext()) {

            String nextLine = inputFile.nextLine();
            nextLine = nextLine.replaceAll("&","&amp;").replaceAll("<","&lt;").replaceAll(">","&gt;");
            char[] chars = nextLine.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                //if (chars[i] == ' ' || chars[i] == '>')
                    switch (chars[i]){
                        case 42:
                            if (chars[i + 1] == '*')
                                if(i < chars.length - 2) {
                                    if (chars[i + 2] != ' ') {
                                        String s = stringArrayList.get(0);
                                        nextLine = nextLine.substring(0, i) + s + nextLine.substring(i + 2);
                                        stringArrayList.set(0, stringArrayListDop.get(0));
                                        stringArrayListDop.set(0,s);
                                        chars = nextLine.toCharArray();
                                    }

                                }
                            else if (chars[i + 1] != ' '){

                                String s = stringArrayList.get(2);
                                nextLine = nextLine.substring(0, i) + s + nextLine.substring(i + 1);
                                stringArrayList.set(2, stringArrayListDop.get(2));
                                stringArrayListDop.set(2,s);

                                chars = nextLine.toCharArray();
                            }
                            break;
                        case 45:
                            if (chars[i + 1] == '-')
                                if(i < chars.length - 2) {
                                if (chars[i + 2] != ' '){

                                    String s = stringArrayList.get(1);
                                    nextLine = nextLine.substring(0, i) + s + nextLine.substring(i + 2);
                                    stringArrayList.set(1, stringArrayListDop.get(1));
                                    stringArrayListDop.set(1,s);

                                    chars = nextLine.toCharArray();
                                }
                            }
                            break;
                        case 95:
                            if (chars[i + 1] == '_')
                                if(i < chars.length - 2) {
                                if (chars[i + 2] != ' '){
                                    String s = stringArrayList.get(0);
                                    nextLine = nextLine.substring(0, i) + s + nextLine.substring(i + 2);
                                    stringArrayList.set(0, stringArrayListDop.get(0));
                                    stringArrayListDop.set(0,s);
                                    chars = nextLine.toCharArray();
                                }
                            }
                            else if (chars[i + 1] != ' '){

                                String s = stringArrayList.get(2);
                                nextLine = nextLine.substring(0, i) + s + nextLine.substring(i + 1);
                                stringArrayList.set(2, stringArrayListDop.get(2));
                                stringArrayListDop.set(2,s);
                                chars = nextLine.toCharArray();
                            }
                            break;
                        case 96:
                            if (chars[i - 1] != '\\'){

                                String s = stringArrayList.get(3);
                                nextLine = nextLine.substring(0, i) + s + nextLine.substring(i + 1);
                                stringArrayList.set(3, stringArrayListDop.get(3));
                                stringArrayListDop.set(3,s);
                                chars = nextLine.toCharArray();
                            }
                            break;
                    }
            }/*
            for (int i = 0; i < chars.length - 3; i++) {
                if (chars[i] != ' ')
                    switch (chars[i+1]){
                        case '*':
                            if (chars[i + 2] == '*'){
                                if (chars[i + 3] != ' ')
                                    nextLine = nextLine.substring(0,i).concat("<strong>").concat(nextLine.substring(i + 3));
                            }
                            else if (chars[i + 2] != ' ')
                                nextLine = nextLine.substring(0,i).concat("<em>").concat(nextLine.substring(i + 2));
                            break;
                        case '-':
                            if (chars[i + 2] == '-'){
                                if (chars[i + 3] != ' ')
                                    nextLine = nextLine.substring(0,i).concat("<s>").concat(nextLine.substring(i + 3));
                            }
                            break;
                        case '_':
                            if (chars[i + 2] == '_'){
                                if (chars[i + 3] != ' ')
                                    nextLine = nextLine.substring(0,i).concat("<strong>").concat(nextLine.substring(i + 3));
                            }
                            else if (chars[i + 2] != ' ')
                                nextLine = nextLine.substring(0,i).concat("<em>").concat(nextLine.substring(i + 2));
                            break;
                        case '\'':
                            if (chars[i + 2] != ' ')
                                nextLine = nextLine.substring(0,i).concat("<code>").concat(nextLine.substring(i + 2));
                            break;
                    }

            }
*/
            if (nextLine.equals("")) {
                if (currentParagraph.toString().startsWith("#")) {
                    int count = 0;
                    while (currentParagraph.toString().substring(count, count + 1).equals("#")) {
                        count++;
                    }
                    if (currentParagraph.toString().substring(count, count + 1).equals(" "))
                        currentParagraph.replace(0, count + 1, "<h" + count + ">").append("</h").append(count).append(">");
                    else
                        currentParagraph.replace(0, 0, "<p>").append("</p>");
                } else {
                    currentParagraph.replace(0, 0, "<p>").append("</p>");
                }
                if (!currentParagraph.toString().equals("<p></p>"))
                    outputFile.println(currentParagraph);
                currentParagraph = new StringBuilder();
            } else
                currentParagraph.append(nextLine);
        }


        inputFile.close();
        outputFile.flush();
        outputFile.close();
    }
}
