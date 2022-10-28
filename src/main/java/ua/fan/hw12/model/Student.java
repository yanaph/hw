package ua.fan.hw12.model;

import ua.fan.hw12.exceptions.NoPaperException;
import ua.fan.hw12.exceptions.NoPenException;
import ua.fan.hw12.exceptions.NoPencilException;

import java.util.Random;

public class Student {
    public void write() throws NoPaperException, NoPencilException, NoPenException {
        Random rand = new Random();
        int random;
        random = rand.nextInt(3) + 1;
        if (random == 1) {
            throw new NoPaperException("There is no paper to write on!");
        } else if (random == 2) {
            throw new NoPencilException("There is no pencil to write with!");
        } else {
            throw new NoPenException("There is no pen to write with!");
        }
    }

    public static void main(String[] args) {
        System.out.println("---> TASK 3:");
        Student student = new Student();
        try{
            student.write();
        } catch (NoPaperException | NoPenException | NoPencilException e) {
            System.out.println(e.getMessage());
        }
    }
}
