package com.company;
/**
 * Created by nela on 26.5.2015..
 */

public class Main {
    private static final int NO_PHILOSOPHERS = 5;
    private static final int TIME_TO_RUN = 5 * 1000;

    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosophers = new Philosopher[NO_PHILOSOPHERS];
        Fork[] forks = new Fork[NO_PHILOSOPHERS];

        try {
            for (int i = 0; i < NO_PHILOSOPHERS; i++) {
                forks[i] = new Fork(i);
            }

            for (int i = 0; i < NO_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % NO_PHILOSOPHERS]);
                philosophers[i].start();
            }

            Thread.sleep(TIME_TO_RUN);

            for(int i = 0; i < NO_PHILOSOPHERS; i++){
                philosophers[i].isHungry = false;
            }
        }
        catch (Exception e){
        }
        finally {
            for(int i = 0; i < NO_PHILOSOPHERS; i++){
                philosophers[i].join();
                System.out.println(philosophers[i] + " had eaten " + philosophers[i].getNoEaten() + " times" );
            }
        }
    }
}
