package anonymousInterface.v6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App2 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(() -> {
//            System.out.println("Thread");
//        });
//        executorService.shutdown();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(getRunnable("hello"));
//        executorService.submit(getRunnable("momo"));
//        executorService.submit(getRunnable("bobo"));
//        executorService.submit(getRunnable("fofo"));
//        executorService.submit(getRunnable("lolo"));
//
//        executorService.shutdown();
        ScheduledExecutorService executorService =
                Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(getRunnable("hello"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
