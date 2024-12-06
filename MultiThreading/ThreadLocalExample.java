package MultiThreading;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " Initial Value: " + threadLocal.get());
            threadLocal.set((int) (Math.random() * 100));
            System.out.println(Thread.currentThread().getName() + " Updated Value: " + threadLocal.get());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
