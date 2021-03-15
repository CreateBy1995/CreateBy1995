package main;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-19
 **/
@Slf4j
public class MainApplication {
    public static void main(String[] args) {
        testCompletableFuture();
    }

    public static void testCompletableFuture() {
        System.out.println((1 << 29) - 1);
        for (int i = 0; i <  100000; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(10));
            threadPoolExecutor.execute(()-> System.out.println("ok"));
            threadPoolExecutor.shutdown();
        }
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//
//        completableFuture.whenComplete(function);
//        completableFuture.whenComplete(function);
//        Consumer<String> consumer = result ->  log.info("result : {}, currentThread : {} ", result, Thread.currentThread().getName());
//        Function<String, String> function = result -> result + "- wrapper";
//        completableFuture.thenApply(function).thenApply(function);

//        completableFuture.thenApply(function);
//        completableFuture.thenAccept(consumer);
//        completableFuture.thenAccept(consumer);
//        log.info("complete the completableFuture, currentThread : {}",
//                Thread.currentThread().getName());
//        completableFuture.whenComplete((r,v)->log.info("wc2"));
//        completableFuture.whenComplete((r,v)->log.info("wc22"));
//        completableFuture.whenComplete((r,v)->log.info("wc222"));
//        CompletableFuture completableFuture1 = completableFuture.whenComplete((r,v)->log.info("wc1"));
//        completableFuture1.whenComplete((r,v)->log.info("wc11"));
//        completableFuture1.whenComplete((r,v)->log.info("wc111"));
//        completableFuture1.whenComplete((r,v)->log.info("wc1111"));
//        completableFuture.whenComplete((r,v)->log.info("wc2"));
//        completableFuture.complete("success");
//        completableFuture1.complete("success");
//        completableFuture.whenComplete(biConsumer);
    }
}
