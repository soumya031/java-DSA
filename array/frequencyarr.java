package array;

import java.util.*;

public class frequencyarr {
    public static void main(String[] args) {
        int n,c,i;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the limit:");
        n=sc.nextInt();
        int a[]=new int[n];
        for(i=0;i<n;i++)
        {
            System.out.print("Enter values:");
            a[i]=sc.nextInt();
        }
        System.out.print("The array is:"+Arrays.toString(a));
        for(i=0;i<n;i++)//Retrive elements one by one
        {
            c=0;
            for(int j=0;j<n;j++)    //Retrive all the elements of the array
            {
                System.out.println(a[i]+" and "+a[j]);
                if(a[i]==a[j])     //Count the frequency of each element of the array
                c++;
            }
            System.out.println("Frequency of"+a[i]+"is:"+c);
        }
    }
}
    
