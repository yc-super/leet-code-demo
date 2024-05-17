package test.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int processNum = Runtime.getRuntime().availableProcessors();
        System.out.println(processNum);

       /* ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("业务名")
                .setDaemon(false)//线程池的守护线程状态为true
                .build();
        NamingThreadFactory factory = new NamingThreadFactory(new ThreadFactoryBuilder().build(), "人工研判管理线程池");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), factory);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    if (ii == 9) {
                        threadPoolExecutor.setCorePoolSize(3);
                    }
                    System.out.println(Thread.currentThread().getName() + "-" + ii + "开始运行。。。");
                    System.out.println(threadPoolExecutor.getCorePoolSize());
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-" + ii + "运行结束。。。");
                }
            });
        }
        threadPoolExecutor.shutdown();*/
//        try {
//            if(!threadPoolExecutor.awaitTermination(5,TimeUnit.MINUTES)){
//                System.out.println("线程池未能在5分钟内");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        while (!threadPoolExecutor.isTerminated()) {
//
//        }
//        System.out.println("finished all tasks");
    }

    /**
     * 打印线程池的状态
     *
     * @param threadPool 线程池对象
     */
    public static void printThreadPoolStatus(ThreadPoolExecutor threadPool) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                new ThreadFactoryBuilder().setNameFormat("print-images/thread-pool-status").setDaemon(false).build());
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("ThreadPool Size: [{}]", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks : {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }

}
