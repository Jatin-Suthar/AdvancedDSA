package Concurrency;

public class PyramidPatternOverTwoThreads {
    public static void main(String[] args) throws InterruptedException {
        Worker worker1 = new Worker(true, 10);
        worker1.start();
        worker1.join();
        Worker worker2 = new Worker(false, 10);
        worker2.start();
    }
}

class Worker extends Thread {
    boolean increasing;
    int capacity;
    public Worker(boolean increasing, int capacity) {
        this.increasing = increasing;
        this.capacity = capacity;
    }
    @Override
    public void run() {
        if(increasing) {
            for(int i = 1; i <= this.capacity; i++) {
                int t = i;
                while(t--!=0) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else {
            for(int i = 1; i <= this.capacity; i++) {
                int t = this.capacity-i;
                while(t--!=0) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
