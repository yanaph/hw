package ua.fan.hw2;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("-------- TASK 1 --------");
        System.out.println("Coordinates of triangle vertices:");
        double[] x = {1, 3, 6};
        double[] y = {5, 5, 7};
        printCoordinates(x, y);
        System.out.println("S = " + triangleSquare(x, y));
    }

    private static double triangleSquare(double[] x, double[] y) {
        return 0.5 * Math.abs((x[1] - x[0]) * (y[2] - y[0]) - (x[2] - x[0]) * (y[1] - y[0]));
    }

    private static void printCoordinates(double[] x, double[] y) {
        for (int i = 0; i < 3; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i] + ", y" + (i + 1) + " = " + y[i]);
        }
    }
}
