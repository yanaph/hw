package ua.fan.hw32.model;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class Value {
    private int value;
    private ReentrantLock lock = new ReentrantLock();

    public void incrementValue() {
        lock.lock();
        try {
            value += 2;
            System.out.println(Thread.currentThread().getName() + ": " + value);
        } finally {
            lock.unlock();
        }
    }
}
