package anonymousInterface.v6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> momo = () -> {
            Thread.sleep(3000L);
            return "momo";
        };

        Callable<String> lolo = () -> {
            Thread.sleep(1000L);
            return "lolo";
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, momo, lolo));
//        for (Future<String> future : futures) {
//            System.out.println(future.get());
//        } // 쓰레드들 다 끝날 때까지 기다림

        String s = executorService.invokeAny(Arrays.asList(hello, momo, lolo));
        System.out.println(s);

//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println(helloFuture.isDone());
//
//        System.out.println("Started!");
//        helloFuture.cancel(true); // 블록킹 콜
//        System.out.println("End!!");
//
//        System.out.println(helloFuture.isDone());
        executorService.shutdown();
    }
}
