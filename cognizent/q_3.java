package cognizent;

import java.util.Scanner;

public class q_3 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the digit: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        char s = (char) a;
        char t = (char) b;
        char e = (char) c;
        char p = (char) d;

        System.out.println();
        System.out.print(a);
        System.out.println("-" + s);
        System.out.print(b);
        System.out.println("-" + t);
        System.out.print(c);
        System.out.println("-" + e);
        System.out.print(d);
        System.out.println("-" + p);
      }      
}
