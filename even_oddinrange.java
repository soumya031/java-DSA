import java.util.Scanner;

public class even_oddinrange {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting number of the range: ");
        int start = scanner.nextInt();
        System.out.print("Enter the ending number of the range: ");
        int end = scanner.nextInt();
        int evenCount = 0;
        int oddCount = 0;

        if (start > end) {
            System.out.println("Invalid input: Starting number cannot be greater than the ending number.");
        } else {
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            System.out.println("Number of even numbers: " + evenCount);
            System.out.println("Number of odd numbers: " + oddCount);
        }
        scanner.close();
      
    }
}
