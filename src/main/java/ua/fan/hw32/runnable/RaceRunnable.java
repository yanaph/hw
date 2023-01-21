package ua.fan.hw32.runnable;

import ua.fan.hw32.model.Race;

public class RaceRunnable implements Runnable {
    private final Race race = new Race();


    @Override
    public void run() {
        race.startTheRace();
    }
}
