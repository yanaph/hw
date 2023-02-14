package ua.fan.hw31.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public
class HelloThread extends Thread{
    private Integer number;
    @Override
    public void run() {
        System.out.println("Hello from thread " + number);
    }
}
