package lk.ayesh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderWriter {
    private String inputFileName;
    private String outputFileName;

    public FileReaderWriter(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public void execute() {
        File file = new File(this.inputFileName);
        List<String> inputLines = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            System.out.println("Lines appended to file");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                inputLines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Unable to find file!");
        }
        this.writeToFile(inputLines);
    }

    private void writeToFile(List<String> lines) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.outputFileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(this.inputFileName);
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Unable to find file!");
        }
    }
}
