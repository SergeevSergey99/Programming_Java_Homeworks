public class Sum
{
  public static void main(String[] args)
  {
    int i, sum = 0;
    for(String item:args)
      sum+=Integer.parseInt(item);
    System.out.print(sum);
    
  }
}
