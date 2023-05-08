package 测试;

public class PrinterTest {
    public static void main(String[] args) {
        new Thread(new Printer(), "偶数线程，").start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Printer(), "奇数线程，").start();
    }

    private static int count = 0;
    private static final Object object = new Object();

    static class Printer implements Runnable {

        @Override
        public void run() {
            while (count <= 10) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "打印：" + count++);
                    object.notify();
                    try {
                        if (count <= 10) {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
