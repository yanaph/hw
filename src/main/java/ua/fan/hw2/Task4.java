package ua.fan.hw2;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("\n-------- TASK 3 --------");
        int num1 = -7, num2 = 15, num3 = -27;
        System.out.println("Among such numbers: " + num1 + ", " + num2 + ", " + num3 + "");
        System.out.println(minAbs(num1, num2, num3) + " has the smallest absolute value.");
    }

    public static int minAbs(int a, int b, int c) {

        if (abs(a) < abs(b) && abs(a) < abs(c)) {
            return a;
        } else if (abs(b) < abs(a) && abs(b) < abs(c)) {
            return b;
        } else {
            return c;
        }
    }

    public static int abs(int number) {
        return number <= 0 ? -number : number;
    }
}
