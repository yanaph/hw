package ua.fan.hw31.utils;

import ua.fan.hw31.threads.HelloThread;

public class HelloThreadUtil {
    private static final int THREADS_NUMBER = 50;


    public void printThreads(){
        try {
            runThreads(createThreads());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void runThreads(Thread[] threads) throws InterruptedException {
        for (int i = threads.length - 1; i >= 0; i--) {
            threads[i].start();
            threads[i].join();
        }
    }

    private Thread[] createThreads() {
        Thread[] threads = new Thread[THREADS_NUMBER];
        for (int i = 0; i < THREADS_NUMBER; i++) {
            threads[i] = new HelloThread(i);
        }
        return threads;
    }
}
