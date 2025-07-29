import java.util.Scanner;

public class leap_year {
    public static void main(String[] args){
        int year;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year");
        year = sc.nextInt();
        if(year % 100 == 0) {
            if(year % 400 == 0) {
                System.out.println("The year " + year + " is a leap year");
            } else {
                System.out.println("The year " + year + " is not a leap year");
            }
        } else {
            if(year % 4 == 0) {
                System.out.println("The year " + year + " is a leap year");
            } else {
                System.out.println("The year " + year + " is not a leap year");
            }
        }
    }
}
