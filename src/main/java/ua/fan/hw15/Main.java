package ua.fan.hw15;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Petro");
        names.add("Alina");
        names.add("Olena");

        System.out.println("---> FOR LOOP");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println("---> FOR-EACH LOOP");
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("---> WHILE LOOP");
        int index = 0;
        while (names.size() > index) {
            System.out.println(names.get(index));
            index++;
        }

        System.out.println("---> ITERATOR");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
