// Tevyah Hanley 11/10/2025 M4 Programming Assignment
// This program reads words from a file, stores them in a TreeSet to maintain order,

import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) {
        Set<String> wordsAscending = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        try (Scanner scanner = new Scanner(new File("collection_of_words.txt"))) {
            while (scanner.hasNext()) {
                wordsAscending.add(scanner.next());
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Look at this list Ascending!");
        System.out.println(wordsAscending);

        Set<String> wordsDescending = new TreeSet<>(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        wordsDescending.addAll(wordsAscending);

        System.out.println("\nLook at this list Descending!");
        System.out.println(wordsDescending);

        System.out.println("\ntest");
        testContainsWord(wordsAscending, "apple");
        testSortedOrder(wordsAscending);
    }

    private static void testContainsWord(Set<String> set, String word) {
        System.out.println("does my test contain \"" + word + "\": " +
                (set.contains(word) ? "PASS" : "FAIL"));
    }

    private static void testSortedOrder(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        boolean sorted = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareToIgnoreCase(list.get(i + 1)) > 0) {
                sorted = false;
                break;
            }
        }
        System.out.println("is it sorting: " + (sorted ? "PASS" : "FAIL"));
    }
}
