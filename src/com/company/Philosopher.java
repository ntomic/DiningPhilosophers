package com.company;
import java.util.Random;
/**
 * Created by nela on 26.5.2015..
 */

public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    public boolean isHungry = true;
    private Random random = new Random();
    private int noEaten = 0;

    public Philosopher(int id, Fork leftFork, Fork rightFork){
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println(this + " thinks");
        Thread.sleep(random.nextInt(50));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " eats");
        Thread.sleep(random.nextInt(50));
    }

    @Override
    public void run(){
        while (isHungry){
            try {
                think();
                if (leftFork.pickUp()){
                    if(rightFork.pickUp()){
                        eat();
                        rightFork.putDown();
                        noEaten++;
                    }
                    leftFork.putDown();
                }
            } catch (InterruptedException e) {
              }
        }
        System.out.println(this + " exits");
    }

    @Override
    public String toString(){
        return "Philosopher-" + id;
    }
    public int getNoEaten(){
        return noEaten;
    }
}
