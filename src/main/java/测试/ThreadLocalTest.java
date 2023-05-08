package 测试;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=new ThreadLocal<>();
        threadLocal.set("main");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程的值："+threadLocal.get());
            }
        }).start();
        System.out.println("主线程的值："+threadLocal.get());
    }
}
