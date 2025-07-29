import java.util.*; 


public class sumofallodd {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting number of the range: ");
        int start = sc.nextInt();
        System.out.print("Enter the ending number of the range: ");
        int end = sc.nextInt();
        int sum = 0;
        if (start > end) {
            System.out.println("Invalid input: Strting number cannot be greater than ending number.");
        } else {
            for (int i = start; i <= end; i++) {
                if (i % 2 != 0) {
                    sum += i;
                }
            }
            System.out.println("The sum of odd numbers in the range is: " + sum);
    }
}
}
