package ua.fan.hw7.model;

import java.util.Random;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double calculateLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double calculateDotProduct(Vector b) {
        return x * b.getX() + y * b.getY() + z * b.getZ();
    }

    public double calculateCosOfAngleBetweenVectors(Vector b) {
        return calculateDotProduct(b) / (calculateLength() * b.calculateLength());
    }

    public Vector calculateCrossProduct(Vector b) {
        return new Vector(y * b.getZ() - b.getY() * z, b.getX() * z - x * b.getZ(), x * b.getY() - b.getX() * y);
    }

    public Vector calculateAdditionOfVectors(Vector b) {
        return new Vector(x + b.getX(), y + b.getY(), z + b.getZ());
    }

    public Vector calculateSubtractionOfVectors(Vector b) {
        return new Vector(x - b.getX(), y - b.getY(), z - b.getZ());
    }

    public static Vector[] generateArrayOfVectors(int n) {
        Vector[] array = new Vector[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = new Vector(random.nextDouble(20) - 10, random.nextInt(20) - 10, random.nextInt(20) - 10);
        }
        return array;
    }
}
