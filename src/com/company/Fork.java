package com.company;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by nela on 26.5.2015..
 */

public class Fork {
    private int id;
    private final Lock lock = new ReentrantLock(true);

    public Fork(int id) {
        this.id = id;
    }

    public boolean pickUp() throws InterruptedException {
        if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
            return true;
        }
        return false;
    }

    public void putDown() {
        lock.unlock();
    }
}
