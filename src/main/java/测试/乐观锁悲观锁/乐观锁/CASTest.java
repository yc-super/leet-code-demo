package 测试.乐观锁悲观锁.乐观锁;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    private AtomicInteger account;

    public CASTest(int account) {
        this.account = new AtomicInteger(account);
    }

    public int withDraws(int count) {
        return account.addAndGet(-count);//底层是Unsafe类的CAS原子操作
    }

    public static void main(String[] args) throws InterruptedException {
        CASTest casTest = new CASTest(500);
        int countDownCount=100;
        CountDownLatch countDownLatch = new CountDownLatch(countDownCount);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(90));
        for (int i = 0; i < countDownCount; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    casTest.withDraws(5);
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();//等待所有线程都执行完毕后再执行下面的打印方法
        System.out.println("剩余的：" + casTest.account);// 剩余的：0
    }
}
