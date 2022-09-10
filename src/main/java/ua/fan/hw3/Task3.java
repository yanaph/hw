package ua.fan.hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Enter the string you want to check:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("There are " + wordCounter(str) + " words");
        sc.close();
    }

    private static int wordCounter(String text) {
        int counter = 0;
        boolean firstWord = false;
        for (int i = 0; i < text.length(); i++) {
            if (!firstWord && text.charAt(i) != ' ') {
                counter++;
                firstWord = true;
            }
            if (firstWord && i != text.length() - 1 && text.charAt(i) == ' ' && text.charAt(i + 1) != ' ')  {
                counter++;
            }
        }
        return counter;
    }
}
