package hashmap;

import java.util.*;


public class basichash {
    public static void main(String[] args) {
        HashMap<String, Integer> marks = new HashMap<>();
        marks.put("soumya", 90);
        marks.put("sayan", 93);
        marks.put("sola", 95);
        System.out.println("sayan's score: "+ marks.get("sayan"));
        for(Map.Entry<String, Integer> entry : marks.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }
        marks.remove("sola");
        System.out.println("updated Map: " + marks);
    }
}
