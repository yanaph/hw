package ua.fan.hw12.model;

import java.util.Optional;

public class PhoneBook {
    private static final String[] PHONE_BOOK = new String[3];
    public static void main(String[] args) {
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";

        printSearchResults(findIndexByPhoneNumber("016/161617"));
    }
    public static Optional<Integer> findIndexByPhoneNumber(String phoneNumber){
        for (int i = 0; i < PHONE_BOOK.length; i++) {
            if (PHONE_BOOK[i].equals(phoneNumber)){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static void printSearchResults (Optional<Integer> index){
        if (index.isEmpty()){
            System.out.println("There is no such phone number in the book");
        } else {
            System.out.println("The number is saved by index " + index.get());
        }
    }
}
