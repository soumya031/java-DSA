/*. display only the boundary elements of a matrix*/

package matrixes;

import java.util.*;

public class dispboundaryelementsmatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r,c,i,j;
        System.out.print("Enter the row size-");        //Take the row size
        r=sc.nextInt();
        System.out.print("Enter the column size-");     //Take the column size
        c=sc.nextInt();
        int a[][]=new int[r][c];        //Take the size of the array
        for(i=0;i<r;i++){                //Declare the row
            for(j=0;j<c;j++){            //Declare the column
                System.out.print("Enter values-");
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("The matrix is-");
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The matrix is:"+Arrays.deepToString(a));

        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                if(i==0 || i==r-1 || j==0 || j==c-1){            
                    System.out.print(a[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
}
