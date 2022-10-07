package ua.fan.hw7;

import ua.fan.hw7.model.Vector;

public class Main {
    public static void main(String[] args) {
        Vector[] vectors = Vector.generateArrayOfVectors(2);
        printArrayOfVectors(vectors);
        printCalculations(vectors);
    }

    private static void printCalculations(Vector[] vectors) {
        System.out.println("---> LENGTH:");
        for (int i = 0; i < vectors.length; i++) {
            System.out.printf("|vectors[%d]| = %f%n", i, vectors[i].calculateLength());
        }

        System.out.printf("---> DOT PRODUCT: %f%n",vectors[0].calculateDotProduct(vectors[1]));
        System.out.printf("---> CROSS PRODUCT: %s",formatVectorsCoordinates(vectors[0].calculateCrossProduct(vectors[1])));
        System.out.printf("---> COS OF ANGLE: %f%n",vectors[0].calculateCosOfAngleBetweenVectors(vectors[1]));
        System.out.print("---> ADDITION: " + formatVectorsCoordinates(vectors[0].calculateAdditionOfVectors(vectors[1])));
        System.out.print("---> SUBTRACTION: " + formatVectorsCoordinates(vectors[0].calculateSubtractionOfVectors(vectors[1])));
    }

    private static void printArrayOfVectors(Vector[] vectors) {
        System.out.println("---> COORDINATES:");
        for (Vector vector : vectors) {
            System.out.print(formatVectorsCoordinates(vector));
        }
    }

    private static String formatVectorsCoordinates(Vector vector) {
        return String.format("x = %5.2f, y = %5.2f, z = %5.2f%n", vector.getX(), vector.getY(),vector.getZ());
    }
}
