// Tevyah Hanley 11/25/2025 M8 Programming Assignment
// This program will create three threads that will create some random letters and stuff to a JTextArea.

import javax.swing.*;
import java.util.Random;

public class TevyahThreeThreads {
    public static void main(String[] args) {
        JTextArea textArea = new JTextArea();
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(textArea));
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Random rand = new Random();

        Thread letters = new Thread(() -> {
            for (int i = 0; i < 10000; i++) 
                textArea.append("" + (char)('a' + rand.nextInt(26)));
        });

        Thread digits = new Thread(() -> {
            for (int i = 0; i < 10000; i++) 
                textArea.append("" + rand.nextInt(10));
        });

        Thread symbols = new Thread(() -> {
            char[] sym = {'!', '@', '#', '$', '%', '&', '*'};
            for (int i = 0; i < 10000; i++) 
                textArea.append("" + sym[rand.nextInt(sym.length)]);
        });

        letters.start();
        digits.start();
        symbols.start();
    }
}
