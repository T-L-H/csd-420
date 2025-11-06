// Tevyah Hanley 11/5/2025 M3 Programming Assignment
// Makes a list of 50 random integers from 1-20 and removes duplicates

import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 50; i++)
            list.add(r.nextInt(20) + 1);

        System.out.println("Original: " + list);
        System.out.println("No Duplicates: " + removeDuplicates(list));
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        for (E item : list)
            if (!newList.contains(item))
                newList.add(item);
        return newList;
    }
}
