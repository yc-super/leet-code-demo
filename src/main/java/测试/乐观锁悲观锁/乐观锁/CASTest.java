package 测试.乐观锁悲观锁.乐观锁;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

   /* public static void main(String[] args) throws InterruptedException {
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
    }*/

    public static void main(String[] args) throws InterruptedException {
        //创建一个强引用
        String strHeap = new String("hello");
        String strStatic = "test";
        //创建引用队列, <String>为范型标记，表明队列中存放String对象的引用
        ReferenceQueue<String> rq = new ReferenceQueue<String>();
        //创建一个弱引用，它引用"hello"对象，并且与rq引用队列关联
        //创建一个对象的弱引用
        WeakReference<String> wf1 = new WeakReference<String>(strHeap, rq);
        WeakReference<String> wf2 = new WeakReference<String>(strStatic, rq);
        strHeap = null; //④取消"hello"对象的强引用
        strStatic = null;
        System.out.println(wf1.get() + "   " + wf2.get());//hello   test
        System.gc(); //⑤
        System.gc(); //⑥
        Thread.sleep(5000L);
        //回收的是弱引用中的对象，而不是弱引用本身
        //弱引用指向的对象被回收了，这弱引用会被放入ReferenceQueue中
        //因为strHeap是堆中的对象（会被gc回收），而strStatic字符串常量（不会被gc回收），所以wf1中引用被gc，wf2并没有
        System.out.println(wf1.get() + "   " + wf2.get());//null   test
        System.out.println(rq.poll().get());//null
        Thread.sleep(1000L);
        Reference<? extends String> poll = rq.poll();//null
        System.out.println(poll.get());
    }
}
