package 场景题.线程安全的单例模式;

public class Singleton {
    // volatile保证可见性和禁止指令重排序
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        // 双重检查减少开销
        if (instance == null) { // 第一次检查
            synchronized (Singleton.class) {
                if (instance == null) { // 第二次检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

class MySingleton {
    private MySingleton() {
    }

    private static class Holder {
        static final MySingleton INSTANCE = new MySingleton();
    }

    public MySingleton getInstance() {
        return Holder.INSTANCE;
    }
}
