package Concurrency;

import static Concurrency.ServiceImpl.produce;

public class ServiceThread {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread producer = new Thread(() -> produce(new JsonNode("Person: " + finalI)));
            producer.start();
            producer.join();
        }
    }

}
