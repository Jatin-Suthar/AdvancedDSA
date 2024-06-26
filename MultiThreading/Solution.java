package MultiThreading;

public class Solution {
    public static void main(String[] args) {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        Worker worker3 = new Worker();
        while(Worker.counter<100) {
            worker1.run();
            worker2.run();
            worker3.run();
        }
    }

}
