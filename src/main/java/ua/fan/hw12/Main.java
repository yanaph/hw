package ua.fan.hw12;

public class Main {
    public static void main(String[] args) {
        System.out.printf("---> TASK 1:%n");
        try{
            printPositiveNum(-2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("It's a finally block");
        }
    }

    public static void printPositiveNum (int a) throws Exception {
        if (a<0){
            throw new Exception("Number is not positive");
        } else {
            System.out.printf("Positive number: %d%n", a);
        }
    }
}
