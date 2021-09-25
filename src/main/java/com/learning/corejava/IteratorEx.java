package com.learning.corejava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        // Approach 1
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int no = iterator.next();
            System.out.println("No : " + no);
            if (no == 3) {
                list.add(no * 2);   // will throw ConcurrentModificationException
            }
        }
        System.out.println("List size : " + list.size());

        // Approach 2
       /* for (int no : list) {
            System.out.println("Number : " + no);
            if (no == 3) {
                list.add(no * 2);   // will throw ConcurrentModificationException
            }
        }
        System.out.println("List size : " + list.size());*/
    }

}
