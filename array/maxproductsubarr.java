package array;

import java.util.*;

public class maxproductsubarr{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the limit:");
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter value:");
            a[i]=sc.nextInt();
        }
        System.out.println("The array is:"+Arrays.toString(a));
        int x=0,y=0,z=0,s1=0;
        for(int i=0;i<n-2;i++)
        {
            int s=0;
            s=a[i]+a[i+1]+a[i+2];
            if(s>s1)
            {
                s1=s;
                x=a[i];
                y=a[i+1];
                z=a[i+2];
            }
        }
        System.out.println("Subarray is:"+x+y+z);
        System.out.println("The sum is:"+s1);
    }
}