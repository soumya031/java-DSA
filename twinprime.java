import java.util.*;

public class twinprime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        int num2 = num1 + 2;
        scanner.close();
        boolean isPrime1 = true, isPrime2 = true;
        if (num1 <= 1) isPrime1 = false; 
        if (num2 <= 1) isPrime2 = false;
        for (int i = 2; i * i <= num1; i++) {
            if (num1 % i == 0) {
                isPrime1 = false;
                break;
            }
        }
        for (int i = 2; i * i <= num2; i++) {
            if (num2 % i == 0) {
                isPrime2 = false;
                break;
            }
        }
        if (isPrime1 && isPrime2 && Math.abs(num1 - num2) == 2) {
            System.out.println(num1 + " and " + num2 + " are Twin Prime Numbers.");
        } else {
            System.out.println(num1 + " and " + num2 + " are NOT Twin Prime Numbers.");
        }
    }
}


    
