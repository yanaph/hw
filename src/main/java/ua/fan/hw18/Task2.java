package ua.fan.hw18;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Random;

public class Task2 {
    static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> integers = createArrayWithRandomIntegers(10);
        System.out.println("\nInitial list: " + integers);
        IntSummaryStatistics statistics = new IntSummaryStatistics();
        System.out.print("Filtered list: ");
        integers.stream()
                .filter(a -> a >= 0)
                .forEach(integer -> {
                    statistics.accept(integer);
                    System.out.printf("%d ", integer);
                });
        System.out.println(printFormattedStatistics(statistics));
    }

    private static String printFormattedStatistics(IntSummaryStatistics intSummaryStatistics) {
        return String.format("%nCount: %d%nSum: %d%nMin.: %d%nMax.: %d%nAverage: %.2f%n",
                intSummaryStatistics.getCount(), intSummaryStatistics.getSum(), intSummaryStatistics.getMin(),
                intSummaryStatistics.getMax(), intSummaryStatistics.getAverage());
    }

    private static ArrayList<Integer> createArrayWithRandomIntegers(int capacity) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            integers.add(RANDOM.nextInt(20) - 10);
        }
        return integers;
    }
}
