package ua.fan.runnable;

import ua.fan.entity.Horse;
import ua.fan.entity.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceRunnable implements Runnable {
    private static final int TOTAL_DISTANCE = 1000;
    private static final Random RANDOM = new Random();
    private final Race race = new Race();
    private final Horse horse = new Horse();
    private final List<Horse> racers = new ArrayList<>();
    private final List<Horse> results = new ArrayList<>();

    @Override
    public void run() {
        racing();
        race.setHorsesResults(results);
        if (results.size() == race.getNumOfRacers()) {
            printResults();
        }
    }

    private void printResults() {
        if (results.get(0).equals(racers.get(race.getBetHorseNumber()))) {
            System.out.println("Congratulations! Your horse won!");
        } else {
            System.out.printf("Your horse took place #%d%n", results.indexOf(racers.get(race.getBetHorseNumber())));
        }

        System.out.println("RESULT TABLE:");
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("#%d - %s%n", (i + 1), racers.indexOf(results.get(i)) + 1);
        }
    }

    public void racing() {
        horse.setName(String.format("Horse-%d", racers.size() + 1));
        racers.add(horse);
        int speed = RANDOM.nextInt(100, 200);
        int sleep = RANDOM.nextInt(400, 500);
        horseRunTheRace(speed, sleep);
        results.add(horse);
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
