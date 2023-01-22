package ua.fan.hw32.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ua.fan.hw32.util.RaceInputUtil.BET_HORSE;
import static ua.fan.hw32.util.RaceInputUtil.HORSE_COUNT;

@Setter
@Getter
public class Race {
    private static final int TOTAL_DISTANCE = 1000;
    private static final Random RANDOM = new Random();
    private static final Object LOCK = new Object();
    private List<String> racers = new ArrayList<>();
    private List<String> results = new ArrayList<>();

    public void startTheRace() {
        racing();
        if (results.size() == HORSE_COUNT) {
            printResults();
        }
    }

    private void printResults() {
        if (results.get(0).equals(racers.get(BET_HORSE - 1))) {
            System.out.println("Congratulations! Your horse won!");
        } else {
            System.out.printf("Your horse took place #%d%n", results.indexOf(racers.get(BET_HORSE - 1)) + 1);
        }

        System.out.println("ALL RACERS TABLE:");
        for (int i = 0; i < racers.size(); i++) {
            System.out.printf("#%d - %s%n", (i + 1), racers.get(i));
        }

        System.out.println("\nRESULT TABLE:");
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("#%d - %s%n", (i + 1), results.get(i));
        }
    }

    public void racing() {
        String horseName;
        synchronized (LOCK) {
            horseName = String.format("Horse-%d", racers.size() + 1);
        }
        racers.add(horseName);
        int speed = RANDOM.nextInt(100, 200);
        int sleep = RANDOM.nextInt(400, 500);
        horseRunTheRace(speed, sleep);
        results.add(horseName);
    }

    private void horseRunTheRace(int speed, int sleep) {
        int distance_left = TOTAL_DISTANCE;
        while (distance_left > 0) {
            try {
                distance_left -= speed;
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
