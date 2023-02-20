package ua.fan.hw32;

import ua.fan.hw32.model.Value;
import ua.fan.hw32.runnable.IncrementerRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
    public static void main(String[] args) {
        Value value = new Value();
        value.setValue(50);
        Runnable incrementer = new IncrementerRunnable(value);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.submit(incrementer);
        }
        executor.shutdown();
    }
}
