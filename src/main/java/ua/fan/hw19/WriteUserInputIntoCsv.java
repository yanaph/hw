package ua.fan.hw19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteUserInputIntoCsv {
    public static void main(String[] args) {
        System.out.println("Enter data to write into csv:");
        Scanner scanner = new Scanner(System.in);
        StringBuilder data = new StringBuilder();
        String input;
        do {
            input = scanner.nextLine();
            data.append(input).append(" ");
        } while (!input.equals("end"));
        writeIntoCsvFile(data.toString());
        scanner.close();

    }

    private static void writeIntoCsvFile(String str) {
        try (FileOutputStream outputStream = new FileOutputStream("src/main/java/ua/fan/hw19/resources/output.csv")) {
            String[] words = str.split("\\s");
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("next")) {
                    outputStream.write(10);
                } else if (words[i].equals("end")) {
                    return;
                } else {
                    if (words[i + 1].equals("next") || words[i+1].equals("end")) {
                        outputStream.write(words[i].getBytes());
                    } else {
                        outputStream.write((words[i] + ",").getBytes());
                    }
                }

            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
