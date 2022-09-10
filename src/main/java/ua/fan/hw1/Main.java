package ua.fan.hw1;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Name: Zieu Lin Fan");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new java.util.Date());
        System.out.println("Current time: " + timeStamp);

        System.out.println("\nADDITIONAL TASK:\n");
        System.out.println("Initial number: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int reverse = 0;
        while (num !=0){
            reverse = reverse*10+num%10;
            num = num/10;
        }
        System.out.println("Reverse number: " + reverse);
    }
}