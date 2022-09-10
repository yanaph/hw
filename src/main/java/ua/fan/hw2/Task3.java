package ua.fan.hw2;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("-------- TASK 2 --------");
        int num = 7;
        isEven(num);
    }

    private static void isEven(int a) {
        if (a % 2 == 0) {
            System.out.println("Number " + a + " is even!");
        } else {
            System.out.println("Number " + a + " is odd!");
        }
    }
}
