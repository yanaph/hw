package ua.fan.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Enter the string you want to check:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (isPalindrome(str)) {
            System.out.println("Your string is a palindrome.");
        } else {
            System.out.println("Your string is not a palindrome.");
        }
        sc.close();
    }

    private static boolean isPalindrome(String text) {
        StringBuilder str = new StringBuilder(deleteWhitespaces(text));
        StringBuilder reverse = new StringBuilder(str).reverse();
        return str.toString().equals(reverse.toString());
    }

    private static String deleteWhitespaces(String a){
        StringBuilder str = new StringBuilder(a);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                while (str.charAt(i) == ' '){
                    str.deleteCharAt(i);
                }
            }
        }
        return str.toString();
    }
}
