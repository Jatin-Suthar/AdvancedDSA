package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class StarPattern {
    private final ReentrantLock lock = new ReentrantLock();
    private int lines = 1;  // Tracks the current number of stars to print
    private boolean ascending = true;  // Direction of the pattern

    public void printPattern() {
        ExecutorService executor = Executors.newFixedThreadPool(2);  // Thread pool with two threads

        // Thread for increasing stars
        executor.submit(() -> {
            while (lines < 11) {
                lock.lock();
                try {
                    if (ascending) {
                        printStars(lines);
                        lines++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        // Thread for decreasing stars
        executor.submit(() -> {
            while (lines > 0) {
                lock.lock();
                try {
                    if (!ascending) {
                        printStars(lines);
                        lines--;
                    }
                } finally {
                    lock.unlock();
                }
            }
            executor.shutdown();
        });

        // Switch the direction after the increase phase completes
        try {
            Thread.sleep(100);  // Wait for the increasing thread to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ascending = false;  // Change direction to decreasing
    }

    private void printStars(int numStars) {
        for (int i = 0; i < numStars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new StarPattern().printPattern();
    }
}
