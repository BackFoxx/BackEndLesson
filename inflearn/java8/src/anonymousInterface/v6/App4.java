package anonymousInterface.v6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class App4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Future<String> future = executorService.submit(() -> "hello");
//        future.get();

//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.complete("keesun");
//
//        System.out.println(completableFuture.get());

//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("Hello");
//        });
//
//        future.get();

//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            return "hello";
//        }, executorService).thenApplyAsync((s) -> {
//            System.out.println(Thread.currentThread().getName());
//            return s.toUpperCase();
//        });
//        System.out.println(future.get());

//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello " + Thread.currentThread().getName());
//            return "hello";
//        });
//
//        CompletableFuture<String> future = hello.thenCompose(App4::getMomo);
//        System.out.println(future.get());

        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalStateException();
            }
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        }).exceptionally(ex -> {
//            System.out.println(ex);
            return "Error!";
        });

        CompletableFuture<String> momo = CompletableFuture.supplyAsync(() -> {
            if (throwError) throw new IllegalStateException();
            System.out.println("momo " + Thread.currentThread().getName());
            return "momo";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "error!";
            }
            return result;
        });

//        CompletableFuture<String> future = hello.thenCombine(momo, (h, m) -> {
//            return h + m;
//        });
//
//        System.out.println(future.get());

//        List<CompletableFuture<String>> futures = Arrays.asList(hello, momo);
//        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
//        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
//                .thenApply((v) ->
//                        futures.stream()
//                                .map(CompletableFuture::join)
//                                .collect(Collectors.toList())
//                );
//        results.get().forEach(System.out::println);

//        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, momo).thenAccept(s -> System.out.println(s));
//        future.get();

//        System.out.println(hello.get());
        System.out.println(momo.get());
    }

//    private static CompletableFuture<String> getMomo(String message) {
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("momo " + Thread.currentThread().getName());
//            return message + " momo";
//        });
//    }
}
