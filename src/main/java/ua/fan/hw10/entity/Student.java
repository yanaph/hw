package ua.fan.hw10.entity;

import java.util.Objects;

public class Student {
    private final String firstName;
    private final String lastName;
    private String group;
    private double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public String getGroup() {
        return group;
    }


    public int getScholarship(){
        if (averageMark == 5){
            return 100;
        } else {
            return 80;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.averageMark, averageMark) == 0 && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, group, averageMark);
    }

    public boolean compare (Student student){
        if (this.hashCode() == student.hashCode()){
            return this.equals(student);
        } else {
            return false;
        }
    }
}
