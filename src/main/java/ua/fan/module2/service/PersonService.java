package ua.fan.module2.service;


import ua.fan.module2.model.Customer;

import static ua.fan.module2.Main.RANDOM;

public class PersonService {
    public static Customer createPerson() {
        return new Customer(Math.abs(RANDOM.nextLong()), generateRandomEmail(), RANDOM.nextInt(83) + 10);
    }

    private static String generateRandomEmail() {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz1234567890.";
        StringBuilder builder = new StringBuilder();
        while (builder.length() < 5) {
            int index = (int) (RANDOM.nextFloat() * alphanumeric.length());
            builder.append(alphanumeric.charAt(index));
        }
        return builder + "@gmail.com";
    }
}
