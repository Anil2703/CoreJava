package com.rocky.collections.list.arrayList;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> fruitsList = new CopyOnWriteArrayList<>();

        // Add elements to the CopyOnWriteArrayList
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Cherry");

        // Iterate over the CopyOnWriteArrayList
        for (String fruit : fruitsList) {
            System.out.println(fruit);
            // You can safely modify the list while iterating
            if (fruit.equals("Banana")) {
                fruitsList.remove(fruit);
            }
        }

        // Print the CopyOnWriteArrayList after modification
        System.out.println("After modification: " + fruitsList);
    }
}
