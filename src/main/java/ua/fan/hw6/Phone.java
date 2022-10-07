package ua.fan.hw6;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this(number, model, 150);
    }

    public Phone() {
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void receiveCall(String name){
        System.out.printf("%s is calling ...\n", name);
    }

    @Override
    public String toString() {
        return String.format("\nnumber: %s " +
                "\nmodel: %s" +
                "\nweight: %.2f g ", number, model, weight);
    }
}
