package main;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-26
 **/
@Data
public class TestObj {
    private byte[] bytes = new byte[1024*1024*50];
    public void sayHello(){
        new TestThread().start();
    }
    public  class TestThread extends Thread{
        @Override
        public void run() {
           while (true){
               try {
                   TimeUnit.SECONDS.sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("run");
           }
        }
    }
}
