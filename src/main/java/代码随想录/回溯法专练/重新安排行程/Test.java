package 代码随想录.回溯法专练.重新安排行程;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
        //设置可用信号量为3
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    //从信号量中获取许可证
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"获取到了许可证！");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"释放了许可证！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放给定数量的许可证到信号量中
                    semaphore.release();
                }
            },i+"").start();
        }
    }
}

