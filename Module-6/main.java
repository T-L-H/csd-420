// Tevyah Hanley 11/22/2025 M5 Programming Assignment
// This program will show the use of the bubble sort algorithm

import java.util.*;

public class main {

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 8, 1, 2};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

        String[] sports = {"Hockey", "Football", "Pickleball"};
        bubbleSort(sports, (a, b) -> b.compareTo(a)); 
        System.out.println(Arrays.toString(sports));
    }
}
