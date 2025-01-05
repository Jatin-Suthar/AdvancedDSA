package Concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServiceImpl {
    static final BlockingQueue<JsonNode> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Thread producer1 = new Thread(() -> produce(new JsonNode("Jatin")));
        Thread producer2 = new Thread(() -> produce(new JsonNode("Jayesh")));
        Thread producer3 = new Thread(() -> produce(new JsonNode("Bhavesh")));
        Thread producer4 = new Thread(() -> produce(new JsonNode("Sumit")));

        Thread consumer = new Thread(() -> {
            try {
                consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        });

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();

        consumer.start();

        producer1.join();
        producer2.join();
        producer3.join();
        producer4.join();

        consumer.join();
    }

    public static void produce(JsonNode data) {
        try {
            queue.put(data);
            System.out.println(data.getData() + " Produced successfully >>>>>");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted while waiting to put data");
        }
    }

    private static void consume() throws InterruptedException {
        while (!Thread.interrupted()) {
            JsonNode data = queue.take();
            data.acknowledgedMessage();
            System.out.println("<<<<< " + data.getData() + " Consumed and Acknowledged successfully.");
            if(queue.isEmpty()) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
