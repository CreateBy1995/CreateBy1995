package main;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-18
 **/
@Slf4j
public class MainApplication {
    public static void main(String[] args) {
        test("exit");
//        Supplier<CompletableFuture> supplier = CompletableFuture::new;
//        CompletableFuture completableFuture = supplier.get();
//
//        completableFuture.complete("s");
//        BlockingQueue blockingQueue = new LinkedBlockingQueue<Runnable>(10);
//        ExecutorService executorService =  new ThreadPoolExecutor(3, 3,
//                0L, TimeUnit.MILLISECONDS,
//                blockingQueue);
//        for (int i = 0; i < 3; i++) {
//            executorService.execute(()->{
//                System.out.println("run");
//                try {
//                    TimeUnit.MILLISECONDS.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        try {
//            TimeUnit.MILLISECONDS.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        IntStream.of(1,2,3).parallel().forEach(item -> {
//            executorService.execute(() -> System.out.println(item));
//            int count = ((ThreadPoolExecutor)executorService).getActiveCount();
//            log.info("当前队列任务数:{}, 当前活跃线程数:{}",blockingQueue.size(),count);
//        });
//


//        completableFuture.
//        FutureTask<String> futureTask = new FutureTask<>(() -> "hello");
//        new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
    public static  void test(String msg){
     if(msg.length() >2){
            outCondition:  if (msg.equals("exit")){
                break outCondition;
            }
            System.out.println(2);
        }else if(msg.length() >3){
            System.out.println(3);

        }    }
}
