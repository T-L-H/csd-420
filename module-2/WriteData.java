// Tevyah Hanley 10/27/2025
// Writes random integers and doubles to a data file

import java.io.*;
import java.util.*;

public class WriteData {
    public static void main(String[] args) throws IOException {
        File file = new File("Hanley_datafile.dat");
        PrintWriter output = new PrintWriter(new FileWriter(file, true));
        Random rand = new Random();

        for (int i = 0; i < 5; i++) output.print(rand.nextInt(100) + " ");
        for (int i = 0; i < 5; i++) output.print(rand.nextDouble() + " ");
        output.println();
        output.close();
    }
}
