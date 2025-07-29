import java.util.*;

public class armstrong {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int originalNumber, remainder, result = 0;
        originalNumber = n;
        int count = 0;
        while (originalNumber != 0)
        {
            count = count + 1;
            originalNumber /= 10;
        }
        originalNumber = n;
        while (originalNumber != 0){
            remainder = originalNumber % 10;
            result += Math.pow(remainder, count);
            originalNumber /= 10;
        }
             
                    if(result == n)
                        System.out.println(n + " is an Armstrong number.");
                    else
                        System.out.println(n + " is not an Armstrong number.");

            }
            }
            
          