package MultiThreading;

import java.util.concurrent.CompletableFuture;

import static MultiThreading.WorkerThread.increaseCounter;

public class JobSchedule {

    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(WorkerThread::increaseCounter);
//        CompletableFuture<Void> future2 = CompletableFuture.runAsync(WorkerThread::increaseCounter);
//        CompletableFuture<Void> future3 = CompletableFuture.runAsync(WorkerThread::increaseCounter);
//        CompletableFuture<Void> future4 = CompletableFuture.runAsync(WorkerThread::increaseCounter);
        future1.handle(
                (res, ex) -> {
                    if(ex != null) {
                        throw new RuntimeException(ex);
                    } else {
                        System.out.println(res);
                        return res;
                    }
                }
        );
    }

}

class WorkerThread {

    static int counter = 0;

    synchronized static int increaseCounter() {
        counter++;
        System.out.println(counter);
        return counter;
    }

}