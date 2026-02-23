package no.hiof.oleedvao.lecture15;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File textFile = new File("textfile.txt");

        writeToFile(textFile);
        readFromFile(textFile);

        File nonExistentFile = new File("blablabla.txt");
        readFromFile(nonExistentFile);

        System.out.println("The next operation after exception.");
    }

    public static void readFromFile(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ( (line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
        catch (FileNotFoundException exception) {
            System.err.println("Could not find file with name " + file.getName());
        }
        catch (IOException exception) {
            System.err.println("Something went wrong when reading from file.");
        }

    }

    public static void writeToFile(File file) {

        try (FileWriter fileWriter = new FileWriter(file)) {

            fileWriter.append("Programming is fun!\n");
            fileWriter.append("At least when I don't get errors...\n");
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

}
