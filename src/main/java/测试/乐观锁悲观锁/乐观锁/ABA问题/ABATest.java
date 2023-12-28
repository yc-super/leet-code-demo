package 测试.乐观锁悲观锁.乐观锁.ABA问题;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABATest {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(100);
        Integer num = 100;
        Integer num2 = 200;
        AtomicStampedReference<Integer> atomicStampedreference = new AtomicStampedReference<>(num, 0);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程1开始执行。。。");
//                integer.compareAndSet(100,200);
//                integer.compareAndSet(200,100);
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("线程2开始执行。。。");
//                boolean b = integer.compareAndSet(100, 200);
//                if(b){
//                    System.out.println("线程2修改成功");
//                }
//            }
//        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("线程3开始执行。。。");
                int stamp = atomicStampedreference.getStamp();
                System.out.println("线程3stamp:" + atomicStampedreference.getStamp());
                boolean b1 = atomicStampedreference.compareAndSet(num, num2, stamp, ++stamp);
                System.out.println("线程3stamp:" + atomicStampedreference.getStamp());
                boolean b = atomicStampedreference.compareAndSet(num2, num, stamp, ++stamp);
                System.out.println("线程3stamp:" + atomicStampedreference.getStamp());
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                int stamp = atomicStampedreference.getStamp();
                System.out.println("线程4stamp:" + stamp);
                TimeUnit.SECONDS.sleep(3);// 这里休眠是为了让线程3开始执行，模拟ABA问题
                System.out.println("线程4开始执行。。。");
                System.out.println("线程4期望stamp:"+stamp+"，实际stamp:"+ + atomicStampedreference.getStamp());
                boolean b = atomicStampedreference.compareAndSet(num, num2, stamp, stamp+1);
                if (b) {
                    System.out.println("线程4修改成功");
                } else {
                    System.out.println("线程4修改失败");
                }
            }
        }).start();
    }
}
