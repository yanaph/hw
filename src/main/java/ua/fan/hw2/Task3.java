package ua.fan.hw2;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("-------- TASK 2 --------");
        int num = 7;
        if (isEven(num)) {
            System.out.println("Number " + num + " is even!");
        } else {
            System.out.println("Number " + num + " is odd!");
        }
    }

    public static boolean isEven(int a) {
        return a % 2 == 0;
    }
}
