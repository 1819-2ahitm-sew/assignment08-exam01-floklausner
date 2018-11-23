
package at.htl.exam01.compress;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class StringCompress {

    private static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {

        StringCompress sc = new StringCompress();

        String[] text = readFromFile(FILE_NAME);

        print(text);
    }

    public static String[] readFromFile(String fileName) {

        String[] lines = new String[getNoOfLines(FILE_NAME)];
        String[] compressed = new String[getNoOfLines(FILE_NAME)];
        int i = 0;
        int number;
        char letter;
        String numberStr;

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {

            while(scanner.hasNextLine()) {
                lines[i] = scanner.nextLine();
                i++;
            }

        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        for (int j = 0; j < lines.length; j++) {

            letter = lines[j].charAt(0);

            numberStr = lines[j].substring(1);

            number = Integer.parseInt(numberStr);

            compressed[j] = "";
            for (int k = 0; k < number; k++) {

              compressed[j] += letter;


            }

        }

        return compressed;
    }


    public static int getNoOfLines(String fileName) {
        int count = 0;

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }

    public static void print(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
    }
}


