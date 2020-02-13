package lk.ayesh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderWriter {
    private String outputFileName;

    public FileReaderWriter() {
        this.outputFileName = "output.txt";
        this.emptyFile();
    }

    private void emptyFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(this.outputFileName);
            writer.print("");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file");
        } finally {
            writer.close();
        }
    }

    public List<String> readAllFileNames() {
        List<String> fileNames = new ArrayList<>();
        File folder = new File("Input Files/");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                fileNames.add(listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Unable to read directory! Place all the files in the 'Input files/' folder!");
            }
        }
        return fileNames;
    }

    public void execute() {
        List<String> fileNames = readAllFileNames();
        if (fileNames.isEmpty()) {
            System.out.println("No files found in 'Input files/' folder!");
            return;
        }
        for (String fileName : fileNames) {
            List<String> inputLines = this.readFromFile(fileName);
            this.writeToFile(fileName, inputLines);
            System.out.println("File write successful - " + fileName);
        }

    }

    public List<String> readFromFile(String inputFileName) {
        File file = new File("Input Files/" + inputFileName);
        List<String> inputLines = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                inputLines.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Unable to find file!");
        }
        return inputLines;
    }

    private void writeToFile(String inputFileName, List<String> lines) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.outputFileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(inputFileName + " -");
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
