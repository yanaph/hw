package ua.fan.hw10;

import ua.fan.hw10.entity.Aspirant;
import ua.fan.hw10.entity.Student;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("---> TASK 1");
        Student[] students = new Student[3];
        students[0] = new Student("Petro", "Ivanov", "CST-20-1", 4.5);
        students[1] = new Aspirant("Petro", "Ivanov", "CST-20-1", 4.5);
        students[2] = new Student("Ivan", "Ivanov", "CST-20-2", 5);

        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + "'s scholarship: " + student.getScholarship() + "uah");
        }

        System.out.println("---> COMPARING");
        Student student = new Student("Ivan", "Ivanov", "CST-20-2", 5);
        System.out.println("Student P.Ivanov and aspirant P.Ivanov: " + students[0].compare(students[1]));
        System.out.println("Student I.Ivanov and student I.Ivanov: " + students[2].compare(student));
    }
}
