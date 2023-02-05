package ua.fan.hw31.utils;

import ua.fan.hw31.threads.CountPrimeNumThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CountPrimeNumUtil {
    public void mainThread(int size) throws InterruptedException {
        List<Integer> initial = generateList(size);
        System.out.println("Initial list: " + Arrays.toString(initial.toArray()));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        divideList(initial, list1, list2);

        CountPrimeNumThread thread1 = new CountPrimeNumThread(list1);
        CountPrimeNumThread thread2 = new CountPrimeNumThread(list2);
        System.out.println("First sublist: " + Arrays.toString(list1.toArray()));
        thread1.start();
        System.out.println("Second sublist: " + Arrays.toString(list2.toArray()));
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Total of prime numbers: " + (thread1.getCount() + thread2.getCount()));
    }

    private void divideList (List<Integer> initial, List<Integer> list1, List<Integer> list2){
        for (int i = 0; i < initial.size(); i++) {
            if (i % 2 == 0) {
                list1.add(initial.get(i));
            } else {
                list2.add(initial.get(i));
            }
        }
    }

    private List<Integer> generateList(int size) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }
}
