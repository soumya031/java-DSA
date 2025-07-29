package cognizent;

import java.util.Scanner;

public class q_5 {
    public static void main(String[] args) {
        double total = 0, cost;
        String ref, co , circle;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of ticket: ");
        int n = sc.nextInt();
        if(n < 5|| n > 40){
            System.out.println("Minimum of 5 and Maximum of 40 tickets");
        }
        System.out.println(("Do you want refreshment"));
        ref = sc.next();
        System.out.println("do you have coupon code: ");
        co = sc.next();
        System.out.println("Enter the circle:");
        circle = sc.next();
        if(circle .charAt(0) == 'k') cost = 75 * n;
        else if(circle .charAt(0) == 'q') cost = 150 * n;
        else{
            System.out.println("Invalid circle");
            return;
        }
        total = cost;
        if(n > 20)
        cost = cost - ((0.1) * cost);
        total = cost;
        if(co.charAt(0) == 'y')
        total = cost - ((0.02) * cost);
        if(ref.charAt(0) == 'y')
        total += (n * 50);
        System.out.println("Total cost is:%.2f "+total);
    }
}
