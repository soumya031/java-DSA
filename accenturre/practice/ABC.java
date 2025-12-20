
package practice;

/*input1: 5(size of array A)
  input2: 2(size of array B)
  input3: [2,4,5,6,1](arrar A)
  input4: [1,3](array B)
  find the final array A .
  output: [2,4,1,5,6] */
  
import java.util.*;

public class ABC {
    public int[] solve(int[] A, int[] B){
        int n = A.length;
        for(int b : B){
            int start = n - b;
            Arrays.sort(A, start, n);
        }
        return A;
    }
    public static void main(String[] args) {
        ABC obj = new ABC();
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {2, 3};
        int[] result = obj.solve(A, B);
        System.out.println(Arrays.toString(result));
    }
}
