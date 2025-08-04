package searching;

/*Given an array arr[] consisting of N positive integers and a  positive integer K such that there are N countries,each country has 
arr[i] players, the task is to find the maximum number of teams that can be formed by forming teams of size K such that each player 
in the team is from a different country.
Example 1:
Input:
N = 4,
K = 3,
arr = {4, 3, 5, 3}
Output:
5
Explaination:
Consider the countries are named A, B, C and D.
The possible ways of forming the teams are 
{A, B, C}, {A, C, D}, {A, B, C}, {B, C, D}, 
{A, C, D} such that in each set there are 
no more than 1 person from a country.
Therefore, the total count teams formed is 5.

Example 2:

Input:
N = 3,
K = 2,
arr = {2, 3, 4}
Output:
4
Explaination:
Consider the countries are named A, B, C and D. 
The possible ways of forming the teams are {B, C},
 {B, C}, {A, C}, ({A, B} or {A, C} or {B, C})  
such that in each set there are no more than 1
person from a country.
Therefore, the total count teams formed is 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function countOfTeams() which takes arr, N, K as input parameter and returns an integer denoting the maximum number of teams that can be formed by forming teams of size K such that each player in the team is from a different country.


Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ n
1 ≤ arr ≤ 106

 */
import java.util.*;
import java.util.Scanner;

public class TeamFormation {
    public static int countOfTeams(int[] arr, int N, int K) {
        long low = 0;
        long high = 0;
        for (int a : arr) {
            high += a;
        }
        high /= K;
        int result = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canFormTeams(arr, N, K, mid)) {
                result = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static boolean canFormTeams(int[] arr, int N, int K, long x) {
        long total = 0;
        for (int i = 0; i < N; i++) {
            total += Math.min(arr[i], x);
        }
        return total >= x * K;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input number of countries
        System.out.print("Enter number of countries (N): ");
        int N = sc.nextInt();
        // Input team size K
        System.out.print("Enter size of each team (K): ");
        int K = sc.nextInt();
        int[] arr = new int[N];
        // Input players from each country
        System.out.println("Enter number of players in each country:");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // Output the result
        int maxTeams = countOfTeams(arr, N, K);
        System.out.println("Maximum number of teams that can be formed: " + maxTeams);

        sc.close();
    }
}

