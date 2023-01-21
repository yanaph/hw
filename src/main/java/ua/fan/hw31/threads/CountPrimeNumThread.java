package ua.fan.hw31.threads;

import lombok.Getter;

import java.util.List;
@Getter
public class CountPrimeNumThread extends Thread {
    private List<Integer> numbers;
    private int count;

    public CountPrimeNumThread(List<Integer> numbers) {
        this.numbers = numbers;
        count = 0;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (isPrime(number)){
                count++;
            }
        }
        System.out.println("There are " + count + " prime numbers");
    }

    private boolean isPrime(int number) {
        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
