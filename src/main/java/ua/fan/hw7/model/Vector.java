package ua.fan.hw7.model;

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

    public Vector calculateAdditionOfVectors(Vector b) {
        return new Vector(x + b.getX(), y + b.getY(), z + b.getZ());
    }

    public Vector calculateSubtractionOfVectors(Vector b){
        return new Vector(x - b.getX(), y - b.getY(), z - b.getZ());
    }
}
