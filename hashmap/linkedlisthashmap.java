package hashmap;

import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    LRUCache(int capacity) {
        super();  // accessOrder = true
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class linkedlisthashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cache capacity: ");
        int capacity = sc.nextInt();
        LRUCache<Integer, String> cache = new LRUCache<>(capacity);
        while (true) {
            System.out.println("\n1. Put\n2. Get\n3. Show Cache\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter key (integer): ");
                    int keyPut = sc.nextInt();
                    sc.nextLine();  // consume newline
                    System.out.print("Enter value (string): ");
                    String value = sc.nextLine();
                    cache.put(keyPut, value);
                    System.out.println("Added to cache.");
                    break;
                case 2:
                    System.out.print("Enter key to get: ");
                    int keyGet = sc.nextInt();
                    String val = cache.get(keyGet);
                    if (val != null) {
                        System.out.println("Value = " + val);
                    } else {
                        System.out.println("Key not found in cache.");
                    }
                    break;

                case 3:
                    System.out.println("Current Cache: " + cache);
                    break;

                case 4:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
 
