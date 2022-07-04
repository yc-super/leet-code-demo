package 测试;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ceshi8 {
    public static void main(String[] args) {
        String s="123";
        String substring = s.substring(0, 1);
        System.out.println(substring);

    }
}
class A extends Thread{
    @Override
    public void run() {
        System.out.println("A线程");
    }
}
