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

    private static int horseNum = 0;
    private Horse horse = new Horse(TOTAL_DISTANCE, RANDOM.nextInt(100, 200));
    private List<Horse> racers = new ArrayList<>();
    private List<Horse> results = new ArrayList<>();

    public void startTheRace() {
        racing();
        if (results.size() == HORSE_COUNT) {
            printResults();
        }
    }

    private void printResults() {
        if (results.get(0).equals(getHorseByNumber(BET_HORSE))) {
            System.out.println("Congratulations! Your horse won!");
        } else {
            System.out.printf("Your horse took place #%d%n", results.indexOf(getHorseByNumber(BET_HORSE)));
        }

        System.out.println("RESULT TABLE:");
        for (int i = 0; i < results.size(); i++) {
            System.out.printf("#%d - Horse %d%n", (i + 1), horse.getHorseNumber());
        }
    }

    public void racing() {
        int sleep = RANDOM.nextInt(400, 500);
        increaseHorseNum();
        horse.setHorseNumber(horseNum);
        while (horse.getDistance_left() > 0) {
            horseRunTheRace(sleep);
        }
        results.add(horse);
    }

    private void increaseHorseNum() {
        synchronized (LOCK){
            horseNum++;
        }
    }

    private Horse getHorseByNumber(int betHorse) {
        Horse horse = null;
        for (int i = 0; i < racers.size(); i++) {
            if (i + 1 == betHorse) {
                horse = racers.get(i);
            }
        }
        return horse;
    }

    private void horseRunTheRace(int sleep) {
        try {
            horse.setDistance_left(horse.getDistance_left() - horse.getSpeed());
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
