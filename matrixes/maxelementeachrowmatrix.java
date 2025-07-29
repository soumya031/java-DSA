/*find the maximum element from each row of the matrix */
package matrixes;

import java.util.*;

public class maxelementeachrowmatrix {
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
        
        int max[]=new int[r];
        for(i=0;i<r;i++){
            int max1=a[i][0];
            for(j=0;j<c;j++){
                if(a[i][j]>max1)
                  max1=a[i][j];
            }
            max[i]=max1;
        }
            System.out.println("The maximum element of each row is-");
            for(i=0;i<r;i++){
                System.out.println(max[i]);
         }
    }
}
                    