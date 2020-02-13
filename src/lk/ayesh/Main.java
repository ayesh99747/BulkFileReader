package lk.ayesh;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt");
            writer.print("");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file");
        } finally {
            writer.close();
        }
        FileReaderWriter frw = new FileReaderWriter("Input Files/HelloWorld.java", "output.txt");
        frw.execute();

        FileReaderWriter frw2 = new FileReaderWriter("Input Files/Main.java", "output.txt");
        frw2.execute();

    }
}
