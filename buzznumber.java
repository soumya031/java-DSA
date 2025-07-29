import java.util.Scanner;

public class buzznumber {
    public static void main(String[] args){
        int n;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n = sc.nextInt();
        if(n % 7 == 0 || n % 10 == 7)
        {
            System.out.println("The number " + n + " is a buzz number");
        }
        else
        {
            System.out.println("The number " + n + " is not a buzz number");
        }
    }
}
