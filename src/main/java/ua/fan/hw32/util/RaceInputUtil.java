package ua.fan.hw32.util;

import java.util.Scanner;

public class RaceInputUtil {
    private static final int LIMIT_OF_RACERS = 10;
    public static int BET_HORSE;
    public static int HORSE_COUNT;
    private static final Scanner SCANNER = new Scanner(System.in);

    public void chooseNumberOfParticipants() {
        System.out.println("Welcome to the race!");
        do {
            System.out.printf("Please enter the number of racers (from 2 to %d horses):\n", LIMIT_OF_RACERS);
            while (!SCANNER.hasNextInt()) {
                System.out.println("It is not a number!");
                SCANNER.next();
            }
            HORSE_COUNT = SCANNER.nextInt();
        } while (HORSE_COUNT <= 1 || HORSE_COUNT > LIMIT_OF_RACERS);
        System.out.println("Number of participants - " + HORSE_COUNT);
    }

    public void chooseBetHorseNumber() {
        do {
            System.out.printf("Choose the horse number you are betting on (from 1 to %d):\n", HORSE_COUNT);
            while (!SCANNER.hasNextInt()) {
                System.out.println("It is not a number!");
                SCANNER.next();
            }
            BET_HORSE = SCANNER.nextInt();
        } while (BET_HORSE <= 0 || BET_HORSE > HORSE_COUNT);
    }
}
