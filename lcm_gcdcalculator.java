import java.util.Scanner;

public class lcm_gcdcalculator {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int num1 = a, num2 = b;
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        
        int gcd = num1;
        int lcm = (a * b) / gcd; 
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }
}


/*LCM(a, b) = (a * b) / GCD(a, b)*/

