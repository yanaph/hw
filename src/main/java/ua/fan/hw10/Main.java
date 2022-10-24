package ua.fan.hw10;

import ua.fan.hw10.entity.Aspirant;
import ua.fan.hw10.entity.Student;
import ua.fan.hw10.interfaces.Pow;

public class Main {
    public static void main(String[] args) {
        System.out.println("---> TASK 1");
        Student[] students = new Student[3];
        students[0] = new Student("Petro", "Ivanov", "CST-20-1", 4.5);
        students[1] = new Aspirant("Ivan", "Petrov", "CST-22-1", 5);
        students[2] = new Student("Ivan", "Ivanov", "CST-20-2", 5);

        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + "'s scholarship: " + student.getScholarship() + "uah");
        }

        System.out.println("\n---> TASK 2");
        Pow power = ((number, pow) -> {
            if (pow == 0) {
                number = 1;
                return number;
            } else if (pow > 0) {
                for (int i = 0; i < pow - 1; i++) {
                    number *= 2;
                }
                return number;
            } else {
                for (int i = 0; i > pow + 1; i--) {
                    number *= 2;
                }
                return 1.0 / number;
            }

        });
        double resultIfLessThan0 = power.pow(2, -3);
        double resultIf0 = power.pow(2, 0);
        double resultIfMoreThan0 = power.pow(2, 3);
        System.out.println("2^(-3) = " + resultIfLessThan0);
        System.out.println("2^0 = " + resultIf0);
        System.out.println("2^3 = " + resultIfMoreThan0);
    }
}
