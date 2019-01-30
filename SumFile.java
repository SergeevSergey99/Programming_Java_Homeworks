public class SumFile {
    public static void main(String[] args)
    {
        int sum = 0;
        for(String item:args)
            sum+=Integer.parseInt(item);
        System.out.print(sum);

    }
}
