package ua.fan.hw14;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MySet<T> {
    private final T[] array;

    public MySet(Class<T> t, int capacity) {
        array = (T[]) Array.newInstance(t, capacity);
    }

    private void add(T t) {
        if (isUnique(t)){
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = t;
                    break;
                }
            }
        }
    }

    private T get(int index) {
        return array[index];
    }

    private boolean isUnique(T t) {
        for (T value : array) {
            if (compare(value, t)) {
                return false;
            }
        }
        return true;
    }

    public boolean compare (T t1, T t2){
        if (t1.hashCode() == t2.hashCode()){
            return t1.equals(t2);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MySet<Integer> mySet = new MySet<>(Integer.class, 3);
        System.out.println(mySet);
        mySet.add(5);
        mySet.add(3);
        mySet.add(3);
        mySet.add(4);
        mySet.add(6);
        System.out.println(mySet);
        System.out.println("array[0] = " + mySet.get(0));
        System.out.println("array[2] = " + mySet.get(2));
    }
}