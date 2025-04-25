package com.rocky.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Print the ArrayList
        //System.out.println("ArrayList: " + list);

        // Access elements from the ArrayList
        //String firstElement = list.get(0);
        //System.out.println("First element: " + firstElement);

        // Remove an element from the ArrayList
        //list.remove("Banana");
        //System.out.println("After removal: " + list);

        // Get the size of the ArrayList
        //int size = list.size();
        //System.out.println("Size of ArrayList: " + size);

        //Iterate ArrayList
        /*for(String fruit : list) {
            if(fruit.equals("Cherry")) {
                list.remove(fruit);
            }
        }*/
        // Print the ArrayList after removal
        System.out.println(list);

        //Iterate ArrayList using for loop
        System.out.println("Iterating using for loop:");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            String currentFruit = (String) iterator.next();
            if(currentFruit.equals("Cherry")) {
                iterator.remove();
            }
        }
        // Print the ArrayList after removal
        System.out.println(list);
    }
}
