import java.util.Scanner;

public class check {
    public static void main(String[] args)
    {
        int n;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n = sc.nextInt();
        if(n % 7 == 0 && n % 5 == 0)
        {
            System.out.println("The number is divisible by 7 and is even");
        }
        else if(n % 7 != 0 && n % 5 == 0)
        {
            System.out.println("The number is divisible by 5 and is odd");
        }
        else if(n % 7 == 0)
        {
            System.out.println("The number is divisible by 7");
        }
        else if(n % 2 == 0)
        {
            System.out.println("The number is even");
        }
        else
        {
            System.out.println("The number is odd");
        }



    }
}
