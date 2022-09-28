package 测试;

import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class ceshi10 {
    public static void main(String[] args) {
        AtomicInteger integer=new AtomicInteger();
        boolean b = integer.compareAndSet(1, 2);
        System.out.println(b);
    }
}
