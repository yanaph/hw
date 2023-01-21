package ua.fan.hw32;

import ua.fan.hw32.runnable.RaceRunnable;
import ua.fan.hw32.util.RaceInputUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ua.fan.hw32.util.RaceInputUtil.HORSE_COUNT;

public class Task2 {
    private static final RaceInputUtil RACE_INPUT_UTIL = new RaceInputUtil();

    public static void main(String[] args) {
        RACE_INPUT_UTIL.chooseNumberOfParticipants();
        RACE_INPUT_UTIL.chooseBetHorseNumber();

        Runnable raceRunnable = new RaceRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(HORSE_COUNT);
        for (int i = 0; i < HORSE_COUNT; i++) {
            executorService.submit(raceRunnable);
        }
        executorService.shutdown();
    }
}
