package ua.fan.hw32.runnable;

import lombok.AllArgsConstructor;
import ua.fan.hw32.model.Value;


@AllArgsConstructor
public class IncrementerRunnable implements Runnable {
    private Value value;

    @Override
    public void run() {
        value.incrementValue();
    }
}
