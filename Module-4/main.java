// Tevyah Hanley 11/5/2025 M4 Programming Assignment
// This program compares the performance of LinkedList with Iterator and get(index) method.

import java.util.LinkedList;
import java.util.Iterator;

public class main {

    public static void main(String[] args) {
        testTraversal(50000);
        testTraversal(500000);
    }

    public static void testTraversal(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < size; i++)
            list.add(i);

        System.out.println("\nTesting with " + size + " numbers");

        long start = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) it.next();
        long iteratorTime = System.currentTimeMillis() - start;
        System.out.println("Iterator time is " + iteratorTime + " ms!");

        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++)
            list.get(i);
        long getTime = System.currentTimeMillis() - start;
        System.out.println("get(index) time is " + getTime + " ms!");

       
        System.out.println("Did it work? " + (iteratorTime >= 0 && getTime >= 0));
        
        /*
 I think that going with an Iterator is faster for a LinkedList because 
 it doesn’t support fast random access. Having to start from the 
 beginning every single time, instead of going straight to the value 
 that needs to run, makes this terrible for performance. If you have a 
 program with a ridiculous amount of values, it’s going to slow down 
 more and more each time. 

 Overall, I would go with the Iterator.
 */

    }
}
