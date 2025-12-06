package accenturre.practice;

import java.util.*;

public class bitwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int a = sc.nextInt(); // Binary: 0101
        System.out.println("You entered: " + a);
        int b = sc.nextInt(); // Binary: 0011
        System.out.println("Using second integer: " + b);

        // Bitwise AND
        int andResult = a & b; // Result: 0001 (1 in decimal)
        System.out.println("Bitwise AND: " + andResult);

        // Bitwise OR
        int orResult = a | b; // Result: 0111 (7 in decimal)
        System.out.println("Bitwise OR: " + orResult);

        // Bitwise XOR
        int xorResult = a ^ b; // Result: 0110 (6 in decimal)
        System.out.println("Bitwise XOR: " + xorResult);

        // Bitwise NOT
        int notResult = ~a; // Result: 1010 (inverted bits)
        System.out.println("Bitwise NOT: " + notResult);

        // Left Shift
        int leftShiftResult = a << 1; // Result: 1010 (10 in decimal)
        System.out.println("Left Shift: " + leftShiftResult);

        // Right Shift
        int rightShiftResult = a >> 1; // Result: 0010 (2 in decimal)
        System.out.println("Right Shift: " + rightShiftResult);
    }
}