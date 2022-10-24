package ua.fan.hw10.entity;

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
}
