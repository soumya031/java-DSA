import java.util.Scanner;

public class spycheaking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        int sum = 0, product = 1, digit;
        int temp = num;
        while (temp > 0) {
            digit = temp % 10; 
            sum += digit;       
            product *= digit;    
            temp /= 10;         
        }
        if (sum == product) {
            System.out.println(num + " is a Spy Number.");
        } else {
            System.out.println(num + " is NOT a Spy Number.");
        }
    }
}
