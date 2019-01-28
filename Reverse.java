import java.util.*;
import java.io.*;
  
public class Reverse
{
  public static void main(String[] args)
  {

	Scanner reader = new Scanner(System.in);  // Reading from System.in
	System.out.println("Enter a number: ");
	int n = reader.nextInt(); // Scans the next token of the input as an int.
	//once finished
	reader.close();
    
    System.out.print("  *  "+n);
    
  }
}
