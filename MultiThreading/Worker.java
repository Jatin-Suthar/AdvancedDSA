package MultiThreading;

public class Worker implements Runnable {

    static int counter;

    @Override
    public void run() {
        if(counter>=100) return;
        counter = counter+1;
        System.out.println(counter);
    }
}
