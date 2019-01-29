import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        String input = reader.nextLine();
        reader.close();

        char[] reverseInput = input.toCharArray();
        int begin = 0;
        int end = reverseInput.length - 1;
        char temp;
        while (end > begin) {
            temp = reverseInput[begin];
            reverseInput[begin] = reverseInput[end];
            reverseInput[end] = temp;
            end--;
            begin++;
        }


        System.out.print(reverseInput);

    }
}
