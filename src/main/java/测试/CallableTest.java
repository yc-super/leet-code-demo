package 测试;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Integer> task = new FutureTask<>(new MyThreadCallable());
//        new Thread(task,"A").start();
//        new Thread(task,"B").start();
//        System.out.println(task.get());

        System.out.println("--------------------------下面是Runnable");
        Thread thread = new Thread(new MyThreadRunnable());
        thread.start();
        thread.start();
    }

}
class MyThreadCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("_____________ffff");
        Thread.sleep(1000);
        return 1024;
    }
}

class MyThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("_____________ggggg");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
