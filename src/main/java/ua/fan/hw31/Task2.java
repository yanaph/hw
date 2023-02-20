package ua.fan.hw31;

import ua.fan.hw31.utils.CountPrimeNumUtil;

public class Task2 {
    public static void main(String[] args) {
        CountPrimeNumUtil countPrimeNumUtil = new CountPrimeNumUtil();
        try {
            countPrimeNumUtil.mainThread(10);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
