package 测试.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
//    // countDownLatch用法1，某一个线程在开始运行前等待n个线程执行完毕，之后再开始运行
//    // 下面的例子中，线程2在等待线程1和3运行后才运行
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===线程1执行。。。");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===线程2执行。。。");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===线程3执行。。。");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();//main线程等待上面的线程1和3执行完毕后才能继续执行。如果没有这行代码，下面的main线程代码将先于上面的线程执行
        System.out.println("===main");
    }

    // CountDownLatch用法2，实现多个线程的最大并行性，尽最大可能让线程1,2,3同时唤醒
//    public static void main(String[] args) {
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("===线程1执行");
//        }).start();
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("===线程2执行");
//        }).start();
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("===线程3执行");
//        }).start();
//        System.out.println("main线程countDown...");
//        countDownLatch.countDown();
//    }
}
