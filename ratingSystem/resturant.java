package ratingSystem;

import java.util.*;

class Food implements Comparable<Food> {
    public int foodRating;
    public String foodName;

    public Food(int foodRating, String foodName) {
        this.foodRating = foodRating;
        this.foodName = foodName;
    }

    @Override
    public int compareTo(Food other) {
        if (foodRating == other.foodRating) {
            return foodName.compareTo(other.foodName);
        }
        return -1 * Integer.compare(foodRating, other.foodRating);
    }
}

class FoodRatings {
    private Map<String, Integer> foodRatingMap;
    private Map<String, String> foodCuisineMap;
    private Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();
        for (int i = 0; i < foods.length; ++i) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cuisineName = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        Food highestRated = cuisineFoodMap.get(cuisine).peek();
        while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
            cuisineFoodMap.get(cuisine).poll();
            highestRated = cuisineFoodMap.get(cuisine).peek();
        }
        return highestRated.foodName;
    }
}

public class resturant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of food items: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline
        String[] foods = new String[n];
        String[] cuisines = new String[n];
        int[] ratings = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.print("Enter food name: ");
            foods[i] = sc.nextLine();
            System.out.print("Enter cuisine for " + foods[i] + ": ");
            cuisines[i] = sc.nextLine();
            System.out.print("Enter rating for " + foods[i] + ": ");
            ratings[i] = sc.nextInt();
            sc.nextLine();  // Consume newline
        }

        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Change Food Rating");
            System.out.println("2. Get Highest Rated Food by Cuisine");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter food name to change rating: ");
                String food = sc.nextLine();
                System.out.print("Enter new rating: ");
                int newRating = sc.nextInt();
                sc.nextLine();  // Consume newline
                obj.changeRating(food, newRating);
                System.out.println("Rating updated successfully.");

            } else if (choice == 2) {
                System.out.print("Enter cuisine: ");
                String cuisine = sc.nextLine();
                String highestRated = obj.highestRated(cuisine);
                System.out.println("Highest rated food in " + cuisine + " cuisine: " + highestRated);

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }
}
