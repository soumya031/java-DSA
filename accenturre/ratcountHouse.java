

import java.util.*;

public class ratcountHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();
        int[] houses = new int[n];
        System.out.println("Enter the number of rats in each house:");
        for (int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }
        int maxRats = Arrays.stream(houses).max().orElse(0);
        List<Integer> houseIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (houses[i] == maxRats) {
                houseIndices.add(i + 1); 
            }
        }
        System.out.println("Houses with the maximum number of rats (" + maxRats + "): " + houseIndices);
    }
}