package practice;

import java.util.*;

public class B05 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 50);
        hashMap.put("Banana", 20);
        hashMap.put("Orange", 35);
        hashMap.put("Grapes", 40);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        System.out.println("HashMap sorted by value in ascending order:");
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
