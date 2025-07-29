package matrixes;

import java.util.*;

public class sumofboundaryelementsmatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, c, i, j;
        System.out.print("Enter the row size-");        //Take the row size
        r = sc.nextInt();
        System.out.print("Enter the column size-");     //Take the column size
        c = sc.nextInt();
        int a[][] = new int[r][c];        //Take the size of the array
        for (i = 0; i < r; i++) {         //Declare the row
            for (j = 0; j < c; j++) {     //Declare the column
                System.out.print("Enter values-");
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("The matrix is-");
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The matrix is:" + Arrays.deepToString(a));

        int sum = 0;
        for (i = 0; i < c; i++) {
            sum += a[0][i];
            if (r > 1) sum += a[r - 1][i];
        }
        for (j = 1; j < r - 1; j++) {
            sum += a[j][0];
            if (c > 1) 
              sum += a[j][c - 1];  
        }
        System.out.println("Sum of boundary elements of the matrix : " + sum);
    }
}
