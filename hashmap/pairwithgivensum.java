/*Find all pairs with a given sum
Given two unsorted arrays a[]  and b[], the task is to find all pairs whose sum equals x from both arrays.

Note: All pairs should be returned in increasing order of u. For eg. for two pairs (u1,v1) and (u2,v2), if u1 < u2 then (u1,v1) should be returned first else second.

Examples:

Input: target = 9, a[] = [1, 2, 4, 5, 7], b[] = [5, 6, 3, 4, 8]
Output: 
1 8
4 5 
5 4
Explanation: (1, 8), (4, 5), (5, 4) are the pairs which sum to 9.
Input: target = 8, a[] = [-1, -2, 4, -6, 5, 7], b[] = [6, 3, 4, 0]
Output:
4 4 
5 3
Input: target = 9, a[] = [1, 2, 4, 5, 7, 4], b[] = [5, 6, 3, 4, 8, 4]
Output:
1 8
4 5
4 5
5 4
5 4
Explanation: (1, 8), (4, 5), (4, 5), (5, 4) and (5, 4) are the pairs which sum to 9.
Constraints:
1 ≤ arr1.size, arr2.size ≤ 105
-2*104 ≤ target, arr1[i], arr2[i] ≤ 2*104
 */

package hashmap;

import java.util.*;

public class pairwithgivensum {

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public Pair[] allPairs(int target, int arr1[], int arr2[]) {
        Arrays.sort(arr1); // sort arr1 for ascending order output
        Arrays.sort(arr2); // sort arr2 for ascending order output
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Pair> p = new ArrayList<>();
        for(int i = 0; i < arr2.length; i++){
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }
        for(int i = 0; i < arr1.length; i++){
            int a = arr1[i];
            int b = target - a;
            if(map.containsKey(b) && map.get(b) > 1){
                for(int k = 0; k < map.get(b); k++){
                    p.add(new Pair(a,b));
                }
            } else if(map.containsKey(b)){
                p.add(new Pair(a,b));
            }
        }
        return p.toArray(new Pair[0]);
    }

    public static void main(String[] args) {
        pairwithgivensum s = new pairwithgivensum();
        int target = 9;
        int arr1[] = {1, 2, 4, 5, 7};
        int arr2[] = {5, 6, 3, 4, 8};
        Pair[] res = s.allPairs(target, arr1, arr2);
        for (Pair pair : res) {
            System.out.println(pair.first + " " + pair.second);
        }
    }
}
