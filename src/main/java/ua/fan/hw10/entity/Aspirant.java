package ua.fan.hw10.entity;

public class Aspirant extends Student {
    public Aspirant(String firstName, String lastName, String group, double averageMark) {
        super(firstName, lastName, group, averageMark);
    }

    public int getScholarship() {
        if (getAverageMark() == 5) {
            return 200;
        } else {
            return 180;
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
