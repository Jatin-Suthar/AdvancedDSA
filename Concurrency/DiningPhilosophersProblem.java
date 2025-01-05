package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersProblem {

    private static class Chopstick {

        private Lock lock = new ReentrantLock();

        public void pickUp() {
            lock.lock();
        }

        public void putDown() {
            lock.unlock();
        }

    }

    private static class Philosopher extends Thread {
        private int id;
        private Chopstick leftChopstick;
        private Chopstick rightChopstick;

        public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
            this.id = id;
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        public void run() {
            try {
                while (true) {
                    System.out.println("Philosopher " + id + " is thinking");
                    Thread.sleep((int) (Math.random() * 1000));
                    System.out.println("Philosopher " + id + " is hungary");
                    if(id%2 == 0) {
                        leftChopstick.pickUp();
                        rightChopstick.pickUp();
                    } else {
                        rightChopstick.pickUp();
                        leftChopstick.pickUp();
                    }
                    System.out.println("Philosopher " + id + " is eating");
                    Thread.sleep((int) (Math.random() * 1000));
                    leftChopstick.putDown();
                    rightChopstick.putDown();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Chopstick[] chopsticks = new Chopstick[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numPhilosophers]);
            philosophers[i].start();
        }
    }

}
