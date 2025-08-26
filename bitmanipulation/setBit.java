package bitmanipulation;

import java.util.Scanner;

public class setBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Enter the position: ");
        int pos = sc.nextInt();
        int bitmask = 1 << pos;
        int newnum = bitmask | n;
        System.out.println(newnum);
    }
}
