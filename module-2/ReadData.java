// Tevyah Hanley 10/27/2025
// Reads and displays data from the file

import java.io.*;
import java.util.*;

public class ReadData {
    public static void main(String[] args) throws IOException {
        File file = new File("Hanley_datafile.dat");
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) System.out.print(input.next() + " ");
        input.close();
    }
}
