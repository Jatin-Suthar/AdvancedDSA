package ThreadTest;

public class MaximumThread {
    public static void main(String[] args) {
        System.out.println("Main thread started - " + Thread.currentThread());
        for(int i=0; i<10000; i++) {
           new Thread(MaximumThread::handleNewThread).start();
        }
        System.out.println("Main thread ended -   " + Thread.currentThread());
    }
    public static void handleNewThread() {
        System.out.println("New thread started - " + Thread.currentThread());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("New thread ended -   " + Thread.currentThread());
    }
}
