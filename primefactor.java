import java.util.*;

public class primefactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        sc.close();
        System.out.print("Prime factors of " + n + " are: ");
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) { 
                int isPrime = 1; 
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        isPrime = 0; 
                        break;
                    }
                }
                if (isPrime == 1) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}





