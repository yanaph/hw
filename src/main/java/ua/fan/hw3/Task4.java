package ua.fan.hw3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int secret, range, attempt = 0;
        range = 10 * chooseLevel(sc);
        secret = (int) (Math.random() * range);

        System.out.println("\n--- LET'S START! ---");
        System.out.println("Range: [0; " + range + "]");
        printAttempts(secret, attempt, sc);
    }

    private static void printAttempts(int secret, int attempt, Scanner scanner) {
        int guess;
        do {
            attempt++;
            System.out.print("Attempt №" + attempt + ": ");
            guess = scanner.nextInt();

            if (secret == guess) {
                System.out.println("\nCongratulations! You guessed the number.");
                return;
            } else if (secret > guess) {
                System.out.println("The number is greater than " + guess);
            } else if (secret < guess) {
                System.out.println("The number is less than " + guess);
            }
        } while (guess != secret);
    }

    private static int chooseLevel (Scanner scanner){
        System.out.println("\n--- GAME 'GUESS THE SECRET NUMBER' ---");
        System.out.println("ㅜ Choose the level of difficulty : ");
        System.out.println("ㅏㅡㅡㅡ> 1) Easy");
        System.out.println("ㅏㅡㅡㅡ> 2) Medium");
        System.out.println("ㅏㅡㅡㅡ> 3) Hard");

        System.out.print("\nYour choice: ");
        return scanner.nextInt();
    }
}
