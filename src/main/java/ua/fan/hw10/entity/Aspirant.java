package ua.fan.hw10.entity;

import java.util.Objects;

public class Aspirant extends Student {
    String scientificWorkName;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWorkName) {
        super(firstName, lastName, group, averageMark);
        this.scientificWorkName = scientificWorkName;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aspirant aspirant = (Aspirant) o;
        return Objects.equals(scientificWorkName, aspirant.scientificWorkName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scientificWorkName);
    }
}
