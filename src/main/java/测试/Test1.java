package 测试;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static final String LOCK = "LOCK";

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(LOCK){
                    while(count==FULL){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产，目前总共有："+count);
                    LOCK.notifyAll();
                }
            }

        }
    }

    class Consumer implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有：" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        new Thread(test.new Producer()).start();
//        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
//        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }
}
