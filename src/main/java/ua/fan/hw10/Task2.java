package ua.fan.hw10;

import ua.fan.hw10.interfaces.Pow;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("\n---> TASK 2");
        Pow power = ((number, pow) -> {
            if (pow == 0) {
                number = 1;
                return number;
            } else if (pow > 0) {
                for (int i = 0; i < pow - 1; i++) {
                    number *= 2;
                }
                return number;
            } else {
                for (int i = 0; i > pow + 1; i--) {
                    number *= 2;
                }
                return 1.0 / number;
            }

        });
        double resultIfLessThan0 = power.pow(2, -3);
        double resultIf0 = power.pow(2, 0);
        double resultIfMoreThan0 = power.pow(2, 3);
        System.out.println("2^(-3) = " + resultIfLessThan0);
        System.out.println("2^0 = " + resultIf0);
        System.out.println("2^3 = " + resultIfMoreThan0);
    }
}
