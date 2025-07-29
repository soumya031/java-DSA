import java.util.*;

public class Neon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();
        int square = num * num;
        int sum = 0;
        while (square > 0) {
            sum += square % 10; 
            square /= 10;       
        }
        if (sum == num) {
            System.out.println(num + " is a Neon Number.");
        } else {
            System.out.println(num + " is not a Neon Number.");
        }
    }
}
