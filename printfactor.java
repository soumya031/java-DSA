import java.util.Scanner;

public class printfactor {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int number = scanner.nextInt();
        System.out.print("Factors of " + number + " are: ");
        for (int i = 1; i <= number; ++i) {
        if (number % i == 0) {
        System.out.print(i + " ");
    }
}
}

   
}

