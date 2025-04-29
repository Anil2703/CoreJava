package com.rocky.collections.list.arrayList.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorUsingArrayList {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        //Throws ConcurrentModificationException if we remove while iterating
        //Iterate ArrayList
        /*for(String fruit : list) {
            if(fruit.equals("Cherry")) {
                list.remove(fruit);
            }
        }*/
        // Print the ArrayList after removal
        System.out.println(list);

        //Iterate ArrayList using Iterator
        System.out.println("Iterating using iterator:");
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
