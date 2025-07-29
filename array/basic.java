package array;

import java.util.*;

public class basic {
 public static void main(String[] args) {
        int n,i;
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the limit:");
        n=sc.nextInt();
        int a[]=new int[n]; //Initialize an array of size n
        for(i=0;i<n;i++)
        {
            System.out.print("a["+i+"]:");
            a[i]=sc.nextInt();
        }
        System.out.println("Array elements are:"+Arrays.toString(a)); //Display in List format
        for(i=0;i<n;i++)
        {
            System.out.println(a[i]);       //Display in array format
        }
    }
}
    