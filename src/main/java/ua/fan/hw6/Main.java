package ua.fan.hw6;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("+380 (67) 777 77 77", "s21", 171.5);
        Phone phone2 = new Phone("+380 (89) 999 99 99", "s10");
        Phone phone3 = new Phone();

        phone3.setNumber("+380 (93) 333 33 33");
        phone3.setModel("s22");
        phone3.setWeight(180.25);

        System.out.println("\n---> PHONE #1: " + phone1);
        System.out.println("\n---> PHONE #2: " + phone1);
        System.out.println("\n---> PHONE #3: " + phone1);


        System.out.println("\n---> RECEIVE CALL");
        phone1.receiveCall("Emily");
        phone2.receiveCall("Sarah");
        phone3.receiveCall("Ann");

        System.out.println("\n---> GET NUMBER");
        System.out.println("#1: " + phone1.getNumber());
        System.out.println("#2: " + phone2.getNumber());
        System.out.println("#3: " + phone3.getNumber());
    }
}
